/**
 * Esta clase se encarga del tablero principal del tetris, controla caida de piezas, la líneas que 
 * se completan, colisiones y actualización del puntaje 
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Chun Ping Liu Li, C5G492
 * @author Emanuel Sancho Sánchez, C07332
 * @author Jefferson Emanuel Miranda Sabala, C24874
 *
 * @version 1.0 
 */

package Tetris;
import java.util.Scanner;

// La transformación de las piezas al tablero será sumarle 3 a las columnas.

public class Tabla{
    private CrearPiezas piezas = new CrearPiezas();
    private String[][] tab = new String[20][10];
    private boolean[][] fijo = new boolean[20][10];
    private String[][] fijoVisib = new String[20][10];
    private Piezas piezaSiguiente;
    private Scanner input;
    private Puntaje puntaje;
    private EstadisticaColores statsColores;


    /**
     * Este es el constructor de la clase Tabla que se encarga de inicializar las estructuras del tetris
     */
    public Tabla() {
        input = new Scanner(System.in);
        puntaje = new Puntaje();
        iniciarTabla();
        iniciarFijo();
        statsColores = new EstadisticaColores();
        Piezas pieza = piezas.getPiezaAleatoria();
        piezaSiguiente = piezas.getPiezaAleatoria();

        String opcion = "";
        while (!opcion.equals("salir")) {
            dibujarPieza(pieza, tab);
            imprimirTab(tab, piezaSiguiente);
            opcion = input.nextLine().trim();

            if (opcion.equals("s")) {
                Sonido.reproducir("Paquete_sonidos/SFX_PieceHardDrop.wav");
                // baja hasta el fondo
                while (puedeColocar(pieza, pieza.posF + 1, pieza.posC)) {
                    pieza.posF += 1;
                }
                fijarPiezaEnFijo(pieza);
                int lineasEliminadas = eliminarLineasCompletas(0,0);
                puntaje.calcularPuntos(lineasEliminadas);
                pieza = iniciarNuevaPieza();
                if (!puedeColocar(pieza, pieza.posF, pieza.posC)) {
                    Sonido.reproducir("Paquete_sonidos/SFX_GameOver.wav");
                    System.out.println("\u001B[1;31m=== GAME OVER ===\u001B[0m");
                    try { Thread.sleep(4500); } catch (InterruptedException ignored) {}

                    break;
                }
            } else {
                // mover o rotar normalmente
                pieza.moverPieza(opcion);

                // baja una posición si puede solo una casilla
                if (puedeColocar(pieza, pieza.posF + 1, pieza.posC)) {
                    pieza.posF += 1;
                } else {
                    // Si no puede bajar, se fija automáticamente
                    fijarPiezaEnFijo(pieza);
                    int lineasEliminadas = eliminarLineasCompletas(0,0);
                    puntaje.calcularPuntos(lineasEliminadas);
                    pieza = iniciarNuevaPieza();
                    if (!puedeColocar(pieza, pieza.posF, pieza.posC)) {
                        Sonido.reproducir("Paquete_sonidos/SFX_GameOver.wav");
                        System.out.println("\u001B[1;31m=== GAME OVER ===\u001B[0m");
                        try { Thread.sleep(4500); } catch (InterruptedException ignored) {}
                        break;
                    }
                }
            }
        }
    }


    // Dibuja frame: primero coloca el fijo sobre el tablero, luego la pieza encima.
    /**
     * Dibuja el tablero mezclado las piezas, la pieza actual y la sombra 
     * @param pieza es la pieza actual 
     * @param tab es el tablero visible 
     */
    public void dibujarPieza(Piezas pieza, String[][] tab){
        iniciarTabla(); 
        //Copiar tablero fijo
        for (int i = 0 ; i < fijoVisib.length ; i++) {
            for (int j = 0 ; j < fijoVisib[0].length ; j++) {
                tab[i][j] = fijoVisib[i][j];
            }
        }

        // calcular la pieza donde podría caer (El Ghost piece lo tuve que buscar para programarlo)
        int sombraF = calcularAlturaCaida(pieza);

        // dibujar la sombra
        for (int i = 0 ; i < pieza.formaVisib.length ; i++) {
            for (int j = 0 ; j < pieza.formaVisib[0].length ; j++){
                if (!pieza.forma[i][j]) continue;
                int fila = sombraF + i;
                int col  = pieza.posC + j;
                if (fila >= 0 && fila < tab.length && col >= 0 && col < tab[0].length) {
                tab[fila][col] = "\u001B[37m░░\u001B[0m"; 
                }
            }
        }

        // superponer la pieza actual
        for (int i = 0 ; i < pieza.formaVisib.length ; i++) {
            for (int j = 0 ; j < pieza.formaVisib[0].length ; j++){
                int fila = i + pieza.posF;
                int col  = j + pieza.posC;
                // asegurar que no salimos del tablero al dibujar
                if (fila >= 0 && fila < tab.length && col >= 0 && col < tab[0].length) {
                    tab[fila][col] = pieza.formaVisib[i][j];
                }
            }
        }
    }

