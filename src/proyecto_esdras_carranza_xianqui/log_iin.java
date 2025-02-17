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
public class log_iin extends JFrame {

    public log_iin() {
        setTitle("INICIO DE SESION ");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
   
        Color wheat = new Color(0xF5DEB3);
        Color mistyRose = new Color(0xFFE4E1);
        Color cayenne = new Color(0xE2583E);
        
        getContentPane().setBackground(wheat);
        JLabel menu = new JLabel("Bienvenido al inicio de sesion de Xianqui");
        menu.setBounds(70, 10, 400, 30);
        menu.setForeground(cayenne);
        menu.setBackground(mistyRose);
        add(menu);

        JLabel pedir_user = new JLabel("Ingrese su usuario: ");
        pedir_user.setBounds(30, 60, 200, 40);
        pedir_user.setForeground(cayenne);
        add(pedir_user);

        JTextField escribir_user = new JTextField();
        escribir_user.setBounds(30, 90, 300, 40);
        escribir_user.setForeground(cayenne);
        escribir_user.setBackground(mistyRose);
        add(escribir_user);

        JLabel pedir_contra = new JLabel("Ingrese la Contraseña: ");
        pedir_contra.setBounds(30, 140, 200, 40);
        pedir_contra.setForeground(cayenne);
        add(pedir_contra);

        JPasswordField escribir_contra = new JPasswordField();
        escribir_contra.setBounds(30, 170, 300, 40);
        escribir_contra.setForeground(cayenne);
        escribir_contra.setBackground(mistyRose);
        add(escribir_contra);

        JButton iniciar_sesion = new JButton("Iniciar Sesion");
        iniciar_sesion.setBounds(70, 220, 200, 40);
        iniciar_sesion.setForeground(cayenne);
        iniciar_sesion.setBackground(mistyRose);
        add(iniciar_sesion);

        JButton volver = new JButton("Volver");
        volver.setBounds(70, 280, 200, 40);
        volver.setForeground(cayenne);
        volver.setBackground(mistyRose);
        add(volver);

        volver.addActionListener(e -> {
            Intefaz_gui regresar = new Intefaz_gui();
            regresar.setVisible(true);
            this.dispose();
        });

        iniciar_sesion.addActionListener(e -> {
            String user = escribir_user.getText().trim();
            String contra = escribir_contra.getText().trim();
            boolean iniciar = cuentas.getInstance().inicio_sesion(user, contra);
            if (iniciar) {
                System.out.println("si");
                partidas.getInstance().setJugador_1(user);
                menu_principal entro = new menu_principal();
                entro.setVisible(true);
                this.dispose();
            } else {
                System.out.println("no");
            }

        });

    }
}
