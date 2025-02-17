/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

/**
 *
 * @author 50488
 */
public class MovimientoConsejeroNegro extends movimiento_pieza {
      @Override
    public boolean valido(int filaActual, int columnaActual, int filaMovimiento, int columnaMovimiento) {
        // Verifica que la celda destino esté en la zona permitida para los consejeros negros
        if ((filaMovimiento < 0 || filaMovimiento > 2) || (columnaMovimiento < 3 || columnaMovimiento > 5)) {
            return false;
        }
        
        // Verifica que el movimiento sea una casilla en cualquier dirección (vertical, horizontal o diagonal)
        int difFila = Math.abs(filaMovimiento - filaActual);
        int difColumna = Math.abs(columnaMovimiento - columnaActual);

        // El Rey se mueve solo una casilla en cualquier dirección, pero no puede saltar
        if (difFila <= 1 && difColumna <= 1) {
            return true; // El movimiento es válido si es dentro de la zona y no se sale de la misma
        }

        return false;
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
