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

public class Puntaje { //TODO: Cambiar está clase y convertirlo en un árbol, el árbol se trata de acomodar los colores y el puntaje es un promedio en base a eso.
    public int puntos2;
    private int puntos;
    private int lineas;
    /**
     * Constructor de la clase Puntaje 
     * 
     * Inicializan los puntos y las líneas en cero 
     */
    public Puntaje(){
        puntos2 = 0;
        puntos = 0;
        lineas = 0;
    }

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
     * Devuelve la cantidad de líneas que se han eliminado 
     * @return el número de líneas  eliminadas 
     */
    public int getLineas(){
        return lineas;
    }

    /**
     * Devuelve el puntaje acumulado 
     * @return el puntaje actual
     */
    public int getPuntos(){
        return puntos;
    }
    
    /**
     * Muestra en la pantalla el puntaje y las líneas acumuladas en la partida 
     */
    public void mostrarPuntaje() {
        System.out.println("Puntos: " + puntos + " | Líneas: " + lineas);
    }

    public void sumarPuntos(int puntajeFila){
        puntos2 += puntajeFila;
    }
    
}
