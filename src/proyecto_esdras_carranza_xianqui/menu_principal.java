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
public class menu_principal extends JFrame {

    public menu_principal() {
        setTitle("Menu Principal");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
     Color summerWhite = new Color(0xFFFAF0);
        Color croissant = new Color(0xF1C27D);
        Color cayenne = new Color(0xE2583E);
        getContentPane().setBackground(summerWhite);
     

        JLabel titulo = new JLabel("Menu Principal del Xianqui");
        titulo.setBounds(120, 10, 400, 30);
        titulo.setForeground(cayenne);
        titulo.setBackground(croissant);
        add(titulo);

        JButton jugar = new JButton("JUGAR PARTIDA");
        jugar.setBounds(90, 90, 200, 40);
        jugar.setForeground(cayenne);
        jugar.setBackground(croissant);
        add(jugar);
        if (cuentas.getInstance().cant_user() <= 1) {
            jugar.setEnabled(false);
        } else {
            jugar.setEnabled(true);
        }

        JButton mi_cuenta = new JButton("MI CUENTA");
        mi_cuenta.setBounds(90, 180, 200, 40);
        mi_cuenta.setForeground(cayenne);
        mi_cuenta.setBackground(croissant);
        add(mi_cuenta);

        JButton reportes = new JButton("REPORTES");
        reportes.setBounds(90, 270, 200, 40);
        reportes.setForeground(cayenne);
        reportes.setBackground(croissant);
        add(reportes);

        JButton log_out = new JButton("LOG OUT");
        log_out.setBounds(90, 360, 200, 40);
        log_out.setForeground(cayenne);
        log_out.setBackground(croissant);
        add(log_out);

        log_out.addActionListener(e -> {
            cuentas.getInstance().desactivar_cuenta(partidas.getInstance().getJugador_1());
            partidas.getInstance().setJugador_1(null);
            partidas.getInstance().setJugador_2(null);
            Intefaz_gui mostrar = new Intefaz_gui();
            mostrar.setVisible(true);
            this.dispose();
        });

        mi_cuenta.addActionListener(e -> {
            mi_cuenta mostrar = new mi_cuenta();
            mostrar.setVisible(true);
            this.dispose();

        });

        jugar.addActionListener(e -> {
            if (cuentas.getInstance().cant_user() <= 1) {
                JOptionPane.showMessageDialog(null,"NECESITA MAS DE UN USER PARA ACCEDER AQUI ");
            } else {
                seleccionar_jugadores mostrar = new seleccionar_jugadores();
            mostrar.setVisible(true);
            this.dispose();
            }
            
        });
       reportes.addActionListener(e-> {
            SwingUtilities.invokeLater(() -> new reportes());
            this.dispose();
       });

    }
}
