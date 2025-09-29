public class Entrenador {
    private String nombre;
    private boolean esJugador;
    private Pokemon[] equipo;

    public Entrenador(String nombre, boolean esJugador, Pokemon[] equipo) {
        this.nombre = nombre;
        this.esJugador = esJugador;
        this.equipo = equipo;
    }

    // Getters y setters
    public String getNombre() { 
        return nombre; 
        }

    public void setNombre(String nombre) { 
        this.nombre = nombre; 
        }

    public boolean isEsJugador() { 
        return esJugador; 
        }
    public void setEsJugador(boolean esJugador) { 
        this.esJugador = esJugador; 
        }

    public Pokemon[] getEquipo() { 
        return equipo; 
        }

    public void setEquipo(Pokemon[] equipo) { 
        this.equipo = equipo; 
        }
}
