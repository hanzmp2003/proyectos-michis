package Tetris;

public class Piezas { 
    //Los declaro como atributos para luego usarlos en otras clases con los datos guardados
    public boolean[][] piezaI;
    public String[][] piezaColorI;

    public boolean[][] piezaO;
    public String[][] piezaColorO;

    public boolean[][] piezaS;
    public String[][] piezaColorS;

    public boolean[][] piezaJ;
    public String[][] piezaColorJ;

    public boolean[][] piezaL;
    public String[][] piezaColorL;

    public boolean[][] piezaZ;
    public String[][] piezaColorZ;

    public boolean[][] piezaT;
    public String[][] piezaColorT;

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
    //Pieza I
    piezaI = new boolean[4][1];      
    piezaI = CasillaFullTrue(piezaI);
        piezaColorI = CrearPieza(piezaI, 4, 1);

    //Pieza O
    piezaO = new boolean[2][2];      
    piezaO = CasillaFullTrue(piezaI);
        piezaColorO = CrearPieza(piezaO, 2, 2);

    //Pieza S
    piezaS = new boolean[2][3];  
    piezaS [0][1] = true;
    piezaS [0][2] = true;
    piezaS [1][0] = true;
    piezaS [1][1] = true;

    piezaColorS = CrearPieza(piezaS, 2, 3);

    //Pieza J
    piezaJ = new boolean[3][2];   
    piezaJ [0][1] = true;
    piezaJ [1][1] = true;
    piezaJ [2][0] = true;
    piezaJ [2][1] = true;

    piezaColorJ = CrearPieza(piezaJ, 3, 2);
    
    //Pieza L
    piezaL = new boolean[3][2];    
    piezaL [0][0] = true;
    piezaL [1][0] = true;
    piezaL [2][0] = true;
    piezaL [2][1] = true;

    piezaColorL = CrearPieza(piezaL, 3, 2);


    //Pieza Z
    piezaZ = new boolean[2][3]; 
    piezaZ [0][0] = true;
    piezaZ [0][1] = true;
    piezaZ [1][1] = true;
    piezaZ [1][2] = true;
    piezaColorZ = CrearPieza(piezaZ, 2, 3);

    //Pieza T
    piezaT = new boolean[2][3];
    piezaT [0][0] = true;
    piezaT [0][1] = true;
    piezaT [1][1] = true;
    piezaT [1][2] = true;
    piezaColorT = CrearPieza(piezaT, 2, 3);
        
    }

    public String[][] CrearPieza(boolean[][] pieza, int filaPieza, int columnaPieza){
    String[][] piezaColor = new String[filaPieza][columnaPieza];

         for (int i = 0; i < pieza.length; i++) {
         for (int j = 0; j < pieza[i].length; j++) {
            if(pieza[i][j]){   //Si la pieza es verdadera, entonces obtiene un bloque de color
                piezaColor[i][j] = COLORES[1] + "██" + RESET; //Asigno un color por defecto, luego lo cambio con un random
                System.out.print(piezaColor[i][j]);
            } else {
                piezaColor[i][j] = "  ";  //Si es falso, se le asigna un espacio
                System.out.print("  ");

                }

  
                } 

            }

           return piezaColor;   
        }


    //Esto lo cree porque me daba hueva ir uno por uno diciendo qe es true    
    public boolean[][] CasillaFullTrue(boolean[][] pieza){
        for (int i = 0; i < pieza.length; i++) {
        for (int j = 0; j < pieza[i].length; j++) {
        pieza[i][j] = true;
            }    
        }
        return pieza;


    }


}


