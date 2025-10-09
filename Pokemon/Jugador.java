import java.util.InputMismatchException;
import java.util.Scanner;
/**  
 *Clase que representa al jugador (y usuario) con sus atributos y métodos. 
 * @author Hanz Madrigal Porras, C4G754
 * @author Chun Ping Liu Li, C5G492
 * @author Emanuel Sancho Sánchez, C07332
 * @author Jefferson Emanuel Miranda Sabala, C24874
 *
 * @version 1.0
 */

public class Jugador {
    String nombre;
    Pokemon[] equipo = new Pokemon[3];
    boolean estado;
    Scanner scanner = new Scanner(System.in);

    /*
     * Constructor para el jugador con su nombre y equipo de Pokémon.
     * @param nombre El nombre del jugador.
     * @param equipo lista de Pokemones a modo de equipo del jugador.
     */
    public Jugador(String nombre, Pokemon[] equipo){
        this.nombre = nombre;
        this.equipo = equipo;
    }

    /*
     * Getter para el nombre del jugador.
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /*
     * Setter para el nombre del jugador.
     * @param nombre El nuevo nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
     * Getter para el estado del jugador (si está vivo o no). Esta variable es útil, pero terminó siendo tan útil como el estado de los pokemones.
     * @return estado del jugador (boolean).
     */
    public boolean isEstado() {
        return estado;
    }

    /*
     * Setter para el estado del jugador (si está vivo o no).
     * @param estado El nuevo estado del jugador.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /*
     * Getter para el equipo de Pokémon del jugador.
     * @return Una lista de Pokemones y equipo del jugador.
     */
    public Pokemon[] getEquipo() {
        return equipo;
    }

    /*
     * Setter para el equipo de Pokémon del jugador.
     * @param equipo La nueva lista de Pokemones y equipo del jugador.
     */
    public void setEquipo(Pokemon[] equipo) {
        this.equipo = equipo;
    }

    /*
     * Método para que el jugador elija su entrenador (el nombre).
     * No fue de mucha utilidad, pero se implementó con la idea de que el jugador pudiera elegir entre varios entrenadores,
     * aunque al final no se implementó esa funcionalidad.
     * 
     * @return El nombre del entrenador elegido por el jugador.
     */
    public String escogerEntrenador() {
        System.out.println("Digite el nombre del entrenador:");
        String entrenador = scanner.nextLine();
        return entrenador;
    }

    /*
     * Método para que el jugador elija su nombre.
     * 
     * @return El nombre del jugador.
     */
    public String elegirNombre() {
        System.out.println("Digite el nombre del jugador:");
        String nombre = scanner.nextLine();
        return nombre;
    }

    /*
     * Este método reinicia las estadísticas de todos los pokemones del equipo del jugador.
     * Restaura los puntos de vida al valor inicial, establece el estado a vivo (true) y
     * resetea los PP de todos los ataques de cada Pokémon (ésta última parte está en Ataque.java).
     * Esto es útil luego de una batalla, en caso de que el jugador quiera intentar nuevamente.
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
     * Este método permite al jugador elegir uno de sus pokemones que esté vivo (estado true).
     * Muestra sólo los pokemones que están vivos y permite al jugador seleccionar uno.
     * Si el parámetro cambiar es 1, se añade una opción para regresar (útil en combate).
     * Es decir, si el jugador está en combate y quiere cambiar de Pokémon, puede elegir uno o
     * regresar sin hacer ningún cambio.
     * 
     * @param cambiar Indica si se debe añadir la opción de regresar (1 para sí, 0 para no).
     * @return El índice del Pokémon elegido en el equipo del jugador, o -1 si el jugador decide regresar.
     */
    public int elegirPokeJugador(int cambiar){
        int vivos = 0;
        int posicion = 0;
        int seleccion = 0;
        for (Pokemon i : equipo) {
            if (i.getEstado()) {
                vivos += 1;
            }
        }
        
        Pokemon[] pokesvivos = new Pokemon[vivos];
        int idx = 0;
        for (Pokemon p : equipo) {
            if (p.getEstado()) {
                pokesvivos[idx] = p;
                idx++;
            }
        }

        int cerrar = 0;
        int opcion = 0;

        while (cerrar == 0){
            try {
                System.out.println("Selecciona el número asociado para escoger un pokemon:");
                for (int i = 0; i < pokesvivos.length ; i++) {
                    System.out.printf("\n%d) %s", i+1, pokesvivos[i]);
                }
                if (cambiar == 1) {
                    System.out.printf("\n%d) Atrás\n", pokesvivos.length + 1);
                }
                System.out.println();
                opcion = scanner.nextInt();  

                if (opcion <= pokesvivos.length && opcion > 0){
                    for (int i = 0 ; i < equipo.length ; i++) {
                        if (pokesvivos[opcion - 1] == equipo[i]) {
                            seleccion = i;
                        }
                    }
                    cerrar = 1; 
                } else if (opcion == pokesvivos.length + 1 && cambiar == 1) {
                    seleccion = -1;
                    cerrar = 1; 
                } else {
                    System.out.println("Por favor, ingrese una de las opciones.\n");
                }

            } catch (InputMismatchException e) {
                System.err.println("Error: " + e);
                System.out.println("Por favor ingrese una opción válida, tus pokemones esperan.\n");
                scanner.next(); // limpiar el input inválido
            }
        }

        return seleccion;
    }

    /*
     * Este método devuelve un Pokémon específico del equipo del jugador basado en el índice proporcionado.
     * 
     * @param index El índice del Pokémon en el equipo del jugador.
     * @return El Pokémon en la posición especificada del equipo.
     */
    public Pokemon getPokemon(int index) {
        return equipo[index];
    }

    /*
     * Este método sube de nivel a todos los pokemones del equipo del jugador.
     * Llama al método subirNivel() de cada Pokémon en el equipo.
     */
    public void subirNiv(){
        for (Pokemon i : equipo){
            i.subirNivel();
        }
    }

    /*
     * Este método sirve como lista dinámica que agrega un nuevo Pokémon al equipo del jugador.
     * Crea una nueva lista con espacio adicional, copia los pokemones existentes y añade el nuevo al final.
     * Este método es útil cuando el jugador derrota a un líder de gimnasio y gana un nuevo Pokémon. Esto,
     * para darle más posibilidad al jugador de enfrentarse a los siguientes gimnasios y líderes.
     * 
     * @param nuevoPok El nuevo Pokémon a agregar al equipo. Normalmente, el Pokémon ganado tras vencer a un líder de gimnasio.
     */
    public void agregarPok(Pokemon nuevoPok){
        Pokemon [] nuevoEquipo = new Pokemon[equipo.length + 1];
        for (int i = 0 ; i < equipo.length ; i++){
            nuevoEquipo[i] = equipo[i];
        }
        nuevoEquipo[equipo.length] = nuevoPok;
        this.equipo = nuevoEquipo;
    }
}
