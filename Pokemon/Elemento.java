 
/** 
 * Clase Elemento que representa un elemento con su nombre, permite acceder 
 * @author Hanz Madrigal Porras, C4G754
   @author Chun Ping Liu Li, C5G492
   @author Emanuel Sancho Sánchez, C07332
   @author Jefferson Emanuel Miranda Sabala, C24874
 
 * @version 1.0
 */

/**
 * clase con nombre del elemento como atributo
 */
public class Elemento {
    private String nombre;

/**
 * Constructor que inicializa el elemento con el nombre
 */
    public Elemento() {
        nombre = "";
    }

    public Elemento(String nombre) {
        this.nombre = nombre;
    }

/**
 * @return nombre del elemento 
 */
    public String getNombre() { return nombre; }

/**
 * Se modifica el nombre del elemento 
 * @param nombre 
 */
    public void setNombre(String nombre) { this.nombre = nombre; }
}