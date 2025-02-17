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
public class mi_cuenta extends JFrame {

    public mi_cuenta() {
        setTitle("Mi cuenta");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
         Color lightBlue = new Color(0xADD8E6);
        Color mintcream = new Color(0xF5FFFA);
        Color cayenne = new Color(0xE2583E);
        Color honeydew = new Color(0xF0FFF0);

        getContentPane().setBackground(lightBlue);
        String user = partidas.getInstance().getJugador_1();

        JTextArea areaTexto = new JTextArea(5, 20);
        areaTexto.setBounds(40, 10, 300, 100);
        areaTexto.setForeground(cayenne);
        areaTexto.setBackground(honeydew);
        add(areaTexto);
        areaTexto.setEditable(false);
        
        areaTexto.setText(cuentas.getInstance().mostrar_info(user));
        
        JButton cambiar_password = new JButton("Cambiar Contraseña");
        cambiar_password.setBounds(90, 170, 200, 40);
        cambiar_password.setForeground(cayenne);
        cambiar_password.setBackground(honeydew);
        add(cambiar_password);
        
        JButton eliminar_cuenta = new JButton("Eliminar Cuenta");
        eliminar_cuenta.setBounds(90, 270, 200, 40);
        eliminar_cuenta.setForeground(cayenne);
        eliminar_cuenta.setBackground(honeydew);
        add(eliminar_cuenta);
        
        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(90, 370, 200, 40);
        cancelar.setForeground(cayenne);
        cancelar.setBackground(honeydew);
        add(cancelar);
        
        cambiar_password.addActionListener(e-> {
            cambiar_password mostrar = new  cambiar_password();
            mostrar.setVisible(true);
            this.dispose();
        });
        
        cancelar.addActionListener(e->{
            menu_principal mostrar2 = new menu_principal();
            mostrar2.setVisible(true);
            this.dispose();
        });
        
        eliminar_cuenta.addActionListener(e-> {
            SwingUtilities.invokeLater(() -> new eliminar_cuenta().setVisible(true));
            this.dispose();
        });

    }
}
