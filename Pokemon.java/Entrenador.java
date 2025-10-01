// Clase Entrenador que representa a un entrenador con su nombre, si es jugador o no, y su equipo de Pokémon
import java.util.Random;
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

    public Ataque ataqueNPC(Pokemon pokemon){
        int posicion = 0;
        int tamaño = 0;
        for (Ataque a : pokemon.getHabilidades()) {
            if (a.getPp()>0){
                tamaño += 1;
            }
        }
        Ataque[] atqdis = new Ataque[tamaño];
        for (int i = 0; i < atqdis.length ; i ++){
            if (pokemon.getHabilidades()[i].getPp() > 0){
                atqdis[posicion] = pokemon.getHabilidades()[i];
                posicion += 1;
            }
        }
        return atqdis[nextInt(tamaño)];
    }

}
