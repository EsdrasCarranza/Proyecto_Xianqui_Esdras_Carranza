/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

/**
 *
 * @author 50488
 */
public class partidas implements organizador_logs {

    private static partidas instancia;
    String jugador_1;
    String jugador_2;
    int puntos_ganados;
    partidas ranking[]= new partidas[20];

    public partidas(String jugador_1, String jugador_2) {
        this.jugador_1 = jugador_1;
        this.jugador_2 = jugador_2;
        puntos_ganados = 0;
    }

    private partidas() {
    }

    public static partidas getInstance() {
        if (instancia == null) {
            instancia = new partidas();
        }
        return instancia;
    }

    public String getJugador_1() {
        return jugador_1;
    }

    public String getJugador_2() {
        return jugador_2;
    }

    public int getPuntos_ganados() {
        return puntos_ganados;
    }

    public void setJugador_1(String jugador_1) {
        this.jugador_1 = jugador_1;
    }

    public void setJugador_2(String jugador_2) {
        this.jugador_2 = jugador_2;
    }

    public void setPuntos_ganados(int puntos_ganados) {
        this.puntos_ganados = puntos_ganados;
    }

    @Override
    public void distribuir_logs(boolean ganador,String log_ganador,String log_perdedor) {
        if (!ganador) {
            cuentas.getInstance().almacenar_logs(jugador_2, log_ganador);
            cuentas.getInstance().almacenar_logs(jugador_1, log_perdedor);
            Jugadores.getInstance().sumar(jugador_2);
            cuentas.getInstance().sumar(jugador_2);
        }else{
            cuentas.getInstance().almacenar_logs(jugador_2, log_perdedor);
            cuentas.getInstance().almacenar_logs(jugador_1, log_ganador);
            Jugadores.getInstance().sumar(jugador_1);
            cuentas.getInstance().sumar(jugador_1);
        }
    }

   
    public void distribuir_logsrendidos(boolean ganado, String loog1, String loog2) {
        if (ganado) {
            cuentas.getInstance().almacenar_logs(jugador_2, loog1);
            cuentas.getInstance().almacenar_logs(jugador_1, loog2);
            Jugadores.getInstance().sumar(jugador_2);
            cuentas.getInstance().sumar(jugador_2);
        }else{
            cuentas.getInstance().almacenar_logs(jugador_2, loog2);
            cuentas.getInstance().almacenar_logs(jugador_1, loog1);
            Jugadores.getInstance().sumar(jugador_1);
             cuentas.getInstance().sumar(jugador_1);
        }
    }

}
