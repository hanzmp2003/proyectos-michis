/**
 * Se encarga de reproducir los efectos de sonido en el tetris
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Chun Ping Liu Li, C5G492
 * @author Emanuel Sancho Sánchez, C07332
 * @author Jefferson Emanuel Miranda Sabala, C24874
 *
 * @version 1.0 
 */
package Tetris;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Sonido {

    /**
     * Reproduce un archivo de sonido 
     * @param archivo  es la ruta del archivo de sonido a reproducir
     */
    public static void reproducir(String archivo) {
        try {
            File file = new File(archivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
