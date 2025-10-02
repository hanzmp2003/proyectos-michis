// Clase Gimnasio que representa un gimnasio con su nombre, tipo y nivel
public class Gimnasio {
    private String nombre;
    private String dificultad;  // Es para mencionar si es facil, intermedio o díficil

    // Constructor con parámetros
    public Gimnasio(String nombre, String dificultad) {
        this.nombre = nombre;
        this.dificultad = dificultad;
    }

    // Getters y setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setNivel(String nivel) { this.dificultad = nivel; }

    public String getNombre() { return nombre; }
    public String getNivel() { return dificultad; } 
    
}
