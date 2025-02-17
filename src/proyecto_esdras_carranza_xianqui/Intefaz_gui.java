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
public class Intefaz_gui extends JFrame {

    public Intefaz_gui() {
        // Configuración de la ventana
        setTitle("Menu de inicio");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Colores de la paleta asiática
        Color summerWhite = new Color(0xFFFAF0);
        Color croissant = new Color(0xF1C27D);
        Color cayenne = new Color(0xE2583E);
       

        getContentPane().setBackground(summerWhite);  // Fondo negro

        JLabel menu = new JLabel("Bienvenido menu de inicio de Xianqui");
        menu.setBounds(100, 10, 400, 30);
        menu.setForeground(cayenne);
        add(menu);

        JButton crear_player = new JButton("Crear Player");
        crear_player.setBounds(100, 90, 200, 30);
        crear_player.setBackground(croissant);
        crear_player.setForeground(cayenne);
        add(crear_player);

        JButton salir = new JButton("Salir");
        salir.setBounds(100, 270, 200, 30);
        salir.setBackground(croissant);
        salir.setForeground(cayenne);
        add(salir);

        JButton log_in = new JButton("Log in");
        log_in.setBounds(100, 180, 200, 30);
        log_in.setBackground(croissant);
        log_in.setForeground(cayenne);
        add(log_in);

        // Acción del botón "Log in"
        log_in.addActionListener(e -> {
            log_iin mostrar = new log_iin();
            mostrar.setVisible(true);
            this.dispose();
        });

        // Acción del botón "Crear Player"
        crear_player.addActionListener(e -> {
            crear_player mostrar = new crear_player();
            mostrar.setVisible(true);
            this.dispose();
        });
        
        salir.addActionListener(e -> System.exit(0));
        
    }

}

//guardar.addActionListener(e -> {
//            String texto = saludo.getText();
//            saludo.setText("");
//
//            label.setText("Texto ingresado: " + texto);
//        });
// guardar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//                String texto = saludo.getText();
//                saludo.setText("");
//
//                
//                label.setText("Texto ingresado: " + texto);
//            }
//        });
//        
