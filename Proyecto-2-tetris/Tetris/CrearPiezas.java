/**  
 * Clase CrearPieza se encarga de contruir todas las piezas del tetris usando matrices booleanas y 
 * asignarle colores  
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Chun Ping Liu Li, C5G492
 * @author Emanuel Sancho Sánchez, C07332
 * @author Jefferson Emanuel Miranda Sabala, C24874
 *
 * @version 1.0 
*/

package Tetris;

public class CrearPiezas {

        /**
         * Para reiniciar los colores de ANSI al valor por defecto
         */
    
        public static final String RESET = "\u001B[0m"; 

        /**
         * Lista de colores usando ANSI
         */
        public static final String[] COLORES = {
        "\u001B[0m",      // 0 - vacío
        "\u001B[36m",     // 1 - cyan
        "\u001B[34m",     // 2 - azul
        "\u001B[33m",     // 3 - amarillo
        "\u001B[32m",     // 4 - verde
        "\u001B[35m",     // 5 - magenta
        "\u001B[31m",     // 6 - rojo
        "\u001B[93m"      // 7 - naranja brillante
        };

    /**
     * Arreglo en el que se almacenan todas las piezas
     */
    public Piezas[] todasLasPiezas;  
    //Probablemente cambie los colores luego, con un random para que no sean los mismos siempre


    /** 
     * Acá está el onstructor qeu inicializa cada una de la piezas del tetris con su forma y color
     * respectivamente
     */
    public CrearPiezas(){
        todasLasPiezas = new Piezas[] {
            new Piezas(crearI(), COLORES[1]),
            new Piezas(crearO(), COLORES[2]),
            new Piezas(crearS(), COLORES[3]),
            new Piezas(crearJ(), COLORES[4]),
            new Piezas(crearL(), COLORES[5]),
            new Piezas(crearZ(), COLORES[6]),
            new Piezas(crearT(), COLORES[7])
        };

    }


    /**
     * Se crea la pieza I 
     * @return una matriz 4x4 que da la forma I
     */

    private boolean[][] crearI() {
        return new boolean[][] {
            {false,false,false,false},
            {true , true, true,true },
            {false,false,false,false},
            {false,false,false,false}
        };
    }

    /**
     * Se crea la pieza O 
     * color cyan
     * @return una matriz 2x2 que da la forma O
     */
    private boolean[][] crearO() {
        return new boolean[][] {
            {true, true},
            {true, true}
        };
    }

    
    /**
     * Se crea la pieza S
     * color azul 
     * @return una matriz 3x3 que da la forma S
     */
    private boolean[][] crearS() {
        return new boolean[][] {
            {false, true, true},
            {true,  true, false},
            {false, false,false}
        };
    }
    
    
    /**
     * Se crea la pieza Z
     * color amarillo 
     * @return una matriz 3x3 que da la forma Z
     */
    private boolean[][] crearZ() {
        return new boolean[][] {
            {true,  true, false},
            {false, true, true},
            {false,false,false}
        };
    }

    /**
     * Se crea la pieza L
     * color verde
     * @return una matriz 3x3 que da la forma L
     */
    private boolean[][] crearL() {
        return new boolean[][] {
            {true, false,false},
            {true, true, true},
            {false,false,false}
        };
    }

    
    /**
     * Se crea la pieza J 
     * color magenta 
     * @return una matriz 3x3 que da la forma J
     */

    private boolean[][] crearJ() {
        return new boolean[][] {
            {false, false,true},
            {true, true, true},
            {false,false,false}
        };
    }

    
    /**
     * Se crea la pieza T 
     * color rojo
     * @return una matriz 3x3 que da la forma T
     */
    private boolean[][] crearT() {
        return new boolean[][] {
            {false, true, false},
            {true, true, true},
            {false,false,false}
        };
    }

    
    /**
     * Acá se devuelve una pieza especifica según el índice
     * @param indiceForma es el índice de la pieza en el arreglo 
     * @return la pieza solicitada y devuelve null si el índice no es el correcto
     */
    public Piezas getPieza(int indiceForma) {
        if (indiceForma < 0 || indiceForma >= todasLasPiezas.length) return null;
        return todasLasPiezas[indiceForma];
    }

    /**
     * De las piezas disponibles toma una aleatroriamente y la devuelve
     * @return una pieza al azar de las que están en el arreglo
     */
    public Piezas getPiezaAleatoria() {
        int random = (int)(Math.random() * todasLasPiezas.length);
        return todasLasPiezas[random];
    }
}





