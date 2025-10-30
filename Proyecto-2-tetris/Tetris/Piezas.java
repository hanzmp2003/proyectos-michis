public class Piezas { //encapsula la lógica de rotación y visualización.
    public static final String RESET = "\u001B[0m";
    public boolean[][] forma;
    public String color;

    //Esto es util para cuando crea las piezas en otra clase, esto para simplificar el código
    public Piezas(boolean[][] forma, String color) {
        this.forma = forma;
        this.color = color;
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
}


