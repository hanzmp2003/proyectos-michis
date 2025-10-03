// Clase Elemento que representa un elemento con su nombre
public class Elemento {
    private String nombre;

    public Elemento() {
        nombre = "";
    }

    public Elemento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}