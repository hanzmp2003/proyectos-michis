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
    private Puntaje puntaje;

    public Tabla() {
        input = new Scanner(System.in);
        puntaje = new Puntaje();
        iniciarTabla();
        iniciarFijo();
        Piezas pieza = piezas.getPiezaAleatoria();
        piezaSiguiente = piezas.getPiezaAleatoria();

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
                int lineasEliminadas = eliminarLineasCompletas();
                puntaje.calcularPuntos(lineasEliminadas);
                pieza = iniciarNuevaPieza();
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
                    int lineasEliminadas = eliminarLineasCompletas();
                    puntaje.calcularPuntos(lineasEliminadas);
                    pieza = iniciarNuevaPieza();
                    if (!puedeColocar(pieza, pieza.posF, pieza.posC)) {
                        System.out.println("Game Over");
                        break;
                    }
                }
            }
        }
    }


    // Dibuja frame: primero coloca el fijo sobre el tablero, luego la pieza encima.
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

    }

    //Reinicia las coordenadas de la nueva pieza para evitar errores de colisión
    //Asi evita que el programa detecte que tiene las mismas coordenadas que la anterior pieza :)
    private Piezas iniciarNuevaPieza() {
        Piezas nueva = piezaSiguiente;
        piezaSiguiente = piezas.getPiezaAleatoria();
        nueva.posF = 0; 
        nueva.posC = 3;  //posición 3 para manterner incialmente la pieza centrada
        return nueva;
    }


    private int calcularAlturaCaida(Piezas pieza) {
        int fila = pieza.posF;
        //verifica si la pieza puede moverse una fila más abajo sin chocar con el fondo o con otras piezas ya fijadas
        while (puedeColocar(pieza, fila + 1, pieza.posC)) {
        fila++;
        }
        return fila;
    }

    //eliminar lineas full true
    public int eliminarLineasCompletas(){
        int lineasEliminadas = 0;
        for (int fila = 0; fila < fijo.length; fila++) {
        boolean completa = true;

        for (int col = 0; col < fijo[0].length; col++) {
            if (!fijo[fila][col]) {  //si detecta qe hay una columna falsa indica que la linea no esta completa
                completa = false;
                break;
            }
        }

            if (completa) {
            lineasEliminadas++;

            //mueve todas las piezas superiores hacia abajo
            for (int f = fila; f > 0; f--) {
                for (int c = 0; c < fijo[0].length; c++) {
                    fijo[f][c] = fijo[f - 1][c];
                    fijoVisib[f][c] = fijoVisib[f - 1][c];
                }
            }

            //limpia la fila en la que estaba las piezas anteriores
            for (int c = 0; c < fijo[0].length; c++) {
                fijo[0][c] = false;
                fijoVisib[0][c] = "  ";
            }

            fila--;
            }   
        }
        
        return lineasEliminadas;
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