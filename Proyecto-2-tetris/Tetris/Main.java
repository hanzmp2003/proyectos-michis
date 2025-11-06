
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
        Sonido.reproducir("Paquete_sonidos/SFX_GameStart.wav");
        Tabla tabla = new Tabla();
    }
}