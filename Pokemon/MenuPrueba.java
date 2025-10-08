import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrueba{
    Entrenador entrenador1; // Creo variables para no escribir tantos entrenadores y arpovechar las funciones
    Entrenador entrenador2;
    Lideres lider;
    private int retirarse;
    private int intentar;
    private int salir;

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

        //Gimnasio #1
        System.out.println("\nExcelente, tu primera parada es:" );
        Entrenador entrenador1 = ae.brittany;
        Entrenador entrenador2 = ae.kimberly;
        Lideres lider = al.juankiloco;
        Gimnasio gimnasio = ag.laJungla;
        ag.MostrarGimnasio(gimnasio, entrenador1, entrenador2, lider);

        System.out.println("Cuenta la leyenda que si logras derrotar a todos sus entrenadores y líderes,");
        System.out.println("te será revelado un poder tan antiguo que incluso los Pokémon susurran tu nombre en reverencia");


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

   public int peleaGimnasio(Jugador jugador, Gimnasio gimnasio, Scanner sc){
        reiniciarOpciones();
        int ganados = 0;
        System.out.printf("\n¡Bievenido al gimnasio %s!\n",gimnasio.getNombre());
        System.out.println("Sus entrenadores y líderes son los siguientes:\n");
        gimnasio.verOponentes();
        int oponente = verificarEntrenadores(gimnasio);
        if (oponente >= 0){
            oponente = verificarEntrenadores(gimnasio);
            System.out.printf("\nTu siguiente combate es contra %s.\n",gimnasio.entrenadores()[oponente].getNombre());
        } else {
            ganados = 2;
            System.out.printf("\nTu último combate es contra el lider %s\n",gimnasio.getLider().getNombre());
        }
        System.out.println("¿Deseas empezar con el combate?\n1) Empezar combate\n2) Salir\n");
        while (ganados < 2 && retirarse == 0) { 
            try {
                int opcion = sc.nextInt();
                if (opcion == 1){
                    for (int i = 0 ; i < gimnasio.entrenadores().length && salir < 1 ; i++){
                        if (gimnasio.entrenadores()[i].getEstado()) {

                            while (intentar == 1){
                                
                                CombateEntrenador combate = new CombateEntrenador(jugador, gimnasio.entrenadores()[i]);
                                int resultado = combate.iniciarCombate();
                                jugador.reiniciarEstadisticas();
                                gimnasio.entrenadores()[i].reiniciarEstadisticas(); // Se reinician stats, más no estado

                                if (resultado == 1) {
                                    System.out.println("¡Enhorabuena! Has ganado el combate");
                                    gimnasio.verOponentes();
                                    if (i < gimnasio.entrenadores().length - 1){
                                        System.out.printf("\nTu siguiente combate es contra %s",gimnasio.entrenadores()[i+1].getNombre());
                                    } else if (i == gimnasio.entrenadores().length) {
                                        System.out.printf("\nTu último combate es contra el lider del gimnasio %s.",gimnasio.getLider().getNombre());
                                    }
                                    preguntarContinuar(sc, "Ir al combate");
                                    ganados++;
                                } else if (resultado == 0) { // System.out.println("\n¡Excelente! Tu rival te reconoce por no rendirte.\n");
                                    System.out.println("Has sido derrotado. ¿Deseas volver a intentarlo?");
                                    preguntarContinuar(sc, "Volver a intentarlo");
                                } else {
                                    System.out.println("\nTe has retirado del combate.");
                                    preguntarContinuar(sc, "Volver a intentalo");
                                }

                            }
                        }
                    }
                    if (salir == 0) {
                        ganados = 2;
                    }

                } else if (opcion == 2) {
                    retirarse = 1;
                } else {
                    System.out.println("Opción inválida. Ingrese:\n1) Empezar el combate\n2) Salir\n");
                }
            } catch (InputMismatchException e){
                System.out.println("Error. Ingrese:\n1) Empezar el combate\n2) Salir\n");
                sc.nextLine();
            }
        }
        
        if (gimnasio.getLider().getEstado()){
            if (retirarse == 0) {
                while (intentar == 1){
                    CombateLider combate = new CombateLider(jugador, gimnasio.getLider());
                    int resultado = combate.iniciarCombate();
                    jugador.reiniciarEstadisticas();
                    gimnasio.getLider().reiniciarEstadisticas();
                    if (resultado == 1) {
                        System.out.printf("\n¡Felicidades! Has derrotado al lider del gimnasio, y con ello obtenido la insignia del gimnasio %s",gimnasio.getNombre());
                        ganados = 3;
                        intentar = 0;
                    } else if (resultado == 0) {
                        System.out.println("Has sido derrotado.¿Deseas volver a intentarlo?\n");
                        preguntarContinuar(sc, "Intentar de nuevo el combate");
                    } else {
                        System.out.println("\nTe has retirado del combate.");
                        preguntarContinuar(sc, "Volver a intentarlo");
                    }
                }
            }
        }

        if (retirarse == 0 && ganados == 3) {
            return ganados;
        } else if (retirarse == 1 && ganados > 0){
            return ganados;
        } else {
            return -1;
        }

    }

    private int verificarEntrenadores(Gimnasio gimnasio){
    for (int i = 0 ; i < gimnasio.entrenadores().length ; i++){
        if (gimnasio.entrenadores()[i].getEstado()) {
            return i; // Devuelve el primero que esté vivo
            }
        }
        return -1; // Si ninguno está vivo
    }


    public void preguntarContinuar(Scanner sc, String opcion){
        int cerrar = 0;
        while (cerrar == 0){
            try {
                System.out.printf("\nIngresa:\n1) %s\n2) Retirarse",opcion);
                int opcion2 = sc.nextInt();
                if (opcion2 == 1) {
                    cerrar = 1;
                } else if (opcion2 == 2) {
                    cerrar = 1;
                    retirarse = 1;
                    intentar = 0;
                    salir = 1;
                } else {
                    System.out.println("Valor ingresado inválido.");
                }
            } catch (InputMismatchException e){
                System.out.println("Error: Entrada inválida.");
                sc.nextLine();
            }
        }                                                                      
    }

    public void reiniciarOpciones(){
        retirarse = 0;
        intentar = 1;
        salir = 0;
    }

}
