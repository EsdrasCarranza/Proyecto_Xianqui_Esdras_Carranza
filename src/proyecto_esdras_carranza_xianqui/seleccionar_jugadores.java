/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 50488
 */
public class seleccionar_jugadores extends JFrame {

    private JList<String> lista;
    private DefaultListModel<String> modelo;
    private JButton botonSeleccionar;
    private JButton botonRegresar;

    public seleccionar_jugadores() {
        setTitle("Seleccionar Jugadores");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        Color lightBlue = new Color(0xADD8E6);
        Color mintcream = new Color(0xF5FFFA);
        Color cayenne = new Color(0xE2583E);

        String no_mostrar = partidas.getInstance().getJugador_1();
        String[] elementos = cuentas.getInstance().getUser();
    getContentPane().setBackground(lightBlue);
        modelo = new DefaultListModel<>();

        if (elementos != null) {
            for (String elemento : elementos) {

                if (elemento != null && !elemento.equals(no_mostrar)) {
                    modelo.addElement(elemento);
                }
            }
        }

        lista = new JList<>(modelo);
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setForeground(cayenne);
        scrollPane.setBackground(mintcream);

        botonSeleccionar = new JButton("Seleccionar");
     botonSeleccionar.setForeground(cayenne);
     botonSeleccionar.setBackground(mintcream);
        botonSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = lista.getSelectedValue();
                if (seleccionado != null) {
                    JOptionPane.showMessageDialog(null, "Seleccionaste: " + seleccionado);
                    partidas.getInstance().setJugador_2(seleccionado);
                    SwingUtilities.invokeLater(() -> {
                        JFrame frame = new JFrame("Tablero con Imagen");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setLayout(new BorderLayout());

                        JPanel panelContenedor = new JPanel(new BorderLayout());
                        panelContenedor.setBorder(BorderFactory.createEmptyBorder(30, 200, 50, 200));

                        Tablero tablero = new Tablero();
                        panelContenedor.add(tablero, BorderLayout.CENTER);

                        frame.add(panelContenedor, BorderLayout.CENTER);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    });
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un elemento.");
                }
            }
        });

        botonRegresar = new JButton("Regresar");
        botonRegresar.setForeground(cayenne);
        botonRegresar.setBackground(mintcream);
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                menu_principal mostrar = new menu_principal();
                mostrar.setVisible(true);
                dispose();
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(botonSeleccionar, BorderLayout.SOUTH);
        JPanel panel = new JPanel();
        panel.add(botonRegresar);
        add(panel, BorderLayout.NORTH);
    }

}
