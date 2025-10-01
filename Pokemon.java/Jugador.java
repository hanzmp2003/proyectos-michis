import java.util.Scanner;

public class Jugador {
    String nombre;
    Pokemon[] equipo = new Pokemon[6];
    boolean estado;
    Scanner scanner = new Scanner(System.in);

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
}
