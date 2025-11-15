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

    // private Tabla tablero = new Tabla();

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
     * 
     * Evita colisiones fantasmas y que la pieza se deforme
     */
    public void moverPieza(String direccion, Tabla tablero) {
        boolean movido = false;

        switch (direccion) {

            case "s":
                if (tablero.puedeColocar(this, posF + 1, posC)) {
                    posF++;
                    movido = true;
                }
                break;

            case "a":
                if (tablero.puedeColocar(this, posF, posC - 1)) {
                    posC--;
                    movido = true;
                    Sonido.reproducir("Paquete_sonidos/SFX_PieceMoveLR.wav");
                }
                break;

            case "d":
                if (tablero.puedeColocar(this, posF, posC + 1)) {
                    posC++;
                    movido = true;
                    Sonido.reproducir("Paquete_sonidos/SFX_PieceMoveLR.wav");
                }
                break;

            case "w":
                boolean[][] formaAntes = copiarForma();
                String[][] formaVisibAntes = copiarFormaVisib();

                rotar90();
                this.forma = copiarForma();
                this.formaVisib = copiarFormaVisib();

                if (tablero.puedeColocar(this, posF, posC)) {
                    movido = true;
                    Sonido.reproducir("Paquete_sonidos/SFX_PieceRotateLR.wav");
                }

                else if (tablero.puedeColocar(this, posF, posC + 1)) {
                    posC++;
                    movido = true;
                    Sonido.reproducir("Paquete_sonidos/SFX_PieceRotateLR.wav");
                }

                else if (tablero.puedeColocar(this, posF, posC + 2)) {
                    posC += 2;
                    movido = true;
                    Sonido.reproducir("Paquete_sonidos/SFX_PieceRotateLR.wav");
                }

                else if (tablero.puedeColocar(this, posF, posC - 1)) {
                    posC--;
                    movido = true;
                    Sonido.reproducir("Paquete_sonidos/SFX_PieceRotateLR.wav");
                }

                else if (tablero.puedeColocar(this, posF, posC - 2)) {
                    posC -= 2;
                    movido = true;
                    Sonido.reproducir("Paquete_sonidos/SFX_PieceRotateLR.wav");
                }

                else if (tablero.puedeColocar(this, posF + 1, posC)) {
                    posF++;
                    movido = true;
                    Sonido.reproducir("Paquete_sonidos/SFX_PieceRotateLR.wav");
                }

                else {
                    // Nada funcionó → revertir
                    this.formaBase = formaAntes;
                    this.formaBaseVisib = formaVisibAntes;
                    this.forma = copiarForma();
                    this.formaVisib = copiarFormaVisib();
                }

                break;
        }

        if ((direccion.equals("a") || direccion.equals("d") || direccion.equals("w")) && !movido) {
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

    public void calcularLimites() {
        minC = forma[0].length;
        maxC = -1;
        maxF = -1;

        for (int i = 0; i < forma.length; i++) {
            for (int j = 0; j < forma[0].length; j++) {
                if (forma[i][j]) {
                    if (j < minC) minC = j;
                    if (j > maxC) maxC = j;
                    if (i > maxF) maxF = i;
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


