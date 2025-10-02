import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {
    public menu(){
        Scanner sc = new Scanner(System.in);
        // Inicializar todos los pokemones, entrenadores y el catálogo de elección para el jugador
        AgregarPokemon catalogoCompleto = new AgregarPokemon();
        AgregarEntrenadores entrenadores = new AgregarEntrenadores();
        Pokemon[] catalogoPokemones = catalogoCompleto.catalogoEleccion();
        String nombre;
        Pokemon[] equipo = new Pokemon[3];

        // Empezar a registrar datos de jugador
        System.out.println("POKEMON : AVENTURAS EN EL BARRIO");
        System.out.println("Introduzca su nombre: ");
        nombre = sc.nextLine();
        System.out.printf("Un gusto conocerte %s, estás a punto de partir hacia una nueva aventura por las zonas rojas de Costa Rica :D\n", nombre);
        System.out.println("Ten en cuenta que este viaje es muy peligroso, por lo que tendrás que escoger a tus compañeros de confianza para poder luchar.\n");

        System.out.printf("\nPuedes elegir uno por uno entre los valientes pokemones de todos los siguientes hasta tres.\n",nombre);
        Pokemon pokemon1 = elegirPoke(catalogoPokemones,sc);
        Pokemon pokemon2 = elegirPoke(catalogoPokemones,sc);
        Pokemon pokemon3 = elegirPoke(catalogoPokemones,sc);
        equipo[0] = new Pokemon(pokemon1);
        equipo[1] = new Pokemon(pokemon2);
        equipo[2] = new Pokemon(pokemon3);
        Jugador jugador = new Jugador(nombre,equipo);
        

        // Idea para el combate

        int ganador = 0;
        for (int i = 0 ; i < entrenadores.getEntrenadores().length ; i++) {
            Combate pelea = new Combate(jugador, entrenadores.getEntrenadores()[i]);
            ganador = pelea.iniciarCombate(); // Con ganador se pueden realizar luego casos; si es 1 jugador gana y avanza, si es 2 jugador pierde y puede volver a intentarlo o terminar partida
        }

    }

    public Pokemon elegirPoke(Pokemon[] catalogoPokemones, Scanner sc){
        Pokemon[] nuevoCatalogo;
        int opcion = 0;
        int cerrar = 0;
        while (cerrar == 0){
            try { 
                System.out.println("Digite el numero asociado al pokemon para seleccionar un pokemon: ");
                nuevoCatalogo = mostrarCatalogo(catalogoPokemones); // Pokemones a mostrar
                System.out.println();
                opcion = sc.nextInt();
                if (opcion>0 && opcion <= nuevoCatalogo.length) {
                    System.out.printf("\n¡Excelente! Has elegido a %s\n",nuevoCatalogo[opcion - 1].getNombre());
                    nuevoCatalogo[opcion - 1].setMostrar(false); // Aquí se modifica también el respectivo en catalogoPokemones.
                    cerrar = 1;
                } else {
                    System.out.println("Por favor, introduzca un número de los que acompaña a los pokemones.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor introduzca un número asociado a un pokemon.");
                sc.nextLine();
            }
        }
    return catalogoPokemones[opcion - 1];
    }

    public Pokemon[] mostrarCatalogo(Pokemon[] nuevoCatalogo){
        int pokemonesMostrar = 0;
        int posicion = 0;
        for (Pokemon i : nuevoCatalogo) {
            if (i.mostrar()) {
                pokemonesMostrar += 1;
            }
        }
        Pokemon[] nuevoCatalogoEleccion = new Pokemon[pokemonesMostrar];
        for (int i = 0 ; i < nuevoCatalogo.length ; i++) {
            if (nuevoCatalogo[i].mostrar()){
                nuevoCatalogoEleccion[posicion] = nuevoCatalogo[i];
                posicion += 1;
            }
        }
        for (int i = 0 ; i < nuevoCatalogoEleccion.length ; i++) {
            System.out.printf("\n%d) %s (Tipo: %s, Nivel: %d, Vida: %d, Ataque: %d, Defensa: %d, Velocidad: %d)", 
                i+1, nuevoCatalogoEleccion[i].getNombre(), nuevoCatalogoEleccion[i].getTipo(), nuevoCatalogoEleccion[i].getNivel(),
                nuevoCatalogoEleccion[i].getHp(), nuevoCatalogoEleccion[i].getAtaque(), nuevoCatalogoEleccion[i].getDef(),
                nuevoCatalogoEleccion[i].getVelocidad());
        }
        System.out.println();
        return nuevoCatalogoEleccion;
    }

}
