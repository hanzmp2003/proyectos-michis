package Tetris;

public class CrearPiezas { //se encarga de construir todas las formas y asignarles colores.

    //Colores usando ANSI
        public static final String RESET = "\u001B[0m"; //para reiniciar cada que se crea una pieza
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

    public Piezas[] todasLasPiezas;  //Creo una lista para almacenar todas las formas para el tetris
    //Probablemente cambie los colores luego, con un random para que no sean los mismos siempre

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
    //Pieza I : 0
    private boolean[][] crearI() {
        return new boolean[][] {
            {false,false,false,false},
            {true , true, true,true },
            {false,false,false,false},
            {false,false,false,false}
        };
    }

    //Pieza O : 1
    private boolean[][] crearO() {
        return new boolean[][] {
            {true, true},
            {true, true}
        };
    }

    //Pieza S : 2
    private boolean[][] crearS() {
        return new boolean[][] {
            {false, true, true},
            {true,  true, false},
            {false, false,false}
        };
    }
    
    //Pieza Z : 3
    private boolean[][] crearZ() {
        return new boolean[][] {
            {true,  true, false},
            {false, true, true},
            {false,false,false}
        };
    }

    //Pieza L : 4
    private boolean[][] crearL() {
        return new boolean[][] {
            {true, false,false},
            {true, true, true},
            {false,false,false}
        };
    }

    //Pieza J : 5
    private boolean[][] crearJ() {
        return new boolean[][] {
            {false, false,true},
            {true, true, true},
            {false,false,false}
        };
    }

    //Pieza T : 6
    private boolean[][] crearT() {
        return new boolean[][] {
            {false, true, false},
            {true, true, true},
            {false,false,false}
        };
    }

    // Obtener una pieza específica (Por si necesitan escoger una pieza específica :) )
    public Piezas getPieza(int indiceForma) {
        if (indiceForma < 0 || indiceForma >= todasLasPiezas.length) return null;
        return todasLasPiezas[indiceForma];
    }

    // Obtener una pieza aleatoria
    public Piezas getPiezaAleatoria() {
        int random = (int)(Math.random() * todasLasPiezas.length);
        return todasLasPiezas[random];
    }
}





