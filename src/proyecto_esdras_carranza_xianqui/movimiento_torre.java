/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

/**
 *
 * @author 50488
 */
public class movimiento_torre extends movimiento_pieza {
    @Override
    public boolean  valido(int fila_ac, int columna_ac, int fila_mo, int columna_mo) {
      
        if (fila_ac != fila_mo && columna_ac != columna_mo) {
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

    

