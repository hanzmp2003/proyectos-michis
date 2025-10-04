import java.util.InputMismatchException;
import java.util.Scanner;

// Clase Jugador que representa a un jugador con su nombre, equipo de Pokémon y estado (actualmente en combate o no)
public class Jugador {
    String nombre;
    Pokemon[] equipo = new Pokemon[3];
    boolean estado;
    Scanner scanner = new Scanner(System.in);

    public Jugador(String nombre, Pokemon[] equipo){
        this.nombre = nombre;
        this.equipo = equipo;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Pokemon[] getEquipo() {
        return equipo;
    }
    public void setEquipo(Pokemon[] equipo) {
        this.equipo = equipo;
    }

    // Método para escoger entrenador
    public String escogerEntrenador() {
        System.out.println("Digite el nombre del entrenador:");
        String entrenador = scanner.nextLine();
        return entrenador;
    }

    // Método para elegir nombre del jugador
    public String elegirNombre() {
        System.out.println("Digite el nombre del jugador:");
        String nombre = scanner.nextLine();
        return nombre;
    }

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
    for (Pokemon i : equipo){
        pokesvivos[posicion] = i;
        posicion += 1;
    }
    int cerrar = 0;
    int opcion = 0;
    Scanner sc = new Scanner(System.in);
    while (cerrar == 0){
        try {
            System.out.println("Selecciona el número asociado para escoger un pokemon:\n");
            for (int i = 0; i < pokesvivos.length ; i++) {
                System.out.printf("\n%d) %s",i+1,pokesvivos[i]);
            }
            if (cambiar == 1) {
                System.out.printf("\n%d) Atrás\n", pokesvivos.length + 1);
            }
            opcion = sc.nextInt();
            if (opcion <= pokesvivos.length && opcion > 0){
                for (int i = 0 ; i < equipo.length ; i++) {
                    if (pokesvivos[opcion - 1] == equipo[i]) {
                        seleccion = i;
                    }
                }
            } else if (opcion == pokesvivos.length + 1 && cambiar == 1) {
                seleccion = -1;
            } else {
                System.out.println("Por favor, ingrese una de las opciones.\n");
            }
            sc.close();
        } catch (InputMismatchException e) {
            System.err.println("Error: " + e);
            System.out.println("Por favor ingrese una opción válida, tus pokemones esperan.\n");
        }
    }
    return seleccion;
    }

}
