// Clase Gimnasio que representa un gimnasio con su nombre, tipo y nivel
public class Gimnasio {
    private String nombre;
    private String tipo; 
    private int nivel;

    // Constructor con parámetros
    public Gimnasio(String nombre, String tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    // Constructor vacío
    public Gimnasio() {
        this.nombre = "";
        this.tipo = "";
        this.nivel = 0;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getNivel() { return nivel; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setNivel(int nivel) { this.nivel = nivel; }
}
