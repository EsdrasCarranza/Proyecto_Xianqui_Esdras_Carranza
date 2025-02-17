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
public class eliminar_cuenta extends JFrame {

    private JPasswordField campoPassword;
    private JButton btnBorrar, btnCancelar;

    public eliminar_cuenta() {
        setTitle("Eliminar Cuenta");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        Color wheat = new Color(0xF5DEB3);
        Color mistyRose = new Color(0xFFE4E1);
        Color cayenne = new Color(0xE2583E);
         getContentPane().setBackground(wheat);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Etiqueta
        JLabel lblPassword = new JLabel("Ingrese su contraseña:");
        lblPassword.setForeground(cayenne);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lblPassword, gbc);

        // Campo de contraseña
        campoPassword = new JPasswordField(15);
        campoPassword.setForeground(cayenne);
        campoPassword.setBackground(mistyRose);
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(campoPassword, gbc);

        // Botón Borrar
        btnBorrar = new JButton("Borrar");
        btnBorrar.setForeground(cayenne);
        btnBorrar.setForeground(cayenne);
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        add(btnBorrar, gbc);

        // Botón Cancelar
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(cayenne);
        btnCancelar.setForeground(cayenne);
        gbc.gridx = 1;
        add(btnCancelar, gbc);

        // Acción del botón "Borrar"
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(campoPassword.getPassword()).trim();
                boolean si =cuentas.getInstance().confirmar(partidas.getInstance().getJugador_1(), password);
                
                if(si){
                    Jugadores.getInstance().eliminar_jugador(partidas.getInstance().getJugador_1());
                    cuentas.getInstance().eliminar_cuenta(partidas.getInstance().getJugador_1());
                    Intefaz_gui mostrar = new Intefaz_gui();
                    mostrar.setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Error. contraseña incorrecta");
                    campoPassword.setText("");
                }
                System.out.println("Contraseña ingresada: " + password);
                
            }
        });

        // Acción del botón "Cancelar"
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu_principal mostrar = new menu_principal();
                mostrar.setVisible(true);
                dispose();
            }
        });
    }
}
