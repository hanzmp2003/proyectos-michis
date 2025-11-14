package Tetris;

public class ArbolColores {

    private NodoColor raiz;

    private class NodoColor{
        String color;
        int frecuencia;
        NodoColor izq;
        NodoColor der;
        public NodoColor(String color, int frecuencia){
            this.color = color;
            this.frecuencia = frecuencia;
        }
    }

    public ArbolColores(){
        this.raiz = null;
    }

    public int puntaje(){
        return calculoPuntaje(raiz, 10); // Valor inicial de los puntos.
    }

    public void insertar(String color, int frecuencia){
        raiz = insertarR(raiz,color,frecuencia);
    }

    private NodoColor insertarR(NodoColor nodo, String color, int frecuencia){
        if (nodo == null) {
            return new NodoColor(color, frecuencia);
        }

        if (frecuencia > nodo.frecuencia) {
            nodo.der = insertarR(nodo.der,color,frecuencia);
        } else {
            nodo.izq = insertarR(nodo.izq,color,frecuencia);
        }

        return nodo;
    }

    private int calculoPuntaje(NodoColor nodo, int valor) {
        if (nodo == null){
            return 0;
        }
        int actual = nodo.frecuencia * valor;
        int izq = calculoPuntaje(nodo.izq, valor + 2);
        int der = calculoPuntaje(nodo.der, valor - 2);
        return actual + izq + der;
    }

}

