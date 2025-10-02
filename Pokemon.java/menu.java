import java.util.Scanner;

public class menu {
    public menu() {
        Scanner sc = new Scanner(System.in);
        String nombre;
        Jugador jugador = new Jugador();
        AgregarGimnasio agregarGimnasio = new AgregarGimnasio();
        AgregarPokemon agregarpokemones = new AgregarPokemon();
        AgregarEntrenadores agregarentrenadores = new AgregarEntrenadores();

        // Presentación
        System.out.println("POKEMON : AVENTURAS EN EL BARRIO");
        System.out.println("Introduzca su nombre: ");
        nombre = sc.nextLine();
        System.out.printf("Un gusto conocerte %s, estás a punto de partir hacia una nueva aventura por las zonas rojas de Costa Rica :D\n", nombre);
        System.out.println("Ten en cuenta que este viaje es muy peligroso, por lo que tendrás que escoger a tus compañeros de confianza para poder luchar.");
        jugador.elegirPokeJugador();
       
    }
}
