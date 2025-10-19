/**  
 * Clase Entrenador que representa a un entrenador con su nombre, si es jugador o no, y su equipo de Pokémon
 * @author Hanz Madrigal Porras, C4G754
 * @author Chun Ping Liu Li, C5G492
 * @author Emanuel Sancho Sánchez, C07332
 * @author Jefferson Emanuel Miranda Sabala, C24874
 * 
 * @version 1.0

*/
import java.util.Random;

public class Entrenador {
    private String nombre;
    private boolean esJugador;
    private Pokemon[] equipo;
    private boolean estado;
/**
 * Inicializador
 * @param nombre del entrenador 
 * @param esJugador 
 * @param equipo arreglo de pokemon 
 */
    public Entrenador(String nombre, boolean esJugador, Pokemon[] equipo) {
        this.nombre = nombre;
        this.esJugador = esJugador;
        this.equipo = equipo;
        this.estado = true;
    }

    /**
     * Getter
     * @return nombre 
     */ 
    public String getNombre() { 
        return nombre; 
        }

    /**
     * Setter
     * @param nombre 
     */

    public void setNombre(String nombre) { 
        this.nombre = nombre; 
        }

    public boolean isEsJugador() { 
        return esJugador; 
        }

    /**
     *@param esjugador
     */
    public void setEsJugador(boolean esJugador) { 
        this.esJugador = esJugador; 
        }
    /**
     * @return equipo 
     */
    public Pokemon[] getEquipo() { 
        return equipo; 
        }

    public void setEquipo(Pokemon[] equipo) { 
        this.equipo = equipo; 
        }
    
    public boolean getEstado(){
        return estado;
    }

    /**Reiniciar estadísticas de entrenadores y jugador luego de cada combate
     */ 
    public void reiniciarEstadisticas(){
        for (Pokemon i : equipo){
            i.resetHp();
            i.setEstado(true);
            for (Ataque j : i.getHabilidades()) {
                j.resetPP();
            }
        }
    }

    
    /**
     * Selecciona aleatoriamente un Pokémon 
     * 
     * @return Pokémon seleccionado
     */
    public Pokemon elegirPokeNPC(){
        Random rand = new Random();
        int posicion = 0;
        int tamaño = 0;
        for (Pokemon a : equipo) {
            if (a.getHp()>0){
                tamaño += 1;
            }
        }
        Pokemon[] pokemones = new Pokemon[tamaño];
        for (int i = 0; i < equipo.length ; i ++){
            if (equipo[i].getHp() > 0){
                pokemones[posicion] = equipo[i];
                posicion += 1;
            }
        }
        
        if (tamaño > 0){
            return pokemones[rand.nextInt(tamaño)];
        } else {
            return null;
        }
    }
    /**
     * Devuelve el índice del primer Pokémon disponible.
     * 
     * @return índice del Pokémon disponible 
     */

    public int npcElige(){
        int cerrarElegir = 0;
        int seleccionNPC = 0;
        for (int i = 0 ; i < equipo.length && cerrarElegir < 1 ; i++){
            if (equipo[i].getEstado()){
                seleccionNPC = i;
                cerrarElegir++;
            }
        }
        return seleccionNPC;
    }
    
    
    /**
     * Ataque aleatorio del NPC
     * 
     * @param pokemon 
     * @return índice del ataque seleccionado 
     */
    public int ataqueNPC(Pokemon pokemon){
        int seleccion = 0; 
        Random rand = new Random();
        int posicion = 0;
        int tamaño = 0;
        for (Ataque a : pokemon.getHabilidades()) {
            if (a.getPp()>0){
                tamaño += 1;
            }
        }

        Ataque[] atqdis = new Ataque[tamaño];
        int aleatorio = rand.nextInt(tamaño);

        for (int i = 0; i < pokemon.getHabilidades().length ; i ++){
            if (pokemon.getHabilidades()[i].getPp() > 0){
                atqdis[posicion] = pokemon.getHabilidades()[i];
                posicion += 1;
            }
        }

        for (int j = 0; j < pokemon.getHabilidades().length;j++){
            if (atqdis[aleatorio] == pokemon.getHabilidades()[j]){
                seleccion = j;
            }
        }
        if (tamaño > 0){
            return seleccion;
        } else {
            return -1;
        }  
    }
    /**
     * Cambia el estado general del entrenador.
     * 
     * @param estado, si el pokemon esta derrotado o no 
     */ 

    public void setEstado(boolean estado){
        this.estado = estado;
    }
}