    /**
     * Imprime el tablero completo y la pieza siguiente 
     * @param tab es el tablero principal 
     * @param piezaSiguiente  es la pieza que va a ser usada en el juego 
     */
    public void imprimirTab(String[][] tab, Piezas piezaSiguiente){
        System.out.println("+--------------------+     Próxima pieza:");
        //Variables extras para hacerlo bien aesthethic :DD
        int altura = tab.length;
        int ancho  = tab[0].length;
        int altoSig = piezaSiguiente.formaVisib.length;
        int anchoSig = piezaSiguiente.formaVisib[0].length;

        for (int i = 0; i < altura; i++) {
        System.out.print("|");

            // imprime el tablero normal
            for (int j = 0; j < ancho; j++) {
            System.out.print(tab[i][j]);
            }
            System.out.print("|");

            // imprime la pieza siguiente a la derecha de la original
            if (i < altoSig) {
            System.out.print("     ");
            for (int j = 0; j < anchoSig; j++) {
                System.out.print(piezaSiguiente.formaVisib[i][j]);
                }
            }
            
            System.out.println();
        }

        System.out.println("+--------------------+");
        puntaje.mostrarPuntaje();
        statsColores.mostrarEstadisticas();
    }

    
    /**
     * Reinicia el tablero visible
     */
    public void iniciarTabla(){
        for (int i = 0 ; i < tab.length ; i++){
            tab[i] = new String[]{"  ","  ","  ","  ","  ","  ","  ","  ","  ","  "};
        }
    }
    /**
     * Acá inicializa la matriz de bloques que ya se han fijado al inicio
     */
    private void iniciarFijo() {
        for (int i = 0; i < fijo.length; i++) {
            for (int j = 0; j < fijo[0].length; j++) {
                fijo[i][j] = false;
            }
        }
        for (int i = 0; i < fijoVisib.length; i++) {
            for (int j = 0; j < fijoVisib[0].length; j++) {
                fijoVisib[i][j] = "  ";
            }
        }
    }

    // comprueba si una forma (la de la pieza) cabe en posF,posC sin colisionar

/**
 * Se verifica si una pieza se puede colocar en la posisción dada 
 * @param pieza es la pieza que se va a revisar 
 * @param posF fila objetivo 
 * @param posC columna objetivo 
 * @return true si la pieza no choca con los límites ni con los bloques ya fijados 
 */
    public boolean puedeColocar(Piezas pieza, int posF, int posC) {
        boolean[][] forma = pieza.forma;
        for (int i = 0; i < forma.length; i++) {
            for (int j = 0; j < forma[0].length; j++) {
                if (!forma[i][j]) continue; 
                int fila = posF + i;
                int col  = posC + j;
                if (fila < 0 || fila >= fijo.length || col < 0 || col >= fijo[0].length) return false;
                if (fijo[fila][col]) return false;
            }
        }
        return true;
    }

    
    /**
     * Pasa una pieza al tablero de bloques fijados 
     * @param pieza es la pieza a fijar
     */
    public void fijarPiezaEnFijo(Piezas pieza) {
        for (int i = 0; i < pieza.forma.length; i++) {
            for (int j = 0; j < pieza.forma[0].length; j++) {
                if (pieza.forma[i][j]) {
                    int fila = pieza.posF + i;
                    int col  = pieza.posC + j;
                    if (fila >= 0 && fila < fijo.length && col >= 0 && col < fijo[0].length) {
                        fijo[fila][col] = true;
                        fijoVisib[fila][col] = pieza.formaVisib[i][j];
                    }
                }
            }
        }

    }

    
    //Asi evita que el programa detecte que tiene las mismas coordenadas que la anterior pieza :)
    /**
     * Crea una pieza nueva con posición inicial reiniciada 
     * @return Nueva pieza lista para colocarse 
     */
    private Piezas iniciarNuevaPieza() {
        Piezas nueva = piezaSiguiente;
        piezaSiguiente = piezas.getPiezaAleatoria();
        nueva.posF = 0; 
        nueva.posC = 3;  //posición 3 para manterner incialmente la pieza centrada
        return nueva;
    }

    /**
     * Calcula donde caerá una pieza cuando se suelta 
     * @param pieza es la pieza actual 
     * @return es la fila más baja posible sin colisión 
     */

    private int calcularAlturaCaida(Piezas pieza) {
        int fila = pieza.posF;
        //verifica si la pieza puede moverse una fila más abajo sin chocar con el fondo o con otras piezas ya fijadas
        while (puedeColocar(pieza, fila + 1, pieza.posC)) {
        fila++;
        }
        return fila;
    }

    /**
     * Elimina las líneas completas del tablero fijo de forma recursiva
     * @param lineasEliminadas es el contador que acumula las líneas que se quitaron 
     * @param fila es la fila actual a revisar 
     * @return la cantidad total de líneas eliminadas 
     */
    public int eliminarLineasCompletas(int lineasEliminadas, int fila) {
            boolean completa = true;

            for (int col = 0; col < fijo[0].length; col++) {
                if (!fijo[fila][col]) { 
                    // si detecta qe hay una columna falsa indica que la linea no esta completa
                    completa = false;
                    break;
                }
            }
            if (completa) {
                lineasEliminadas++;
                Sonido.reproducir("Paquete_sonidos/SFX_SpecialLineClearTriple.wav");

                statsColores.registrarFila(fijoVisib[fila]);

                // mueve todas las piezas superiores hacia abajo
                for (int f = fila; f > 0; f--) {
                    for (int c = 0; c < fijo[0].length; c++) {
                        fijo[f][c] = fijo[f - 1][c];
                        fijoVisib[f][c] = fijoVisib[f - 1][c];
                    }
                }
                // limpia la fila en la que estaba las piezas anteriores
                for (int c = 0; c < fijo[0].length; c++) {
                    fijo[0][c] = false;
                    fijoVisib[0][c] = "  ";
                }

                fila--;
            }
            if(fila < fijo.length-1){
                lineasEliminadas=eliminarLineasCompletas(lineasEliminadas, fila+1);
            }
        return lineasEliminadas;
    }
    

}