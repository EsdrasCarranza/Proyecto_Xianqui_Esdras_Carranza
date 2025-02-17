/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

/**
 *
 * @author 50488
 */
public abstract class movimiento_pieza {
    int fila_ac;
    int fila_mo;
    int columna_ac;
    int columna_mo;
    public abstract boolean valido(int fila_ac, int columna_ac, int fila_mo, int columna_mo);
    
    public abstract int getfila(int fila);
    
    public abstract int getcolumna(int columna);
    
    public void setFilaac(int fila){
        fila_ac = fila;
    }
     public void setFilamo(int fila){
        fila_mo = fila;
    }
     public void setcolumnaac(int columna){
         columna_ac=columna;
     }
      public void setcolumnamo(int columna){
         columna_mo=columna;
     }

}
