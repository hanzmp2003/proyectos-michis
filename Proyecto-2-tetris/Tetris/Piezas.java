package Tetris;

public class Piezas { //encapsula la lógica de rotación y visualización.
    public static final String RESET = "\u001B[0m";
    public String[][] formaVisib;
    public boolean[][] forma;
    public String color;
    public int posF; // La idea de estos dos atributos, es que guarden la ubicación de cada entrada de la matriz en la tabla.
    public int posC;
    public String[][] posAuxiliar;
    public int maxC;
    public int minC;
    public int maxF;

    //Esto es util para cuando crea las piezas en otra clase, esto para simplificar el código
    public Piezas(boolean[][] forma, String color) {
        this.forma = forma;
        this.color = color;
        this.posF = 0;
        this.posC = 3;
        this.formaVisib = new String[forma.length][forma[0].length];
        formaVisible();
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

    public void rotar90(){
        int n = forma.length;
        String[][] nuevaMV = new String[n][n];
        boolean[][] nuevaM = new boolean[n][n];
        for (int i = 0; i < forma[0].length; i++){
            for (int j = 0; j < forma.length; j++) {
                nuevaM[j][n-i-1] = forma[i][j];
                nuevaMV[j][n-i-1] = formaVisib[i][j];
            }
        }
        forma = nuevaM;
        formaVisib = nuevaMV;
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

    public void moverPieza(String s){
        if (s.equals("s")){
            this.posF += 1;
            if (forma.length + posF < 20) {
                this.posF += 1;
            } 
        } else if (s.equals("a")) {
            if (posC > 0) {
                this.posC -= 1;
            }
        } else if (s.equals("d")) {
            if (forma[0].length + posC < 10) {
                this.posC += 1;
            }
        } else if (s.equals("w")){
            rotar90();
            calcularLimites();
        }
    }

    public void formaVisible(){
        for (int i = 0; i < formaVisib.length; i++) {
            for (int j = 0; j < formaVisib[i].length; j++) {
                if (forma[i][j]) {
                    this.formaVisib[i][j] = color + "██" + Piezas.RESET;
                } else {
                    this.formaVisib[i][j] = "  ";
                }
            }
        }
    }

    public void calcularLimites(){
        int cerrar = 0;
        int cerrar2 = 0;
        int cerrar3 = 0;
        for (int j = forma[0].length - 1; j >= 0 && cerrar == 0; j--){
            for (int i = 0; i < forma.length && (cerrar2 == 0 || cerrar3 == 0); i++){
                if (forma[i][j] && cerrar2 == 0){
                    this.maxC = j;
                    cerrar2 = 1;
                }
                if (forma[j][i]){
                    this.maxF = j;
                    cerrar3 = 1;
                }
            }
            if (cerrar2 == 1 && cerrar3 == 1){
                cerrar = 1;
            }
        }
        cerrar = 0;
        cerrar2 = 0;
        for (int j = 0; j < forma[0].length && cerrar == 0; j++){
            for (int i = 0; i < forma.length && cerrar2 == 0; i++){
                if (forma[i][j]){
                    this.minC = j;
                    cerrar = cerrar2 = 1;
                }
            }
        }
    }

}


