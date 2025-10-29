public class Piezas {

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

    public Piezas(){
    boolean [][] piezaI = new boolean[4][1];      //Pieza I
        for (int i = 0; i < piezaI.length; i++) {
        for (int j = 0; j < piezaI[i].length; j++) {
        piezaI[i][j] = true;
    }    



    String [][] piezaO = new String[2][4];      //Pieza O
    String [][] piezaS = new String[2][3];      //Pieza S
    String [][] piezaJ = new String[3][2];      //Pieza J
    String [][] piezaL = new String[3][2];      //Pieza L
    String [][] piezaZ = new String[2][3];      //Pieza Z
    String [][] piezaT = new String[2][3];      //Pieza T



    }
  }


    public String[][] CrearPieza(boolean[][] pieza, int filaPieza, int columnaPieza){
    String[][] piezaColor = new String[filaPieza][columnaPieza];

         for (int i = 0; i < pieza.length; i++) {
         for (int j = 0; j < pieza[i].length; j++) {
            if(pieza[i][j]){   //Si la pieza es verdadera, entonces obtiene un bloque de color
                piezaColor[i][j] = COLORES[1] + "██" + RESET;
                System.out.print(COLORES[1] + "██" + RESET);  //Asigno un color por defecto, luego lo cambio con un random

                }else{


                }

  
                } 

            }

           return piezaColor;   
        }

    
}
