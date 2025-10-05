import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrueba{
    Entrenador entrenador1; // Creo variables para no escribir tantos entrenadores y arpovechar las funciones
    Entrenador entrenador2;
    Lideres lider;

    public MenuPrueba(){
        Scanner sc = new Scanner(System.in);

        // Inicializar todos los pokemones, entrenadores y el catálogo de elección para el jugador
        AgregarPokemon catalogoCompleto = new AgregarPokemon();
        AgregarGimnasio ag = new AgregarGimnasio();
        Pokemon[] catalogoPokemones = catalogoCompleto.catalogoEleccion();
        AgregarEntrenadores ae = new AgregarEntrenadores();
        AgregarLideres al = new AgregarLideres();
       

        
        
        // Empezar a registrar datos de jugador
        Jugador jugador = iniciarJugador(catalogoPokemones, sc);
    
        System.out.println("Presione enter para continuar:\n");
        sc.nextLine(); // Esto hace que salte un scanner que para el programa hasta que se introduzca enter

        System.out.println("\nExcelente, tu primera parada es:" );
        Entrenador entrenador1 = ae.brittany;
        Entrenador entrenador2 = ae.kimberly;
        Lideres lider = al.juankiloco;
        Gimnasio gimnasio = ag.laJungla;
        ag.MostrarGimnasio(gimnasio, entrenador1, entrenador2, lider);
        

        System.out.println("Cuenta la leyenda que si logras derrotar a todos sus entrenadores y líderes, te será revelado un poder tan antiguo que incluso los Pokémon susurran tu nombre en reverencia");


        // Idea para el combate 
        peleaGimnasio(jugador, gimnasio, sc);
        
    }

    private Pokemon elegirPoke(Pokemon[] catalogoPokemones, Scanner sc){
        Pokemon[] nuevoCatalogo = new Pokemon[0]; //Inicializa nuevoCatalogo
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
        return nuevoCatalogo[opcion - 1];
    }

    public Pokemon[] mostrarCatalogo(Pokemon[] nuevoCatalogo){  //Mostrar Catalogo de Pokemones a lo random
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
        System.out.printf("\n%d) %s", i+1, nuevoCatalogoEleccion[i]);
        
        }
        System.out.println();
        return nuevoCatalogoEleccion; 
    }

    private Jugador iniciarJugador(Pokemon[] catalogoPokemones, Scanner sc){
        String nombre;
        Pokemon[] equipo = new Pokemon[3];
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
        System.out.println("Tu equipo inicial es: ");
        for(int i = 0; i < equipo.length; i++){
            System.out.printf("\n%d) %s", i+1, equipo[i].getNombre());
        }
        System.out.println();

        return new Jugador(nombre,equipo);
    }

    public void peleaGimnasio(Jugador jugador, Gimnasio gimnasio, Scanner sc){
        int peleaEntrenador;
        int peleaLider;
        int salir = 0;
        int opcion = 0;
        System.out.printf("\n¡Bievenido al gimnasio %s!\n",gimnasio.getNombre());
        System.out.println("Sus entrenadores y líderes son los siguientes:\n");
        gimnasio.verOponentes();
        System.out.printf("\nTu primer combate es contra %s, quien parece haber estado esperándote.\n",gimnasio.entrenadores()[0].getNombre());
        System.out.println("¿Deseas empezar con el combate?\\n" + // Esto es una prueba, no sé si funciona
                            "1) Empezar combate\\n" + 
                            "2) Salir\\n");
        while (opcion != -1) { 
            try {
                opcion = sc.nextInt();
                if (opcion == 1){
                    for (int i = 0 ; i < gimnasio.entrenadores().length && salir < 1 ; i++){

                        // Falta agregar lógica de entrenador con lider cada dos entrenadores
                        if (true){
                            
                        }
                    }
                } else if (opcion == 2) {
                    opcion = -1;
                } else {
                    System.out.println("Opción inválida. Ingrese:\n1) para empezar primer combate\n2) Salir\n");
                }
            } catch (InputMismatchException e){
                System.out.println("Error. Ingrese:\n1) para empezar primer combate\n2) Salir\n");
                sc.nextLine();
            }
        }
        


    }


}

