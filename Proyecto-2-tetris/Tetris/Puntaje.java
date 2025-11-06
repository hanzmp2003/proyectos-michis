package Tetris;

public class Puntaje {
    private int puntos;
    private int lineas;
    //private int nivel; agregamos nivel ¿?

    public Puntaje(){
        puntos = 0;
        lineas = 0;
    }

    //sumar puntos según líneas eliminadas
    public void calcularPuntos(int lineasEliminadas){
        lineas += lineasEliminadas;
        if(lineas > 0){
            puntos += (100 * lineasEliminadas);
        }
    }

    public int getLineas(){
        return lineas;
    }

    public int getPuntos(){
        return puntos;
    }
    

    public void mostrarPuntaje() {
        System.out.println("Puntos: " + puntos + " | Líneas: " + lineas);
    }

    
}
