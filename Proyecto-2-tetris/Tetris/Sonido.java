package Tetris;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Sonido {

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
