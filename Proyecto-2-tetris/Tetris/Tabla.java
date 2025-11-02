package Tetris;
import java.util.Random;
import java.util.Scanner;

// La transformación de las piezas al tablero será sumarle 3 a las columnas.

public class Tabla{
    private Random rand;
    private CrearPiezas piezas = new CrearPiezas();
    private String[][] tab = new String[20][10];
    private boolean[][] fijo = new boolean[20][10];
    private String[][] fijoVisib = new String[20][10];
    private Piezas piezaSiguiente;
    private Scanner input;

    public Tabla() {
        input = new Scanner(System.in);
        iniciarTabla();
        iniciarFijo();
        Piezas pieza = piezas.getPiezaAleatoria();
        piezaSiguiente = piezas.getPiezaAleatoria();

        // String opcion = "";
        // while (!opcion.equals("salir")) { 
        //     dibujarPieza(pieza, tab);
        //     imprimirTab(tab);
        //     opcion = input.nextLine();
        //     pieza.moverPieza(opcion);
        // }

        String opcion = "";
        while (!opcion.equals("salir")) {
            dibujarPieza(pieza, tab);
            imprimirTab(tab, piezaSiguiente);
            opcion = input.nextLine().trim();

            if (opcion.equals("s")) {
                // baja hasta el fondo
                while (puedeColocar(pieza, pieza.posF + 1, pieza.posC)) {
                    pieza.posF += 1;
                }
                fijarPiezaEnFijo(pieza);
                pieza = piezaSiguiente;
                piezaSiguiente = piezas.getPiezaAleatoria();
                if (!puedeColocar(pieza, pieza.posF, pieza.posC)) {
                    System.out.println("Game Over");
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
                    pieza = piezaSiguiente;
                    piezaSiguiente = piezas.getPiezaAleatoria();

                    // Ajuste de posición inicial(Mauskeherramienta para reiniciar las coordenadas de la nueva pieza actual)
                    //Asi evita que el programa detecte que tiene las mismas coordenadas que la anterior pieza :)
                    pieza.posF = 0;
                    pieza.posC = 3; // centrada en el tablero

                    if (!puedeColocar(pieza, pieza.posF, pieza.posC)) {
                        System.out.println("Game Over");
                        break;
                    }
                }
            }
        }
    }

    //Importante y por comodidad: las piezas deben reflejar la sombra en donde cae porque al no ser visible luego provoca un error de colisión. 
    //O al menos reflejar un mensaje mencionando el error.

    // Dibuja frame: primero coloca el fijo sobre el tablero, luego la pieza encima.
    public void dibujarPieza(Piezas pieza, String[][] tab){
        iniciarTabla(); 
        for (int i = 0 ; i < fijoVisib.length ; i++) {
            for (int j = 0 ; j < fijoVisib[0].length ; j++) {
                tab[i][j] = fijoVisib[i][j];
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
            System.out.print("    ");
            for (int j = 0; j < anchoSig; j++) {
                System.out.print(piezaSiguiente.formaVisib[i][j]);
                }
            }

            //Aqui se pone el contador para que aparezca el puntaje 
            System.out.println();
        }

        System.out.println("+--------------------+");
    }

    

    public void iniciarTabla(){
        for (int i = 0 ; i < tab.length ; i++){
            tab[i] = new String[]{"  ","  ","  ","  ","  ","  ","  ","  ","  ","  "};
        }
    }
    // inicializa las estructuras del tablero fijo
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

    // omprueba si una forma (la de la pieza) cabe en posF,posC sin colisionar
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

    // fija la pieza en el tablero fijo (cuando toca fondo o no puede bajar)
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
    // public void moverPieza(String s, Piezas pieza, String[][] tab){
    //     if (s.equals("s")){
    //         for (int i = pieza.posPieza.length - 1; i >= 0; i--){
    //             for (int j = pieza.posPieza[0].length - 1; j >= 0; j--){
    //                 if (pieza.posPieza[i][j]){
    //                     pieza.posPieza[i+1][j] = pieza.posPieza[i][j];
    //                     pieza.posPieza[i][j] = false;
    //                     tab[i+1][j] = tab[i][j];
    //                     tab[i][j] = "  ";
    //                 }
    //             }
    //         }
    //     }
    // }
    }
}