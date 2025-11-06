
/**
 * Esta es la clase principal que inicia el programa 
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Chun Ping Liu Li, C5G492
 * @author Emanuel Sancho Sánchez, C07332
 * @author Jefferson Emanuel Miranda Sabala, C24874
 *
 * @version 1.0 
 */
package Tetris;

/**
 * Es el punto de partida del programa, acá se inicia
 * @param args Argumento de línea  de comandos (no se utiliza en este programa)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("TETRIS");
        System.out.println("W --> Rotar");
        System.out.println("A --> Mover a la Izquierda");
        System.out.println("D --> Mover a la Derecha");
        System.out.println("S --> Bajar pieza");
        Sonido.reproducir("Paquete_sonidos/SFX_GameStart.wav");
        Tabla tabla = new Tabla();
    }
}