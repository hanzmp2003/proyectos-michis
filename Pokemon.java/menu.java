import java.util.Scanner;
public class menu {
    public menu(){
        String nombre;
        Scanner sc = new Scanner(System.in);
        AgregarPokemon agregarpokemones = new AgregarPokemon();
        AgregarEntrenadores agregarentrenadores = new AgregarEntrenadores();
        System.out.println("Bienvenido al Gimnasio ___\n\nIntroduzca su nombre: ");
        nombre = sc.nextLine();
    }
}
