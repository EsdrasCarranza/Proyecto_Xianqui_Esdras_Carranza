/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_esdras_carranza_xianqui;

/**
 *
 * @author 50488
 */
public class movimiento_cañon extends movimiento_pieza {
    @Override
    public boolean valido(int fila_ac, int columna_ac, int fila_mo, int columna_mo) {
        System.out.println("Verificando movimiento cañón de (" + fila_ac + "," + columna_ac + ") a (" + fila_mo + "," + columna_mo + ")");
        
        // El cañón solo se mueve en línea recta
        if (fila_ac != fila_mo && columna_ac != columna_mo) {
            System.out.println("Movimiento inválido: No es en línea recta");
            return false;
        }
        
        // Contar piezas intermedias en el camino
        int piezasEnCamino = contarPiezasEnCamino(fila_ac, columna_ac, fila_mo, columna_mo);
        celda origen = Tablero.getInstance().getCelda(fila_ac, columna_ac);
        celda destino = Tablero.getInstance().getCelda(fila_mo, columna_mo);
        boolean destinoOcupado = destino.getTipoPieza() != null;
        boolean esEnemigo = destinoOcupado && destino.esRojo() != origen.esRojo();
        
        // Movimiento normal sin captura: No hay piezas en el camino y el destino está vacío
        if (!destinoOcupado && piezasEnCamino == 0) {
            return true;
        }
        
        // Movimiento de captura: Debe haber exactamente una pieza en el camino y el destino debe ser enemigo
        if (destinoOcupado && esEnemigo && piezasEnCamino == 1) {
            return true;
        }
        
        System.out.println("Movimiento inválido: Reglas del cañón no cumplidas");
        return false;
    }
    
    private int contarPiezasEnCamino(int fila_ac, int columna_ac, int fila_mo, int columna_mo) {
        int contador = 0;
        
        if (fila_ac == fila_mo) { // Movimiento horizontal
            int minCol = Math.min(columna_ac, columna_mo);
            int maxCol = Math.max(columna_ac, columna_mo);
            for (int j = minCol + 1; j < maxCol; j++) {
                if (Tablero.getInstance().getCelda(fila_ac, j).getTipoPieza() != null) {
                    contador++;
                    System.out.println("Pieza encontrada en (" + fila_ac + "," + j + ")");
                }
            }
        } else if (columna_ac == columna_mo) { // Movimiento vertical
            int minFila = Math.min(fila_ac, fila_mo);
            int maxFila = Math.max(fila_ac, fila_mo);
            for (int i = minFila + 1; i < maxFila; i++) {
                if (Tablero.getInstance().getCelda(i, columna_ac).getTipoPieza() != null) {
                    contador++;
                    System.out.println("Pieza encontrada en (" + i + "," + columna_ac + ")");
                }
            }
        }
        
        System.out.println("Total de piezas en el camino: " + contador);
        return contador;
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

    
    

