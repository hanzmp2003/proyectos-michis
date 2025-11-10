/**
 * En la clase Piezas se encuentra toda la lógica relacionada con las piezas del tetris, tales como visualización,
 * forma, rotación
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Chun Ping Liu Li, C5G492
 * @author Emanuel Sancho Sánchez, C07332
 * @author Jefferson Emanuel Miranda Sabala, C24874
 *
 * @version 1.0 
 */
package Tetris;

public class Piezas { 

    public static final String RESET = "\u001B[0m";
    /**
     * Forma la base de la pieza
     */
    public boolean[][] formaBase;
    /**
     * Forma la base visible
     */
    public String[][] formaBaseVisib;
    /**
     * La forma visible actual 
     */
    public String[][] formaVisib; // Debido a que el profe no nos quiere, hay que estar modificando este atributo en paralelo también (color aleatorio por pieza).
    /**
     * Forma actual de la pieza
     */
    public boolean[][] forma;
    /**
     * Color ANSI asignado a la pieza
     */
    public String color;
    /**
     * Posición de la pieza en la tabla (fila)
     */
    public int posF; // La idea de estos dos atributos, es que guarden la ubicación de cada entrada de la matriz en la tabla.
    /**
     * Posición de la pieza (columna)
     */
    public int posC;
    /**
     * Límite superior para moviento de columna
     */
    public int maxC;
    /**
     * Límite inferio para movimiento de columna
     */
    public int minC;
    /**
     * Límite superior para movimiento en fila
     */
    public int maxF;
    Sonido sonido = new Sonido();

    //Esto es util para cuando crea las piezas en otra clase, esto para simplificar el código

    /**
     * Constructor de la clase pieza
     * 
     * @param forma es una matriz  booleana que representa la forma de la pieza
     * @param color  es el color ANSI que se le asigna a la pieza 
     */
    public Piezas(boolean[][] forma, String color) {
        this.color = color;
        this.formaBase = forma;
        this.forma = copiarForma();
        this.formaBaseVisib = new String[formaBase.length][formaBase[0].length];
        formaBaseVisible();
        this.formaVisib = copiarFormaVisib();
        this.posF = 0;
        this.posC = 3;
    }

    /**
     * Getter de forma
     * 
     * @return devuelve la forma de la pieza
     */
    public boolean[][] getForma() {
        return forma;
    }
    /**
     * Getter del color de la pieza
     * @return devuelve el color de la pieza
     */
    public String getColor() {
        return color;
    }


