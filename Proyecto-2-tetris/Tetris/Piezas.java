package Tetris;

public class Piezas { //encapsula la lógica de rotación y visualización.
    public static final String RESET = "\u001B[0m";
    public String[][] formaVisib;
    public boolean[][] forma;
    public boolean[][] posPieza = new boolean[20][10];
    public String color;

    //Esto es util para cuando crea las piezas en otra clase, esto para simplificar el código
    public Piezas(boolean[][] forma, String color) {
        this.forma = forma;
        this.color = color;
        this.formaVisib = new String[forma.length][forma[0].length];
        TablasAdicionales();
    }

    // Rotar 90° a la derecha
    public void rotarDerecha() {
        int filas = forma.length;
        int columnas = forma[0].length;
        boolean[][] rotada = new boolean[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                rotada[j][filas - 1 - i] = forma[i][j];
            }
        }
        forma = rotada;
    }

    // Mostrar la pieza con color ANSI
    public void imprimir() {
        for (int i = 0; i < forma.length; i++) {
            for (int j = 0; j < forma[i].length; j++) {
                if (forma[i][j]) {
                    System.out.print(color + "██" + Piezas.RESET);
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public void TablasAdicionales(){
        for (int i = 0; i < formaVisib.length; i++) {
            for (int j = 0; j < formaVisib[i].length; j++) {
                if (forma[i][j]) {
                    this.formaVisib[i][j] = color + "██" + Piezas.RESET;
                } else {
                    this.formaVisib[i][j] = "  ";
                }
            }
        }
        for (int i = 0 ; i < 20 ; i++){
            for (int j = 0 ; j < 10 ; j++){
                this.posPieza[i][j] = false;
            }
        }
    }
}


