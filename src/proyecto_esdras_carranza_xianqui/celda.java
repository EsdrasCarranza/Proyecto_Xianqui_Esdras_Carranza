/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

/**
 *
 * @author 50488
 */
public final class celda {
      private String tipoPieza; 
    private boolean esRojo;   

    public celda(String tipoPieza, boolean esRojo) {
        this.tipoPieza = tipoPieza;
        this.esRojo = esRojo;
    }

    public final String getTipoPieza() {
        return tipoPieza;
    }

    public final boolean esRojo() {
        return esRojo;
    }

    public final void setTipoPieza(String tipoPieza) {
        this.tipoPieza = tipoPieza;
    }

    public final void setEsRojo(boolean esRojo) {
        this.esRojo = esRojo;
    }

    @Override
    public String toString() {
        return (tipoPieza != null ? tipoPieza.charAt(0) : "-") + (esRojo ? "R" : "N");
    }
}
