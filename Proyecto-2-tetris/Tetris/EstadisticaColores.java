package Tetris;
import java.util.ArrayList;
public class EstadisticaColores {  //Aqui se registra los colores de la fila eliminada, clase por aparte para no recargar Tabla
    private ArrayList<String> colores;
    private ArrayList<Integer> cantidad;
    private int puntaje;
    public EstadisticaColores(){
        colores = new ArrayList<String>();
        cantidad = new ArrayList<Integer>();
    }

    public void registrarColores(String color){
        int ubicarColor = colores.indexOf(color); //Busca la posición del color 

        if(ubicarColor == -1){  //Si el color no está, agrega (Manejo de errores)
            colores.add(color);
            cantidad.add(1);
        }else{
            cantidad.set(ubicarColor, cantidad.get(ubicarColor) + 1); //Si encuentra el color el contador aumenta
            
        }


    }

    public void registrarFila(String[] fila){    //registra todos los colores de una fila del tablero
        reset();
        for(int i = 0; i < fila.length; i ++){
            if(fila[i] != null && !fila[i].equals("")){
                registrarColores(fila[i]);

            }
        }
        puntaje = construirArbol().puntaje();
    }

    public void mostrarEstadisticas(){
        System.out.println("Colores Registrados :D");
        for (int i = 0; i < colores.size(); i++) {
            System.out.println(colores.get(i) + ": " + cantidad.get(i));
        }
        System.out.println("Puntaje de la fila: " + puntaje);
    }

    public int getCantidad(String color){
        int index = colores.indexOf(color);
        if (index == -1) return 0;
        return cantidad.get(index);
    }

    public void reset(){
        colores.clear();
        cantidad.clear();
    }

    public ArbolColores construirArbol(){
        ArbolColores arbol = new ArbolColores();
        
        for (int i =0; i< colores.size(); i++){
            String color = colores.get(i);
            int cant = cantidad.get(i);
            arbol.insertar(color,cant);
        }

        return arbol;
    }

}




