package Tetris;
import java.util.Random;

// La transformación de las piezas al tablero será sumarle 3 a las columnas.

public class Tabla{
    private Random rand;
    private CrearPiezas piezas = new CrearPiezas();
    private String[][] tab;
    public Tabla() {
        iniciarTablas();
        Piezas pieza = piezas.getPiezaAleatoria();
        dibujarPieza(pieza, tab);
        moverPieza("s",pieza,tab);
        imprimirTab(tab);
    }

    public void dibujarPieza(Piezas pieza, String[][] tab){
        for (int i = 0 ; i < pieza.formaVisib.length ; i++) {
            for (int j = 0 ; j < pieza.formaVisib[0].length ; j++){
                tab[i][j+3] = pieza.formaVisib[i][j];
                pieza.posPieza[i][j+3] = pieza.forma[i][j];
            }
        }
    }

    public void moverPieza(String s, Piezas pieza, String[][] tab){
        if (s.equals("s")){
            for (int i = pieza.posPieza.length - 1; i >= 0; i--){
                for (int j = pieza.posPieza[0].length - 1; j >= 0; j--){
                    if (pieza.posPieza[i][j]){
                        pieza.posPieza[i+1][j] = pieza.posPieza[i][j];
                        pieza.posPieza[i][j] = false;
                        tab[i+1][j] = tab[i][j];
                        tab[i][j] = "  ";
                    }
                }
            }
        }
    }

    public void imprimirTab(String[][] tab){
        for (String[] i : tab){
            for (String j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public void iniciarTablas(){
        this.tab = new String[20][10];
        for (int i = 0 ; i < tab.length ; i++){
            tab[i] = new String[]{"  ","  ","  ","  ","  ","  ","  ","  ","  ","  "};
        }
    }

}