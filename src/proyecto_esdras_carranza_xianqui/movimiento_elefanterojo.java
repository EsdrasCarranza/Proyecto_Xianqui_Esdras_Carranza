/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

/**
 *
 * @author 50488
 */
public class movimiento_elefanterojo extends movimiento_pieza {
    @Override
    public boolean valido(int fila_ac, int columna_ac, int fila_mo, int columna_mo) {
       
        if (Math.abs(fila_mo - fila_ac) != 2 || Math.abs(columna_mo - columna_ac) != 2) {
            return false;
        }

      
        if (fila_mo < 6 || fila_mo > 10) {
            return false;
        }

     
        int fila_intermedia = (fila_ac + fila_mo) / 2;
        int columna_intermedia = (columna_ac + columna_mo) / 2;

       
        Tablero tablero = Tablero.getInstance();
        celda celdaIntermedia = tablero.getCelda(fila_intermedia, columna_intermedia);

        if (celdaIntermedia.getTipoPieza() != null && !celdaIntermedia.getTipoPieza().isEmpty()) {
            return false;
        }

        return true;
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

    

