/**
 * La clase puntaje administra el sistema de puntos del tetirs 
 * aumentando según la cantidad de lineas que haya eliminado 
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Chun Ping Liu Li, C5G492
 * @author Emanuel Sancho Sánchez, C07332
 * @author Jefferson Emanuel Miranda Sabala, C24874
 *
 * @version 1.0 
 */

package Tetris;

public class Puntaje {
    private int puntos;
    private int lineas;
    //private int nivel; agregamos nivel ¿?

    /**
     * Constructor de la clase Puntaje 
     * 
     * Inicializan los puntos y las líneas en cero 
     */
    public Puntaje(){
        puntos = 0;
        lineas = 0;
    }

    //sumar puntos según líneas eliminadas
    /**
     * Suma los puntos según las líneas que se hayan eliminado, donde cada línea tiene un valor de 100
     * @param lineasEliminadas número de líneas que se eliminaron en la partida 
     */
    public void calcularPuntos(int lineasEliminadas){
        lineas += lineasEliminadas;
        if(lineas > 0){
            puntos += (100 * lineasEliminadas);
        }
    }

    /**
     * Devuelve la cantidad de líneas qie se han eliminado 
     * @return el número de líneas  eliminadas 
     */
    public int getLineas(){
        return lineas;
    }

    /**
     * Devuelve el pintaje acumulado 
     * @return el puntaje actual
     */
    public int getPuntos(){
        return puntos;
    }
    
    /**
     * Muestra en la pantalla el puntaj y las líneas acumuladas en la partida 
     */
    public void mostrarPuntaje() {
        System.out.println("Puntos: " + puntos + " | Líneas: " + lineas);
    }

    
}
