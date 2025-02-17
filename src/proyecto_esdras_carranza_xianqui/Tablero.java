/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Tablero extends JPanel {
Color lightBlue = new Color(0xADD8E6);

    private static Tablero instancia;
    private static final int CELL_SIZE = 50;
    private static final int ROWS = 11;
    private static final int COLS = 9;
    private JButton[][] botones = new JButton[ROWS][COLS];
    private JButton piezaSeleccionada = null;
    private int filaSeleccionada, columnaSeleccionada;
    private celda[][] tableroEstado = new celda[ROWS][COLS];
    private movimiento_torre xd = new movimiento_torre();
    private boolean turnoRojo = true;
    private JLabel turnoLabel;

    private List<JLabel> piezasCapturadasRojas = new ArrayList<>();
    private List<JLabel> piezasCapturadasNegras = new ArrayList<>();
    private JPanel panelCapturasRojas;
    private JPanel panelCapturasNegras;
    JButton botonRendirse = new JButton("Rendirse");
    String jugador = partidas.getInstance().getJugador_1();

    public static Tablero getInstance() {
        if (instancia == null) {
            instancia = new Tablero();
        }
        return instancia;
    }
    
    private JTextArea movimientosArea;

    public Tablero() {
        setLayout(new BorderLayout());
        inicializarEstadoTablero();

        
        JPanel panelTablero = new JPanel(new GridLayout(ROWS, COLS));

        panelCapturasRojas = new JPanel(new GridLayout(5, 2));
        panelCapturasNegras = new JPanel(new GridLayout(5, 2));

        JScrollPane scrollRojas = new JScrollPane(panelCapturasRojas);
        JScrollPane scrollNegras = new JScrollPane(panelCapturasNegras);
        scrollRojas.setPreferredSize(new Dimension(100, ROWS * CELL_SIZE));
        scrollNegras.setPreferredSize(new Dimension(100, ROWS * CELL_SIZE));

        add(scrollRojas, BorderLayout.WEST);
        add(panelTablero, BorderLayout.CENTER);
        add(scrollNegras, BorderLayout.EAST);

        turnoLabel = new JLabel("Turno de " + partidas.getInstance().getJugador_1());
        turnoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        turnoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnoLabel.setPreferredSize(new Dimension(300, 50));
        turnoLabel.setOpaque(true); // Permitir color de fondo
        turnoLabel.setBackground(Color.red);
        add(turnoLabel, BorderLayout.NORTH);

        botonRendirse.setFont(new Font("Arial", Font.BOLD, 16));
        botonRendirse.setBackground(Color.RED);
        botonRendirse.setForeground(Color.WHITE);
        botonRendirse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rendirse();

            }
        });
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());

        movimientosArea = new JTextArea();
        movimientosArea.setEditable(false);
        movimientosArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollMovimientos = new JScrollPane(movimientosArea);
        scrollMovimientos.setPreferredSize(new Dimension(400, 70));

        panelInferior.add(scrollMovimientos, BorderLayout.CENTER);
        panelInferior.add(botonRendirse, BorderLayout.SOUTH);
        add(panelInferior, BorderLayout.SOUTH);

        inicializarTablero(panelTablero, movimientosArea);
    }

    public void registrarMovimiento(String movimiento) {
        movimientosArea.append(movimiento + "\n");
        movimientosArea.setCaretPosition(movimientosArea.getDocument().getLength());
    }

    private void inicializarTablero(JPanel panelTablero, JTextArea movimientosArea) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
                botones[i][j].setEnabled(false);
                botones[i][j].setEnabled(i != 5);

                if (i == ROWS / 2) {
                    botones[i][j].setBackground(Color.BLUE);
                } else if ((i + j) % 2 == 0) {
                    botones[i][j].setBackground(new Color(222, 184, 135));
                } else {
                    botones[i][j].setBackground(new Color(139, 69, 19));
                }

                botones[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                // Crear ButtonClickListener con movimientosArea
                botones[i][j].addActionListener(new ButtonClickListener(i, j, movimientosArea));

                panelTablero.add(botones[i][j]);
            }
        }
        colocarPiezas();
    }

    private void colocarPiezas() {
        colocarPieza(7, 0, "English-Pawn-Red.png");
        colocarPieza(7, 2, "English-Pawn-Red.png");
        colocarPieza(7, 4, "English-Pawn-Red.png");
        colocarPieza(7, 6, "English-Pawn-Red.png");
        colocarPieza(7, 8, "English-Pawn-Red.png");
        colocarPieza(8, 1, "English-Cannon-Red.png");
        colocarPieza(8, 7, "English-Cannon-Red.png");
        colocarPieza(10, 0, "English-Rook-Red.png");
        colocarPieza(10, 8, "English-Rook-Red.png");
        colocarPieza(10, 1, "English-Horse-Red.png");
        colocarPieza(10, 7, "English-Horse-Red.png");
        colocarPieza(10, 6, "English-Elephant-Red.png");
        colocarPieza(10, 2, "English-Elephant-Red.png");
        colocarPieza(10, 3, "English-Advisor-Red.png");
        colocarPieza(10, 5, "English-Advisor-Red.png");
        colocarPieza(10, 4, "English-King-Red.png");
        colocarPieza(0, 0, "English-Rook-Black.png");
        colocarPieza(3, 0, "English-Pawn-Black.png");
        colocarPieza(3, 2, "English-Pawn-Black.png");
        colocarPieza(3, 4, "English-Pawn-Black.png");
        colocarPieza(3, 6, "English-Pawn-Black.png");
        colocarPieza(3, 8, "English-Pawn-Black.png");
        colocarPieza(2, 1, "English-Cannon-Black.png");
        colocarPieza(2, 7, "English-Cannon-Black.png");
        colocarPieza(0, 1, "English-Horse-Black.png");
        colocarPieza(0, 7, "English-Horse-Black.png");
        colocarPieza(0, 8, "English-Rook-Black.png");
        colocarPieza(0, 2, "English-Elephant-Black.png");
        colocarPieza(0, 6, "English-Elephant-Black.png");
        colocarPieza(0, 3, "English-Advisor-Black.png");
        colocarPieza(0, 5, "English-Advisor-Black.png");
        colocarPieza(0, 4, "English-King-Black.png");
    }

    private void colocarPieza(int i, int j, String nombreArchivo) {
        ImageIcon icono = cargarImagen("C:\\Users\\50488\\Desktop\\universidad\\piezas\\Pieces\\Pieces\\English\\Red\\" + nombreArchivo, CELL_SIZE, CELL_SIZE);
        ImageIcon icono2 = cargarImagen("C:\\Users\\50488\\Desktop\\universidad\\piezas\\Pieces\\Pieces\\English\\Black\\" + nombreArchivo, CELL_SIZE, CELL_SIZE);
        if (icono != null && tableroEstado[i][j].esRojo()) {
            botones[i][j].setIcon(icono);
            botones[i][j].setEnabled(true);
        }
        if (icono2 != null && !tableroEstado[i][j].esRojo()) {
            botones[i][j].setIcon(icono2);
            botones[i][j].setEnabled(true);
        }
    }

    private ImageIcon cargarImagen(String ruta, int ancho, int alto) {
        try {
            File imagenFile = new File(ruta);
            if (!imagenFile.exists()) {
                return null;
            }
            Image img = ImageIO.read(imagenFile);
            Image imagenEscalada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            return new ImageIcon(imagenEscalada);
        } catch (IOException e) {
            return null;
        }
    }

    private class ButtonClickListener implements ActionListener {

    private int fila, columna;
    private JTextArea movimientosArea;

    public ButtonClickListener(int fila, int columna, JTextArea movimientosArea) {
        this.fila = fila;
        this.columna = columna;
        this.movimientosArea = movimientosArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        celda pieza = tableroEstado[fila][columna];

        if (piezaSeleccionada == null && boton.getIcon() != null) {
            // Seleccionar pieza si es del turno correcto
            if ((turnoRojo && pieza.esRojo()) || (!turnoRojo && !pieza.esRojo())) {
                piezaSeleccionada = boton;
                filaSeleccionada = fila;
                columnaSeleccionada = columna;
                piezaSeleccionada.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));

                limpiarResaltados(); // Limpia cualquier resaltado anterior
                resaltarMovimientosValidos(fila, columna);
            }
        } else if (piezaSeleccionada != null) {
            // Si se hace clic en la misma ficha, se deselecciona
            if (piezaSeleccionada == boton) {
                piezaSeleccionada.setBorder(BorderFactory.createEmptyBorder());
                limpiarResaltados(); // Quita los resaltados
                piezaSeleccionada = null;
            } else if (boton.getIcon() == null && esMovimientoValido(filaSeleccionada, columnaSeleccionada, fila, columna)) {
                String movimiento = "Movimiento: de " + jugador + " (" + filaSeleccionada + ", " + columnaSeleccionada + ") -> (" + fila + ", " + columna + ") y movió la pieza " + pieza.getTipoPieza();
                movimientosArea.append(movimiento + "\n");

                moverPieza(filaSeleccionada, columnaSeleccionada, fila, columna);
                boton.setIcon(piezaSeleccionada.getIcon());
                piezaSeleccionada.setIcon(null);
                piezaSeleccionada.setBorder(BorderFactory.createEmptyBorder());
                limpiarResaltados(); // Quita los resaltados
                piezaSeleccionada = null;
                cambiarTurno();
            } // Capturar una pieza
            else if (boton.getIcon() != null && pieza.esRojo() != turnoRojo) {
                if (esMovimientoValido(filaSeleccionada, columnaSeleccionada, fila, columna)) {
                    celda piezaCapturada = tableroEstado[fila][columna];
                    String captura = "Captura: de " + jugador + " en (" + fila + ", " + columna + ") y la pieza capturada fue " + piezaCapturada.getTipoPieza();
                    movimientosArea.append(captura + "\n");

                    capturarPieza(fila, columna);
                    boton.setIcon(piezaSeleccionada.getIcon());
                    piezaSeleccionada.setIcon(null);
                    moverPieza(filaSeleccionada, columnaSeleccionada, fila, columna);
                    piezaSeleccionada.setBorder(BorderFactory.createEmptyBorder());
                    limpiarResaltados(); // Quita los resaltados
                    piezaSeleccionada = null;
                    cambiarTurno();
                }
            }
        }
    }
}

    public void cambiarTurno() {

        turnoRojo = !turnoRojo;
        if (turnoRojo) {
            turnoLabel.setText("Turno de " + partidas.getInstance().getJugador_1());
            jugador = partidas.getInstance().getJugador_1();
        } else {
            turnoLabel.setText("Turno de " + partidas.getInstance().getJugador_2());
            jugador = partidas.getInstance().getJugador_2();
        }
    }

    private void capturarPieza(int fila, int columna) {
        celda piezaCapturada = tableroEstado[fila][columna];

        if (piezaCapturada.getTipoPieza() != null) {
            JLabel etiquetaPieza = new JLabel();
            ImageIcon icono = (ImageIcon) botones[fila][columna].getIcon();
            etiquetaPieza.setIcon(icono);

            if (piezaCapturada.esRojo()) {
                piezasCapturadasNegras.add(etiquetaPieza);
                panelCapturasNegras.add(etiquetaPieza);
            } else {
                piezasCapturadasRojas.add(etiquetaPieza);
                panelCapturasRojas.add(etiquetaPieza);
            }

            if (piezaCapturada.getTipoPieza().equals("Rey") || piezaCapturada.getTipoPieza().equals("Rey-")) {
                String ganador = piezaCapturada.esRojo() ? partidas.getInstance().getJugador_2() + " ganaa! por jaque mate" : partidas.getInstance().getJugador_1() + " gana! por jaque mate";
                JOptionPane.showMessageDialog(null, ganador, "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
                String log_ganador = turnoRojo ? partidas.getInstance().getJugador_1() + " le gano a " + partidas.getInstance().getJugador_2() + " por Jaque mate" + "\n" : partidas.getInstance().getJugador_2() + " le gano a  " + partidas.getInstance().getJugador_1() + " por Jaque mate \n";
                String log_perdedor = turnoRojo ? partidas.getInstance().getJugador_2() + " perdio contra " + partidas.getInstance().getJugador_1() + " por Jaque mate" + "\n" : partidas.getInstance().getJugador_1() + " perdio contra " + partidas.getInstance().getJugador_2() + " por Jaque mate \n";
                System.out.println("Ganador: " + (turnoRojo ? "Jugador 1" : "Jugador 2"));
                System.out.println("Jugador 1: " + partidas.getInstance().getJugador_1());
                System.out.println("Jugador 2: " + partidas.getInstance().getJugador_2());
                System.out.println("Log ganador: " + log_ganador);
                System.out.println("Log perdedor: " + log_perdedor);
                partidas.getInstance().distribuir_logs(turnoRojo, log_ganador, log_perdedor);
                menu_principal mostrar2 = new menu_principal();
                mostrar2.setVisible(true);
                SwingUtilities.getWindowAncestor(this).dispose();
            }

            botones[fila][columna].setIcon(null);
            tableroEstado[fila][columna] = new celda(null, false);

            actualizarPanelCapturas();
        }
    }

    private void rendirse() {

        String ganador = turnoRojo ? partidas.getInstance().getJugador_2() + " gana! por rendicion " : partidas.getInstance().getJugador_1() + " gana! por rendicion ";

        String log_ganador = turnoRojo ? partidas.getInstance().getJugador_2() + " le gano a " + partidas.getInstance().getJugador_1() + " por rendicion " + "\n" : partidas.getInstance().getJugador_1() + " le gano a  " + partidas.getInstance().getJugador_2() + " por rendicion \n";
        String log_perdedor = turnoRojo ? partidas.getInstance().getJugador_1() + " perdio contra " + partidas.getInstance().getJugador_2() + " poque se rindio." + "\n" : partidas.getInstance().getJugador_2() + " perdio contra " + partidas.getInstance().getJugador_1() + " porque se rindio." + "\n";
        JOptionPane.showMessageDialog(null, ganador, "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
        partidas.getInstance().distribuir_logsrendidos(turnoRojo, log_ganador, log_perdedor);
        menu_principal mostrar2 = new menu_principal();
        mostrar2.setVisible(true);
        SwingUtilities.getWindowAncestor(this).dispose();

    }

    private void actualizarPanelCapturas() {
        panelCapturasRojas.revalidate();
        panelCapturasRojas.repaint();
        panelCapturasNegras.revalidate();
        panelCapturasNegras.repaint();
    }

    private void habilitarMovimiento(boolean habilitar) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (habilitar) {
                    if (esMovimientoValido(filaSeleccionada, columnaSeleccionada, i, j)) {
                        botones[i][j].setEnabled(true);
                    } else {
                        botones[i][j].setEnabled(false);
                    }
                } else {
                    botones[i][j].setEnabled(botones[i][j].getIcon() != null);
                }
            }
        }
    }

    private void inicializarEstadoTablero() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                tableroEstado[i][j] = new celda(null, false);
            }
        }
        tableroEstado[7][0] = new celda("Peon", true);
        tableroEstado[7][2] = new celda("Peon", true);
        tableroEstado[7][4] = new celda("Peon", true);
        tableroEstado[7][6] = new celda("Peon", true);
        tableroEstado[7][8] = new celda("Peon", true);
        tableroEstado[8][1] = new celda("Cannon", true);
        tableroEstado[8][7] = new celda("Cannon", true);
        tableroEstado[10][0] = new celda("Torre", true);
        tableroEstado[10][8] = new celda("Torre", true);
        tableroEstado[10][1] = new celda("Caballo", true);
        tableroEstado[10][7] = new celda("Caballo", true);
        tableroEstado[10][6] = new celda("Elefante", true);
        tableroEstado[10][2] = new celda("Elefante", true);
        tableroEstado[10][3] = new celda("Consejero", true);
        tableroEstado[10][5] = new celda("Consejero", true);
        tableroEstado[10][4] = new celda("Rey", true);

        tableroEstado[3][0] = new celda("Peon", false);
        tableroEstado[3][2] = new celda("Peon", false);
        tableroEstado[3][4] = new celda("Peon", false);
        tableroEstado[3][6] = new celda("Peon", false);
        tableroEstado[3][8] = new celda("Peon", false);
        tableroEstado[2][1] = new celda("Cannon", false);
        tableroEstado[2][7] = new celda("Cannon", false);
        tableroEstado[0][0] = new celda("Torre", false);
        tableroEstado[0][8] = new celda("Torre", false);
        tableroEstado[0][1] = new celda("Caballo", false);
        tableroEstado[0][7] = new celda("Caballo", false);
        tableroEstado[0][2] = new celda("Elefante-", false);
        tableroEstado[0][6] = new celda("Elefante-", false);
        tableroEstado[0][3] = new celda("Consejero-", false);
        tableroEstado[0][5] = new celda("Consejero-", false);
        tableroEstado[0][4] = new celda("Rey-", false);
    }

    private void moverPieza(int filaActual, int columnaActual, int filaNueva, int columnaNueva) {
        tableroEstado[filaNueva][columnaNueva] = tableroEstado[filaActual][columnaActual];
        tableroEstado[filaActual][columnaActual] = new celda(null, false);
    }

    private boolean esMovimientoValido(int filaInicial, int colInicial, int filaFinal, int colFinal) {
        celda pieza = tableroEstado[filaInicial][colInicial];
        if (pieza.getTipoPieza() == null) {
            return false;
        }
        if (filaFinal == 5) {
            return false;
        }

        // Guardar el estado actual y simular el movimiento
        celda piezaDestino = tableroEstado[filaFinal][colFinal];
        tableroEstado[filaFinal][colFinal] = pieza;
        tableroEstado[filaInicial][colInicial] = new celda(null, false);

        // Verificar si los reyes se ven
        boolean invalidMove = reyesSeVen();

        // Restaurar el estado original
        tableroEstado[filaInicial][colInicial] = pieza;
        tableroEstado[filaFinal][colFinal] = piezaDestino;

        if (invalidMove) {
            return false;
        }

        if (pieza.getTipoPieza().equals("Peon")) {
            int direccion = pieza.esRojo() ? -1 : 1;
            int deltaFila = filaFinal - filaInicial;
            int deltaCol = Math.abs(colFinal - colInicial);

            if (!pieza.esRojo() && filaInicial == 4 && filaFinal == 6 && deltaCol == 0) {
                return true;
            }

            if (pieza.esRojo() && filaInicial == 6 && filaFinal == 4 && deltaCol == 0) {
                return true;
            }

            if (pieza.esRojo()) {
                if (filaInicial > 4) {
                    return deltaFila == direccion && deltaCol == 0;
                } else {
                    if (deltaFila == direccion && deltaCol == 0) {
                        return true;
                    }
                    if (deltaFila == 0 && deltaCol == 1) {
                        return true;
                    }
                    return false;
                }
            }

            if (!pieza.esRojo()) {
                if (filaInicial < 6) {
                    return deltaFila == direccion && deltaCol == 0;
                } else {
                    if (deltaFila == direccion && deltaCol == 0) {
                        return true;
                    }
                    if (deltaFila == 0 && deltaCol == 1) {
                        return true;
                    }
                    return false;
                }
            }
        } else if (pieza.getTipoPieza().equals("Torre")) {
            if (!xd.valido(filaInicial, colInicial, filaFinal, colFinal)) {
                return false;
            }

            if (filaInicial == filaFinal) {
                int minCol = Math.min(colInicial, colFinal);
                int maxCol = Math.max(colInicial, colFinal);
                for (int j = minCol + 1; j < maxCol; j++) {
                    if (tableroEstado[filaInicial][j].getTipoPieza() != null) {
                        return false;
                    }
                }
            } else if (colInicial == colFinal) {
                int minFila = Math.min(filaInicial, filaFinal);
                int maxFila = Math.max(filaInicial, filaFinal);
                for (int i = minFila + 1; i < maxFila; i++) {
                    if (tableroEstado[i][colInicial].getTipoPieza() != null) {
                        return false;
                    }
                }
            }

            celda destino = tableroEstado[filaFinal][colFinal];
            if (destino.getTipoPieza() != null && destino.esRojo() == pieza.esRojo()) {
                return false;
            }

            return true;
        } else if (pieza.getTipoPieza().equals("Cannon")) {
            movimiento_cañon movimientoCañon = new movimiento_cañon();

            if (filaInicial != filaFinal && colInicial != colFinal) {
                return false;
            }

            int contador = contarPiezasIntermedias(filaInicial, colInicial, filaFinal, colFinal, tableroEstado);

            celda destino = tableroEstado[filaFinal][colFinal];
            boolean destinoOcupado = destino != null && destino.getTipoPieza() != null;
            boolean esEnemigo = destinoOcupado && destino.esRojo() != pieza.esRojo();

            if (!destinoOcupado && contador == 0) {
                return true;
            }

            if (destinoOcupado && esEnemigo && contador == 1) {
                return true;
            }

            return false;
        } // Movimiento del Caballo
        else if (pieza.getTipoPieza().equals("Caballo")) {
            movimiento_caballo movimientoCaballo = new movimiento_caballo();
            if (!movimientoCaballo.valido(filaInicial, colInicial, filaFinal, colFinal)) {
                return false;
            }

            celda destino = tableroEstado[filaFinal][colFinal];
            if (destino.getTipoPieza() != null && destino.esRojo() == pieza.esRojo()) {
                return false;
            }

            return true;
        } else if (pieza.getTipoPieza().equals("Consejero")) {

            MovimientoConsejero movimientoConsejero = new MovimientoConsejero();
            if (!movimientoConsejero.valido(filaInicial, colInicial, filaFinal, colFinal)) {
                return false;
            }

            celda destino = tableroEstado[filaFinal][colFinal];

            if (destino.getTipoPieza() != null && destino.esRojo() == pieza.esRojo()) {
                return false;
            }

            return true;
        } else if (pieza.getTipoPieza().equals("Consejero-")) {

            MovimientoConsejeroNegro movimientoConsejero = new MovimientoConsejeroNegro();

            // Verificamos si el movimiento es válido según las reglas
            if (!movimientoConsejero.valido(filaInicial, colInicial, filaFinal, colFinal)) {
                return false;
            }

            celda destino = tableroEstado[filaFinal][colFinal];

            if (destino.getTipoPieza() != null && destino.esRojo() == pieza.esRojo()) {
                return false;
            }

            return true;
        } else if (pieza.getTipoPieza().equals("Rey")) {

            movimiento_rey movimientoConsejero = new movimiento_rey();

            if (!movimientoConsejero.valido(filaInicial, colInicial, filaFinal, colFinal)) {
                return false;
            }

            celda destino = tableroEstado[filaFinal][colFinal];

            if (destino.getTipoPieza() != null && destino.esRojo() == pieza.esRojo()) {
                return false;
            }

            return true;
        } else if (pieza.getTipoPieza().equals("Rey-")) {

            movimiento_reyn movimientoConsejero = new movimiento_reyn();

            if (!movimientoConsejero.valido(filaInicial, colInicial, filaFinal, colFinal)) {
                return false;
            }

            celda destino = tableroEstado[filaFinal][colFinal];

            if (destino.getTipoPieza() != null && destino.esRojo() == pieza.esRojo()) {
                return false;
            }

            return true;
        } else if (pieza.getTipoPieza().equals("Elefante")) {

            movimiento_elefanterojo movimientoElefante = new movimiento_elefanterojo();

            if (!movimientoElefante.valido(filaInicial, colInicial, filaFinal, colFinal)) {
                return false;
            }

            // Obtener la celda destino
            celda destino = tableroEstado[filaFinal][colFinal];

            if (destino.getTipoPieza() != null && destino.esRojo() == pieza.esRojo()) {
                return false;
            }

            return true;
        } else if (pieza.getTipoPieza().equals("Elefante-")) {

            movimiento_elefantnegron movimientoElefante = new movimiento_elefantnegron();

            if (!movimientoElefante.valido(filaInicial, colInicial, filaFinal, colFinal)) {
                return false;
            }

            celda destino = tableroEstado[filaFinal][colFinal];

            if (destino.getTipoPieza() != null && destino.esRojo() == pieza.esRojo()) {
                return false;
            }

            return true;
        }

        return true;
    }

    public celda getCelda(int fila, int columna) {
        return tableroEstado[fila][columna];
    }

    private int contarPiezasIntermedias(int filaInicial, int colInicial, int filaFinal, int colFinal, celda[][] tableroEstado) {
        int contador = 0;

        // Movimiento horizontal
        if (filaInicial == filaFinal) {
            int minCol = Math.min(colInicial, colFinal);
            int maxCol = Math.max(colInicial, colFinal);
            for (int j = minCol + 1; j < maxCol; j++) {
                if (tableroEstado[filaInicial][j] != null && tableroEstado[filaInicial][j].getTipoPieza() != null) {
                    contador++;
                }
            }
        } else if (colInicial == colFinal) {
            int minFila = Math.min(filaInicial, filaFinal);
            int maxFila = Math.max(filaInicial, filaFinal);
            for (int i = minFila + 1; i < maxFila; i++) {
                if (tableroEstado[i][colInicial] != null && tableroEstado[i][colInicial].getTipoPieza() != null) {
                    contador++;
                }
            }
        }

        return contador;
    }

    private boolean reyesSeVen() {
        int columnaReyRojo = -1, filaReyRojo = -1;
        int columnaReyNegro = -1, filaReyNegro = -1;

        // Buscar las posiciones de los dos reyes
        for (int fila = 0; fila < tableroEstado.length; fila++) {
            for (int col = 0; col < tableroEstado[fila].length; col++) {
                celda pieza = tableroEstado[fila][col];
                if (pieza != null && pieza.getTipoPieza() != null) {
                    if (pieza.getTipoPieza().equals("Rey") && pieza.esRojo()) {
                        filaReyRojo = fila;
                        columnaReyRojo = col;
                    } else if (pieza.getTipoPieza().equals("Rey-") && !pieza.esRojo()) {
                        filaReyNegro = fila;
                        columnaReyNegro = col;
                    }
                }
            }
        }

        // Verificar si están en la misma columna sin obstáculos entre ellos
        if (columnaReyRojo == columnaReyNegro) {
            int minFila = Math.min(filaReyRojo, filaReyNegro);
            int maxFila = Math.max(filaReyRojo, filaReyNegro);
            for (int i = minFila + 1; i < maxFila; i++) {
                if (tableroEstado[i][columnaReyRojo] != null && tableroEstado[i][columnaReyRojo].getTipoPieza() != null) {
                    return false; // Hay una pieza bloqueando la vista
                }
            }
            return true; // Los reyes se ven
        }
        return false; // No están en la misma columna
    }

    private void resaltarMovimientosValidos(int fila, int columna) {
        for (int i = 0; i < 10; i++) { // Recorremos todas las filas
            for (int j = 0; j < 9; j++) { // Recorremos todas las columnas
                if (esMovimientoValido(fila, columna, i, j)) {
                    botones[i][j].setBorder(BorderFactory.createLineBorder(Color.GREEN, 3)); // Resalta en verde
                }
            }
        }
    }

    private void limpiarResaltados() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                botones[i][j].setBorder(BorderFactory.createEmptyBorder()); // Quita el borde
            }
        }
    }

}
