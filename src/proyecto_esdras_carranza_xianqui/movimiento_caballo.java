/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

/**
 *
 * @author 50488
 */
public class movimiento_caballo extends movimiento_pieza {

    @Override
    public boolean valido(int fila_ac, int columna_ac, int fila_mo, int columna_mo) {
        
        int deltaFila = Math.abs(fila_mo - fila_ac);
        int deltaColumna = Math.abs(columna_mo - columna_ac);

     
        return (deltaFila == 2 && deltaColumna == 1) || (deltaFila == 1 && deltaColumna == 2);
    }

    @Override
    public int getfila(int fila) {
      
        return fila;
    }

    @Override
    public int getcolumna(int columna) {
       
        return columna;
    }

    @Override
    public void setFilaac(int fila) {
        this.fila_ac = fila;
    }

    @Override
    public void setFilamo(int fila) {
        this.fila_mo = fila;
    }

    @Override
    public void setcolumnaac(int columna) {
        this.columna_ac = columna;
    }

    @Override
    public void setcolumnamo(int columna) {
        this.columna_mo = columna;
    }
}
