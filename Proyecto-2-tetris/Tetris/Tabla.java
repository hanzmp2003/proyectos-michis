package Tetris;
import java.util.ArrayList;
import java.util.Arrays;

public class Tabla{
    private Piezas piezas = new Piezas();
    private String[][] tab;
    private boolean[][] tabDiscreto;
    public Tabla() {
        this.tab = new String[20][10];
        this.tabDiscreto = new boolean[20][10];
        for (int i = 0 ; i < tab.length ; i++){
            tab[i] = new String[]{"  ","  ","  ","  ","  ","  ","  ","  ","  ","  "};
            for (int j = 0 ; j < 10 ; j++){
                tabDiscreto[i][j] = false;
            }
        }
    }

    public void dibujarPieza(){

    }

    public String[][] generarPiezaAl(){
        ArrayList<String[][]> piezasLista = new ArrayList<>(piezas.piezaI,piezas.piezaJ);
    }

}