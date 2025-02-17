/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

/**
 *
 * @author 50488
 */
public class Jugadores implements Almacenamiento_info {
    private static Jugadores instancia;
    private String jugador;
    private int puntos_obtenidos;
    private static Jugadores guardado[] = new Jugadores[20];
    private static int contador = 0;

    public Jugadores(String jugador, int puntos_obtenidos) {
        this.jugador = jugador;
        this.puntos_obtenidos = puntos_obtenidos;
    }

    private Jugadores() {}

    public static Jugadores getInstance() {
        if (instancia == null) {
            instancia = new Jugadores();
        }
        return instancia;
    }

    public void guardar_jugador(String user, int puntos) {
        if (contador < guardado.length) {
            guardado[contador] = new Jugadores(user, puntos);
            contador++;
        } else {
            System.out.println("No se pueden agregar más jugadores.");
        }
    }

    @Override
    public void sumar_puntos(String user) {
        for (int i = 0; i < contador; i++) {
            if (guardado[i] != null && guardado[i].jugador.equals(user)) {
                guardado[i].puntos_obtenidos += 3;
                return;
            }
        }
        System.out.println("Jugador no encontrado.");
    }

    public void eliminar_jugador(String user) {
        for (int i = 0; i < contador; i++) {
            if (guardado[i] != null && guardado[i].jugador.equals(user)) {
                // Desplazar los jugadores restantes para evitar espacios nulos
                for (int j = i; j < contador - 1; j++) {
                    guardado[j] = guardado[j + 1];
                }
                guardado[contador - 1] = null; // Eliminar la última referencia
                contador--;
                System.out.println("Jugador " + user + " eliminado.");
                return;
            }
        }
        System.out.println("Jugador no encontrado.");
    }

    public String obtener_podio() {
        if (contador == 0) return "No hay jugadores registrados.";

        // Copia del array sin `null`
        Jugadores[] ranking = new Jugadores[contador];
        for (int i = 0; i < contador; i++) {
            ranking[i] = guardado[i];
        }

        // Ordenamiento por Burbuja
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - i - 1; j++) {
                if (ranking[j] != null && ranking[j + 1] != null &&
                    ranking[j].puntos_obtenidos < ranking[j + 1].puntos_obtenidos) {
                    
                    Jugadores temp = ranking[j];
                    ranking[j] = ranking[j + 1];
                    ranking[j + 1] = temp;
                }
            }
        }

        // Construcción del podio
        String podio = " Podio de Jugadores \n";
        for (int i = 0; i < Math.min(3, contador); i++) {
            if (ranking[i] != null) {
                podio += (i + 1) + ". " + ranking[i].jugador + " - " + ranking[i].puntos_obtenidos + " puntos\n";
            }
        }
        return podio;
    }
}
