// Clase Lideres que representa un líder de gimnasio con su nombre, nivel, elemento y lista de Pokémon

import java.util.Random;

/**
 * Clase que representa a los líderes de gimnasio con sus atributos y métodos.
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Emanuel Sancho Sánchez, C07332
 * @author Chun Ping Liu Li, C5G492
 * @author Jefferson Miranda Sabala, C24874
 * 
 * @version 1.0
 */
public class Lideres{
    public String nombre;
    public int nivel;
    public String elemento;
    private Pokemon[] equipo;
    public boolean estado;

    /*
     * Constructor para los líderes de gimnasio con su nombre, nivel, elemento y equipo de Pokémon.
     * @param nombre El nombre del líder de gimnasio.
     * @param nivel El nivel del líder de gimnasio.
     * @param elemento El tipo de elemento del líder de gimnasio.
     * @param equipo lista de pokemones que sirve como equipo del líder de gimnasio.
     */
    public Lideres(String nombre, int nivel, String elemento, Pokemon[] equipo){
        this.nombre = nombre;
        this.nivel = nivel;
        this.elemento = elemento;
        this.equipo = equipo;
        this.estado = true;
    }
    
    /*
     * Setter para el nombre del líder de gimnasio.
     * @param nombre El nuevo nombre del líder de gimnasio.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /*
     * Getter para el nombre del líder de gimnasio.
     * @return El nombre del líder de gimnasio.
     */
    public String getNombre(){
        return nombre;
    }

    /*
     * Setter para el nivel del líder de gimnasio.
     * @param nivel El nuevo nivel del líder de gimnasio.
     */
    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    /*
     * Getter para el nivel del líder de gimnasio.
     * @return El nivel del líder de gimnasio.
     */
    public int getNivel(){
        return nivel;
    }

    /*
     * Setter para el estado del líder de gimnasio (si está activo o no, es decir, vivo o no).
     * @param estado El nuevo estado del líder de gimnasio.
     */
    public void setEstado(boolean estado){
        this.estado = estado;
    }

    /*
     * Getter para el estado del líder de gimnasio.
     * @return El estado del líder de gimnasio.
     */
    public boolean getEstado(){
        return estado;
    }

    /*
     * Setter para el tipo de elemento del líder de gimnasio.
     * @param elemento El nuevo tipo de elemento del líder de gimnasio.
     */
    public void setElemento(String elemento){
        this.elemento = elemento;
    }

    /*
     * Getter para el tipo de elemento del líder de gimnasio.
     * @return El tipo de elemento del líder de gimnasio.
     */
    public String getElemento(){
        return elemento;
    }


    /*
     * Método para reiniciar las estadísticas de los pokemones del líder de gimnasio.
     * Restaura los puntos de vida y PP de los pokemones a sus valores iniciales y establece su
     * estado a vivo, luego de una batalla. Esto en caso de que el jugador quiera intentar nuevamente.
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

    /*
     * Este getter devuelve el índice del primer Pokémon en el equipo del líder de gimnasio que aún está vivo (estado true).
     * Sirve para que el líder de gimnasio elija su próximo Pokémon en combate. Para el caso en el que no hay pokemones vivos,
     * devuelve 0, pero esto no debería ocurrir en la lógica del combate, pues el método que llama a este se detiene si no hay
     * pokemones vivos, antes de llamar a este método.
     * 
     * @return El índice del primer Pokémon vivo en el equipo del líder de gimnasio.
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

    /*
     * Este método permite al líder de gimnasio seleccionar un ataque aleatorio de su Pokémon actual que tenga PP disponible.
     * Si no hay ataques con PP disponible, devuelve -1.
     * Este método define un poco de la IA que se espera del "NPC".
     * Este método es igual al método situado en la clase Entrenador.java, pero se repite aquí para evitar complicaciones.
     * 
     * @param pokemon El Pokémon del líder de gimnasio que va a atacar.
     * @return El índice del ataque seleccionado aleatoriamente, o -1 si no hay ataques disponibles.
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

    /*
     * Getter para el equipo de Pokémon del líder de gimnasio.
     * @return El equipo de Pokémon del líder de gimnasio.
     */
     public Pokemon[] getEquipo() { 
        return equipo; 
        }

    /*
     * Setter para el equipo de Pokémon del líder de gimnasio.
     * @param equipo El nuevo equipo de Pokémon del líder de gimnasio.
     */
    public void setEquipo(Pokemon[] equipo) { 
        this.equipo = equipo; 
        }
}

