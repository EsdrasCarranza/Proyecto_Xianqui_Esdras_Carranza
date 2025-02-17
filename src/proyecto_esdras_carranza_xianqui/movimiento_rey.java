/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

/**
 *
 * @author 50488
 */
public class movimiento_rey extends movimiento_pieza{
       public boolean valido(int filaActual, int columnaActual, int filaMovimiento, int columnaMovimiento) {
        
        if ((filaMovimiento < 8 || filaMovimiento > 10) || (columnaMovimiento < 3 || columnaMovimiento > 5)) {
            return false;
        }
        
       
        int difFila = Math.abs(filaMovimiento - filaActual);
        int difColumna = Math.abs(columnaMovimiento - columnaActual);

       
        if (difFila <= 1 && difColumna <= 1) {
            return true; 
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