    /**
     * Rota la pieza 90° a la derecha
     * Afecta a la formaBase y a la formaBaseVisib
     */
    public void rotar90(){
        int n = formaBase.length;
        String[][] nuevaMV = new String[n][n];
        boolean[][] nuevaM = new boolean[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                nuevaM[j][n-i-1] = formaBase[i][j];
                nuevaMV[j][n-i-1] = formaBaseVisib[i][j];
            }
        }
        this.formaBase = nuevaM;
        this.formaBaseVisib = nuevaMV;
    }
    

    /**
     * Mueve la pieza segun la tecla indicada 
     * 
     * @param s teclas a presionar 
     * s abajo 
     * w rotar 
     * d derecha 
     * a izquierda
     */
    public void moverPieza(String s){
        boolean movido = false;
        if (s.equals("s")){
            if (forma.length - 1 + posF < 19) {
                this.posF += 1;
                movido = true;
                // this.forma = copiarForma();
                // this.formaVisib = copiarFormaVisib();
            } else if (forma.length - 1 + posF == 19 && maxF < forma.length - 1){
                boolean[][] formaAuxiliar = new boolean[forma.length][forma[0].length];
                String[][] formaVisibAuxiliar = new String[formaVisib.length][formaVisib[0].length];
                for (int i = forma.length - 1; i > 0; i--){
                    for (int j = 0; j < forma[0].length; j++){
                        formaAuxiliar[i][j] = forma[i - 1][j];
                        formaVisibAuxiliar[i][j] = formaVisib[i - 1][j];
                    }
                }
                for (int i = 0; i < forma.length; i++) {
                    formaAuxiliar[0][i] = false;
                    formaVisibAuxiliar[0][i] = "  ";
                }
                this.forma = formaAuxiliar;
                this.formaVisib = formaVisibAuxiliar;
                movido = true;
            }
        } else if (s.equals("a")) {
            if (posC > 0) {
                if (maxC + posC == 9 && minC > 0) {  // maxC + forma[0].length == 10
                    for (int j = 0; j < forma[0].length - 1; j++) {
                        for (int i = 0; i < forma.length; i++){
                            forma[i][j] = forma[i][j + 1];
                            formaVisib[i][j] = formaVisib[i][j + 1];
                        }
                    }
                    for (int i = 0; i < forma.length; i++){
                        forma[i][forma[0].length - 1] = false;
                        formaVisib[i][forma[0].length - 1] = "  ";
                    }
                
                } else if (maxC + posC <= 9){ 
                    this.posC -= 1;
                }
                Sonido.reproducir("Paquete_sonidos/SFX_PieceMoveLR.wav");
                movido = true;
            } else if (posC == 0 && minC > 0){
                boolean[][] formaAuxiliar = new boolean[forma.length][forma[0].length];
                String[][] formaVisibAuxiliar = new String[formaVisib.length][formaVisib[0].length];
                for (int j = 0; j < forma[0].length - 1; j++){
                    for (int i = 0; i < forma.length; i++){
                        formaAuxiliar[i][j] = forma[i][j+1];
                        formaVisibAuxiliar[i][j] = formaVisib[i][j+1];
                    }
                }
                for (int i = 0; i < forma.length; i++) {
                    formaAuxiliar[i][forma[0].length - 1] = false;
                    formaVisibAuxiliar[i][formaVisib[0].length - 1] = "  ";
                }
                this.forma = formaAuxiliar;
                this.formaVisib = formaVisibAuxiliar;
                Sonido.reproducir("Paquete_sonidos/SFX_PieceMoveLR.wav");
                movido = true;
            }
        } else if (s.equals("d")) {
            if (forma[0].length - 1 + posC < 9) { 
                if (minC + posC == 0 && maxC < forma[0].length - 1) { 
                    for (int j = forma[0].length - 1; j > 0; j--) {
                        for (int i = 0; i < forma.length; i++){
                            forma[i][j] = forma[i][j - 1];
                            formaVisib[i][j] = formaVisib[i][j - 1];
                        }
                    }
                    for (int i = 0; i < forma.length; i++){
                        forma[i][0] = false;
                        formaVisib[i][0] = "  ";
                    }
                } else if (minC + posC >= 0) { 
                    this.posC += 1;
                }
                Sonido.reproducir("Paquete_sonidos/SFX_PieceMoveLR.wav");
                movido = true;
            } else if (forma[0].length + posC == 10 && maxC < forma[0].length - 1){
                boolean[][] formaAuxiliar = new boolean[forma.length][forma[0].length];
                String[][] formaVisibAuxiliar = new String[formaVisib.length][formaVisib[0].length];
                for (int j = forma[0].length - 1; j > 0; j--){
                    for (int i = 0; i < forma.length; i++){
                        formaAuxiliar[i][j] = forma[i][j-1];
                        formaVisibAuxiliar[i][j] = formaVisib[i][j-1];
                    }
                }
                for (int i = 0; i < forma.length; i++) {
                    formaAuxiliar[i][0] = false;
                    formaVisibAuxiliar[i][0] = "  ";
                }
                this.forma = formaAuxiliar;
                this.formaVisib = formaVisibAuxiliar;
            }
        } else if (s.equals("w")){
            rotar90();
            this.forma = copiarForma();
            this.formaVisib = copiarFormaVisib();
            Sonido.reproducir("Paquete_sonidos/SFX_PieceRotateLR.wav");
            movido = true;
        }
        if ((s.equals("a") || s.equals("d") || s.equals("w")) && !movido) {
            Sonido.reproducir("Paquete_sonidos/SFX_PieceLockdown.wav");
        }
        calcularLimites();
    }

    public void formaBaseVisible(){
        for (int i = 0; i < formaBaseVisib.length; i++) {
            for (int j = 0; j < formaBaseVisib[0].length; j++) {
                if (formaBase[i][j]) {
                    this.formaBaseVisib[i][j] = color + "██" + Piezas.RESET;
                } else {
                    this.formaBaseVisib[i][j] = "  ";
                }
            }
        }
    }

    public void calcularLimites(){
        int cerrar = 0;
        int cerrar2 = 0;
        for (int j = forma[0].length - 1; j >= 0 && cerrar == 0; j--){
            for (int i = 0; i < forma.length && cerrar2 == 0; i++){
                if (forma[i][j]){
                    this.maxC = j;
                    cerrar2 = 1;
                    cerrar = 1;
                }
            }
        }
        cerrar = 0;
        cerrar2 = 0;
        for (int j = 0; j < forma[0].length && cerrar == 0; j++){
            for (int i = 0; i < forma.length && cerrar2 == 0; i++){
                if (forma[i][j]){
                    this.minC = j;
                    cerrar2 = 1;
                    cerrar = 1;
                }
            }
        }
        cerrar = 0;
        cerrar2 = 0;
        for (int i = forma.length - 1; i >= 0 && cerrar == 0; i--){
            for (int j = 0; j < forma[0].length && cerrar2 == 0; j++){
                if (forma[i][j]){
                    this.maxF = i;
                    cerrar2 = 1;
                    cerrar = 1;
                }
            }
        }
    }
    /**
     * Copia la forma booleana base 
     * @return una copia independiente de la matriz de formaBase 
     */
    public boolean[][] copiarForma(){
        boolean[][] formaNueva = new boolean[formaBase.length][formaBase[0].length];
        for (int i = 0; i < formaBase.length; i++) {
            for (int j = 0; j < formaBase[0].length; j++) {
                formaNueva[i][j] = formaBase[i][j];
            }
        }
        return formaNueva;
    }
    /**
     * Copia la forma visible base 
     * @return una copia independiente de formaBaseVisib
     */
    public String[][] copiarFormaVisib(){
        String[][] formaVisibNueva = new String[formaBaseVisib.length][formaBaseVisib[0].length];
        for (int i = 0; i < formaBase.length; i++) {
            for (int j = 0; j < formaBase[0].length; j++) {
                formaVisibNueva[i][j] = formaBaseVisib[i][j];
            }
        }
        return formaVisibNueva;
    }

}


