package Tetris;

public class Tabla{
    public static void main(String[] args) {
        String[][] pieza = new String[][]{{"██","██"},
                                          {"  ","██"},
                                          {"  ","██"}};
        String[][] tablero = new String[20][10];
        for (int i = 0 ; i < tablero.length ; i++){
            tablero[i] = new String[]{"  ","  ","  ","  ","  ","  ","  ","  ","  ","  "};
        }
        tablero[0][3] = pieza[0][0];
        tablero[0][4] = pieza[0][1];
        tablero[1][3] = pieza[1][0];
        tablero[1][4] = pieza[1][1];
        tablero[2][3] = pieza[2][0];
        tablero[2][4] = pieza[2][1];
        for (String[] i : tablero){
            for (String j : i){
                System.out.print(j);
            }
            System.out.println();
        }                                               
    }
}