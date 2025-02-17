/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

import java.util.ArrayList;
import javax.swing.*;
import java.time.LocalDate;

/**
 *
 * @author 50488
 */
public class cuentas {

    private static cuentas instancia;
    private static final int MAX_USERS = 20;
    String[] user = new String[MAX_USERS];
    private String[] contra = new String[MAX_USERS];
    private int[] puntos = new int[MAX_USERS];
    private boolean[] activa = new boolean[MAX_USERS];
    private LocalDate[] fecha = new LocalDate[MAX_USERS];
    private String[] log = new String[MAX_USERS];
    private String[] usuarios_eliminados=new String [MAX_USERS];
    private int eliminados=0;
    private int contador = 0;

  public cuentas(){
      
  }

    public static cuentas getInstance() {
        if (instancia == null) {
            instancia = new cuentas();
        }
        return instancia;
    }

    public String[] getUser() {
        return user;
    }

    public String mostrar_info(String useer) {
        for (int i = 0; i < contador; i++) {
            if (useer.equals(user[i])) {
                return "Mi cuenta: " + user[i] + "\n"
                        + "Puntos: " + puntos[i] + "\n"
                        + "Fecha de creación de cuenta: " + fecha[i];
            }
        }
        return "Usuario no encontrado";
    }

    public boolean crear_cuenta(String useer, String contraa) {
        if (contador >= MAX_USERS) {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más usuarios.");
            return false;
        }
        if(useer.length()<2){
               JOptionPane.showMessageDialog(null, "No ingresar usuario menor a 1 caracter");
               return false;
        }
        if (contraa.length() > 5) {
            JOptionPane.showMessageDialog(null, "No ingresar contraseña mayor a 5 caracteres");
            return false;
        }
        if (useer == null || useer.isBlank() || contraa == null || contraa.isBlank()) {
            JOptionPane.showMessageDialog(null, "No se permiten datos vacíos.");
            return false;
        }
        if (confirmar_user(useer)) {
            JOptionPane.showMessageDialog(null, "El usuario ya existe. Intenta con otro nombre.");
            return false;
        }

        user[contador] = useer;
        contra[contador] = contraa;
        puntos[contador] = 0;
        activa[contador] = false;
        fecha[contador] = LocalDate.now();
        log[contador] = "";

        contador++;

        JOptionPane.showMessageDialog(null, "Usuario creado con éxito. ¡Bienvenido, " + useer + "!");

        return true;
    }

    public boolean inicio_sesion(String useer, String contraa) {
        for (int i = 0; i < contador; i++) {
            if (user[i]!=null&&user[i].equals(useer)) {
                if (activa[i]) {
                    JOptionPane.showMessageDialog(null, "La cuenta ya está activa.");
                    return false;
                }
                if (contra[i].equals(contraa)) {
                    JOptionPane.showMessageDialog(null, "Usuario y contraseña correctos. Bienvenido.");
                    activa[i] = true;
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
                    return false;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
        return false;
    }

    public boolean confirmar_user(String useer) {
        for (int i = 0; i < contador; i++) {
            if (user[i]!=null&&user[i].equals(useer)) {
                return true;
            }
        }
        return false;
    }

    public boolean cambiar_pasword(String useer, String pas_antigua, String pas_nueva) {
        if (pas_nueva.length() > 5) {
            JOptionPane.showMessageDialog(null, "La contraseña no puede pasar de 5 caracteres");
            return false;
        }
        for (int i = 0; i < contador; i++) {
            if (user[i]!=null&&contra[i]!=null&&user[i].equals(useer) && contra[i].equals(pas_antigua)) {
                contra[i] = pas_nueva;
                JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, " contraseña incorrecta  ");
        return false;
    }

    public int cant_user() {
        return cant_user(0, 0);
    }

    private int cant_user(int cont, int cant) {
        if (cont < user.length) {
            if (user[cont] != null) {
                cant++;
            }
            return cant_user(cont + 1, cant);
        }
        return cant;
    }

    public void almacenar_logs(String useer, String loog) {
        almacenar_logs(useer, 0, loog);
    }

    private void almacenar_logs(String useer, int cont, String loog) {
        if (cont < user.length) {
            if (user[cont] != null && useer.equals(user[cont])) {
                log[cont] += loog;
            }
            almacenar_logs(useer, cont + 1, loog);
        }
    }

   public String mostrar_log(String useer) {
    String loog = "Jugador no existe";
    for (int i = user.length - 1; i >= 0; i--) {
        if (user[i] != null && log[i] != null && useer.equals(user[i])) {
            loog = log[i];
            break;
        }
    }
    return loog;
}

    public void desactivar_cuenta(String useer) {
        for (int i = 0; i < user.length; i++) {
            if (user[i] != null && useer.equals(user[i])) {
                activa[i] = false;
            }
        }
    }
    
  public boolean confirmar(String useer, String contraa) {
    for (int i = 0; i < contador; i++) { 
        if (user[i] != null && user[i].equals(useer) && contra[i] != null && contra[i].equals(contraa)) {
            return true; 
        }
    }
    return false; 
}

  public void eliminar_cuenta(String useer) {
    boolean seElimino = false;

    for (int i = 0; i < user.length; i++) {
        if (user[i] != null && useer.equals(user[i])) {
            
            if (eliminados < usuarios_eliminados.length) {
                usuarios_eliminados[eliminados++] = user[i];
            }

           
            user[i] = null;
            contra[i] = null;
            puntos[i] = 0;
            activa[i] = false;
            fecha[i] = null;
            log[i] = "Jugador eliminado"; 
            seElimino = true;
        }
    }

   
    if (seElimino) {
        for (int i = 0; i < log.length; i++) {
            if (log[i] != null && log[i].contains(useer)) {
                log[i] = log[i].replace(useer, "Jugador eliminado");
            }
        }
    }
}
    
    public void sumar(String useer){
        for (int i = 0; i < user.length; i++) {
            if (user[i] != null && useer.equals(user[i])) {
                puntos[i]+=3;
            }
        }
    }

}
