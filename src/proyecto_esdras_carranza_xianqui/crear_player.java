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
public class crear_player extends JFrame {

    public crear_player() {
        setTitle("INICIO DE SESION ");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        Color lightBlue = new Color(0xADD8E6);
        Color mintcream = new Color(0xF5FFFA);
        Color cayenne = new Color(0xE2583E);
       Color xd = new Color(152, 251, 152);
        getContentPane().setBackground(lightBlue);
        JLabel menu = new JLabel("Bienvenido al crear player de Xianqui");
        menu.setForeground(cayenne);
        menu.setBounds(70, 10, 400, 30);
        add(menu);

        JLabel pedir_user = new JLabel("Ingrese su usuario: ");
        pedir_user.setBounds(30, 60, 200, 40);
        pedir_user.setForeground(cayenne);
        pedir_user.setBackground(xd);
        add(pedir_user);

        JTextField escribir_user = new JTextField();
        escribir_user.setBounds(30, 90, 300, 40);
        escribir_user.setForeground(cayenne);
        escribir_user.setBackground(xd);
        add(escribir_user);

        JLabel pedir_contra = new JLabel("Ingrese la Contraseña: ");
        pedir_contra.setBounds(30, 140, 200, 40);
        pedir_contra.setForeground(cayenne);
        pedir_contra.setBackground(xd);
        add(pedir_contra);

        JPasswordField escribir_contra = new JPasswordField();
        escribir_contra.setBounds(30, 170, 300, 40);
        escribir_contra.setBackground(xd);
        add(escribir_contra);

        JButton iniciar_sesion = new JButton("Crear cuenta");
        iniciar_sesion.setBounds(70, 220, 200, 40);
        iniciar_sesion.setForeground(cayenne);
        iniciar_sesion.setBackground(xd);
        add(iniciar_sesion);

        JButton volver = new JButton("Volver");
        volver.setBounds(70, 280, 200, 40);
        volver.setForeground(cayenne);
        volver.setBackground(xd);
        add(volver);

        volver.addActionListener(e -> {
            Intefaz_gui regresar = new Intefaz_gui();
            regresar.setVisible(true);
            this.dispose();
        });

        iniciar_sesion.addActionListener(e -> {
            String user = escribir_user.getText().trim();
            String contra = escribir_contra.getText().trim();
            boolean iniciar = cuentas.getInstance().crear_cuenta(user, contra);
            if (iniciar && contra.length() <= 5) {
                partidas.getInstance().setJugador_1(user);
                Jugadores.getInstance().guardar_jugador(user, 0);
                menu_principal entro = new menu_principal();
                entro.setVisible(true);
                this.dispose();
            } else {

                System.out.println("no");
            }

        });

    }
}
