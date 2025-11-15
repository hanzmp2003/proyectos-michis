package Tetris;

import java.util.ArrayList;

public class EstadisticaColores {

    private ArrayList<String> colores;
    private ArrayList<Integer> cantidad;

    private int puntajeFilaBase;   // puntaje sin combo
    public int puntajeTotal;      // puntaje acumulado

    private String ultimoColorDominante = null;
    private int comboActual = 1;

    public EstadisticaColores(){
        colores = new ArrayList<>();
        cantidad = new ArrayList<>();
    }

    // registra 1 color
    public void registrarColores(String color){
        int index = colores.indexOf(color);

        if (index == -1){
            colores.add(color);
            cantidad.add(1);
        } else {
            cantidad.set(index, cantidad.get(index) + 1);
        }
    }

    /** 
     * Registra una fila completa de colores
     * @param fila Arreglo de Strings representando los colores de la fila
    */
    public void registrarFila(String[] fila){

        reset(); // borra conteos previos

        for (String c : fila){
            if (c != null && !c.equals("")){
                registrarColores(c);
            }
        }

        // Calcular puntaje por fila
        puntajeFilaBase = construirArbol().puntaje();

        // Obtener color dominante de la fila
        String dominante = colorDominante();

        // Obtener comboActual
        if (ultimoColorDominante == null){ // Si es primera fila eliminada
            comboActual = 1;
        }
        else if (dominante.equals(ultimoColorDominante)){ // Si la fila actual coincide con la anterior eliminada
            comboActual++; // aumenta combo
        }
        else {
            comboActual = 1; // se reinicia
        }

        ultimoColorDominante = dominante; // Toma como último color dominante, al de la fila actual

        // Sumar puntaje total
        puntajeTotal += puntajeFilaBase * comboActual;
    }

    public void mostrarEstadisticas(){
        System.out.println("Última fila procesada:");
        for (int i = 0; i < colores.size(); i++){
             System.out.println(colores.get(i) + ": " + cantidad.get(i));
        }

        System.out.println("Puntaje base de la fila: " + puntajeFilaBase);
        System.out.println("Combo: ¡x" + comboActual + "!");
        System.out.println("Puntaje total acumulado: " + puntajeTotal);
    }
    
    public int getPuntajeTotal(){
        return puntajeTotal;
    }

    private void reset(){
        colores.clear();
        cantidad.clear();
    }

    public ArbolColores construirArbol(){
        ArbolColores arbol = new ArbolColores();

        for (int i = 0; i < colores.size(); i++){
            arbol.insertar(colores.get(i), cantidad.get(i));
        }

        return arbol;
    }

    /** 
     * Obtiene el color dominante de la fila actual
    */
    public String colorDominante(){
        if (colores.isEmpty()) return null;

        int max = -1;
        String dominante = null;

        for (int i = 0; i < colores.size(); i++){
            if (cantidad.get(i) > max){
                max = cantidad.get(i);
                dominante = colores.get(i);
            }
        }

        return dominante;
    }

    public void resetCombo(){
        ultimoColorDominante = null;
        comboActual = 1;
    }

    public String getCombo(){
        if (comboActual > 1){
            return "Combo: ¡x" + comboActual + "!";
        } else {
            return "";
        }
    }

}
