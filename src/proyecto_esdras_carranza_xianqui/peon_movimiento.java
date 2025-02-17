/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

/**
 *
 * @author 50488
 */
public class peon_movimiento extends movimiento_pieza {

    private celda[][] tableroEstado;
    private boolean esRojo;

    public peon_movimiento(celda[][] tableroEstado, boolean esRojo) {
        this.tableroEstado = tableroEstado;
        this.esRojo = esRojo;
    }

    @Override
    public boolean valido(int fila_ac, int columna_ac, int fila_mo, int columna_mo) {
        System.out.println("Intentando mover peón de (" + fila_ac + ", " + columna_ac + ") a (" + fila_mo + ", " + columna_mo + ")");

        if (tableroEstado[fila_mo][columna_mo] != null && tableroEstado[fila_mo][columna_mo].esRojo() == esRojo) {
            System.out.println("Movimiento inválido: celda ocupada por una pieza del mismo color.");
            return false;
        }

        if (esRojo) {
            if (fila_ac == 6) {  // Justo antes del río
                boolean valido = fila_mo == fila_ac - 2 && columna_mo == columna_ac;
                System.out.println("Saltando el río (movimiento de 2 casillas): " + valido);
                return valido;
            } else if (fila_ac > 5) {  // Antes del río
                boolean valido = fila_mo == fila_ac - 1 && columna_mo == columna_ac;
                System.out.println("Movimiento hacia adelante antes del río: " + valido);
                return valido;
            } else {  // Después del río
                boolean valido = (fila_mo == fila_ac - 1 && columna_mo == columna_ac)
                        || (fila_mo == fila_ac && Math.abs(columna_mo - columna_ac) == 1);
                System.out.println("Movimiento después del río (adelante/lateral): " + valido);
                return valido;
            }
        } else {  // Para el jugador negro
            if (fila_ac == 4) {  // Justo antes del río
                boolean valido = fila_mo == fila_ac + 2 && columna_mo == columna_ac;
                System.out.println("Saltando el río (movimiento de 2 casillas): " + valido);
                return valido;
            } else if (fila_ac < 5) {  // Antes del río
                boolean valido = fila_mo == fila_ac + 1 && columna_mo == columna_ac;
                System.out.println("Movimiento hacia adelante antes del río: " + valido);
                return valido;
            } else {  // Después del río
                boolean valido = (fila_mo == fila_ac + 1 && columna_mo == columna_ac)
                        || (fila_mo == fila_ac && Math.abs(columna_mo - columna_ac) == 1);
                System.out.println("Movimiento después del río (adelante/lateral): " + valido);
                return valido;
            }
        }
    }

    @Override
    public int getfila(int fila) {
        return fila;
    }

    @Override
    public int getcolumna(int columna) {
        return columna;
    }
}
