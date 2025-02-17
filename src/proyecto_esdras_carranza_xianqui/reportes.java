/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author 50488
 */
public class reportes extends JFrame {

    public reportes() {
        setTitle("Ventana de Logs y Ranking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        Color lightBlue = new Color(0xADD8E6);
        Color mintcream = new Color(0xF5FFFA);
        Color cayenne = new Color(0xE2583E);
       Color xd = new Color(152, 251, 152);

        // Panel central con GridLayout para LOGS y RANKING
        JPanel panelCentro = new JPanel(new GridLayout(1, 2));

        getContentPane().setBackground(lightBlue);
        // Texto largo para LOGS
        String textoLargo = cuentas.getInstance().mostrar_log(partidas.getInstance().jugador_1);
        JTextArea logsArea = new JTextArea(textoLargo);
        logsArea.setForeground(cayenne);
        logsArea.setBackground(xd);
        logsArea.setEditable(false);
        JScrollPane scrollLogs = new JScrollPane(logsArea);
        scrollLogs.setBorder(BorderFactory.createTitledBorder("LOGS"));

        // Arreglo para RANKING
        String ranking = Jugadores.getInstance().obtener_podio();
        JTextArea rankingArea = new JTextArea(ranking);
        rankingArea.setForeground(cayenne);
        rankingArea.setBackground(xd);
        rankingArea.setEditable(false);

        JScrollPane scrollRanking = new JScrollPane(rankingArea);
        scrollRanking.setBorder(BorderFactory.createTitledBorder("RANKING"));

        // Agregar LOGS y RANKING al panel central
        panelCentro.add(scrollLogs);
        panelCentro.add(scrollRanking);

        // Botón "Volver al menú"
        JButton btnVolver = new JButton("Volver al menú");
        btnVolver.setForeground(cayenne);
        btnVolver.setBackground(xd);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu_principal mostrar2 = new menu_principal();
                mostrar2.setVisible(true);
                dispose(); // Cierra la ventana actual
            }
        });

        // Panel inferior para el botón
        JPanel panelInferior = new JPanel();
        panelInferior.add(btnVolver);

        // Agregar todo al JFrame
        add(panelCentro, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }
}
