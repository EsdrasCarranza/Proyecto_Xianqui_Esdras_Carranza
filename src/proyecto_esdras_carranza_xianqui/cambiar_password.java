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
public class cambiar_password extends JFrame{
    public cambiar_password(){
        
        setTitle("Cambiar contraseña");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);   
         Color summerWhite = new Color(0xFFFAF0);
        Color croissant = new Color(0xF1C27D);
        Color cayenne = new Color(0xE2583E);
        
        String user =partidas.getInstance().getJugador_1();
         getContentPane().setBackground(summerWhite);
        JLabel menu = new JLabel("Cambiar contraseña");
        menu.setBounds(130, 10, 400, 30);
        menu.setForeground(cayenne);
        add(menu);
        
        JLabel pedir_contra =  new JLabel("Ingrese la contraseña antigua: ");
        pedir_contra.setBounds(70, 80, 200, 30);
        pedir_contra.setForeground(cayenne);
        add(pedir_contra);
        
        JPasswordField contra_antigua = new JPasswordField("");
        contra_antigua.setBounds(70, 120, 200, 30);
        contra_antigua.setForeground(cayenne);
        contra_antigua.setBackground(croissant);
        add(contra_antigua);
        
        JLabel pedir_nueva = new JLabel("Ingrese la contraseña nueva: ");
        pedir_nueva.setBounds(70, 200, 200, 30);
        pedir_nueva.setForeground(cayenne);
        add(pedir_nueva);
        
        JPasswordField contra_nueva = new JPasswordField("");
        contra_nueva.setBounds(70, 240, 200, 30);
        contra_nueva.setForeground(cayenne);
        contra_nueva.setBackground(croissant);
        add(contra_nueva);
        
        JButton cambiar_contra = new JButton ("Cambiar contraseña");
        cambiar_contra.setBounds(40, 320, 150, 30);
        cambiar_contra.setForeground(cayenne);
        cambiar_contra.setBackground(croissant);
        add(cambiar_contra);
        
        JButton cancelar = new JButton ("Cancelar");
        cancelar.setBounds(220, 320, 150, 30);
        cancelar.setForeground(cayenne);
        cancelar.setBackground(croissant);
        add(cancelar);
        
        cambiar_contra.addActionListener(e->{
            String contra_anti = contra_antigua.getText();
            String contra_nue = contra_nueva.getText();
            
            boolean si =cuentas.getInstance().cambiar_pasword(user, contra_anti, contra_nue);
            
            if(si){
                mi_cuenta mostrar =  new mi_cuenta();
                mostrar.setVisible(true);
                this.dispose();
            }
            
        });
        
        cancelar.addActionListener(e->{
            menu_principal mostrar =  new menu_principal();
            mostrar.setVisible(true);
            this.dispose();
        });
        
        
        
    }
    
}
