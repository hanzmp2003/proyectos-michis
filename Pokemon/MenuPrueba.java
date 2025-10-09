import java.util.InputMismatchException;
import java.util.Scanner;


/*
 * Clase principal que maneja el menú y la lógica del juego.
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Emanuel Sancho Sánchez, C07332
 * @author Chun Ping Liu Li, C5G492
 * @author Jefferson Miranda Sabala, C24874
 * @version 1.0
 */
public class MenuPrueba{ //Al final termino siendo el Menu principal xd
    Entrenador entrenador1; // Creo variables para no escribir tantos entrenadores y arpovechar las funciones
    Entrenador entrenador2;
    private int numBatalla;
    Lideres lider;
    private int retirarse;
    private int intentar;
    private int salir;

    /*
     * Este es el constructor de la clase MenuPrueba, que inicializa los componentes necesarios para el juego y gestiona el flujo principal del mismo.
     */
    public MenuPrueba(){
        numBatalla = 0;
        Historial historial = new Historial();
        Scanner sc = new Scanner(System.in);
        Cronometro cronometroGimnasio = new Cronometro(); // Cronometro para el tiempo estando en x gimnasio

        // Inicializar todos los pokemones, entrenadores y el catálogo de elección para el jugador
        AgregarPokemon catalogoCompleto = new AgregarPokemon();
        AgregarGimnasio ag = new AgregarGimnasio();
        Pokemon[] catalogoPokemones = catalogoCompleto.catalogoEleccion();
        AgregarEntrenadores ae = new AgregarEntrenadores();
        AgregarLideres al = new AgregarLideres();
       
        // Empezar a registrar datos de jugador
        Jugador jugador = iniciarJugador(catalogoPokemones, sc);
    
        System.out.println("\nPresione enter para continuar:");
        sc.nextLine(); // Esto hace que salte un scanner que para el programa hasta que se introduzca enter

        //Gimnasio #1 : La Jungla
        System.out.println("Excelente, tu primera parada es:" );
        Entrenador entrenador1 = ae.brittany;
        Entrenador entrenador2 = ae.kimberly;
        Lideres lider = al.juankiloco;
        Gimnasio gimnasio1 = ag.laJungla;
        gimnasio1.setRivales(lider, entrenador1, entrenador2);
        ag.MostrarGimnasio(gimnasio1, entrenador1, entrenador2, lider);
        System.out.println("\nCuenta la leyenda que si logras derrotar a todos sus entrenadores y líderes,");
        System.out.println("te será revelado un poder tan antiguo que incluso los Pokémon susurran tu nombre en reverencia");
        //Inicia batalla gimnasio 1
        cronometroGimnasio.iniciar();
        numBatalla = peleaGimnasio(jugador, gimnasio1, catalogoPokemones, sc, historial, numBatalla);
        cronometroGimnasio.detener();
        historial.mostrarResumenGimnasio("La Jungla", new int[]{0, 1, 2});
        System.out.printf("Tiempo en Gimnasio 1: " + cronometroGimnasio.getTiempoFormateado());
        
        //Gimnasio #2 : El Bunker
        entrenador1 = ae.brayan;
        entrenador2 = ae.kevin;
        lider = al.porcionzon;
        Gimnasio gimnasio2 = ag.elBunker;
        gimnasio1.setRivales(lider, entrenador1, entrenador2);
        ag.MostrarGimnasio(gimnasio2, entrenador1, entrenador2, lider);
        //Inicia batalla gimnasio 2
        cronometroGimnasio.reiniciar();
        cronometroGimnasio.iniciar();
        numBatalla = peleaGimnasio(jugador, gimnasio2, catalogoPokemones, sc, historial, numBatalla);
        cronometroGimnasio.detener();
        historial.mostrarResumenGimnasio("El Bunker", new int[]{3, 4, 5});
        System.out.printf("Tiempo en Gimnasio 2: " + cronometroGimnasio.getTiempoFormateado());

        //Gimnasio #3 : Los Trigres
        entrenador1 = ae.byron;
        entrenador2 = ae.yandel;
        lider = al.chunche;
        Gimnasio gimnasio3 = ag.LosTigres;
        gimnasio1.setRivales(lider, entrenador1, entrenador2);
        ag.MostrarGimnasio(gimnasio3, entrenador1, entrenador2, lider);
        //Inicia batalla gimnasio 3
        cronometroGimnasio.reiniciar();
        cronometroGimnasio.iniciar();
        numBatalla = peleaGimnasio(jugador, gimnasio3, catalogoPokemones, sc, historial, numBatalla);
        cronometroGimnasio.detener();
        historial.mostrarResumenGimnasio("Los Tigres", new int[]{6, 7, 8});
        System.out.printf("Tiempo en Gimnasio 3: " + cronometroGimnasio.getTiempoFormateado());

    }

    /*
     * Este método permite al jugador elegir un Pokémon del catálogo disponible, manejando la entrada del usuario y validando la selección.
     * @param catalogoPokemones El catálogo de los pokemones disponibles para elegir.
     * @param sc El objeto Scanner para leer la entrada del usuario (para no crerar múltiples scanners).
     * @return El Pokémon seleccionado por el jugador.
     */
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

    /*
    * Este método muestra el catálogo de pokemones disponibles para que el jugador elija, filtrando aquellos que ya han sido seleccionados.
    * @param nuevoCatalogo El catálogo completo de pokemones.
    * @return Lista de pokemones que aún están disponibles para elegir.
    */
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

    /*
     * Este método inicializa un nuevo jugador, solicitando su nombre y permitiéndole seleccionar su equipo inicial de pokemones.
     * @param catalogoPokemones El catálogo de pokemones disponibles para elegir.
     * @param sc El objeto Scanner para leer la entrada del usuario.
     * @return Un objeto Jugador con el nombre y equipo seleccionado (el jugador).
     */
    private Jugador iniciarJugador(Pokemon[] catalogoPokemones, Scanner sc){
        String nombre;
        Pokemon[] equipo = new Pokemon[3];
        System.out.println("\nPOKEMON : AVENTURAS EN EL BARRIO");
        System.out.println("\nIntroduzca su nombre: ");
        nombre = sc.nextLine();
        System.out.println();
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

    /*
     * Este método gestiona el proceso de combate en un gimnasio, permitiendo al jugador enfrentarse a los entrenadores y al líder del gimnasio.
     * Además, retorna el número de batallas actualizado, sin importar si el jugador gana o pierde.
     * 
     * @param jugador El jugador que participará en el combate.
     * @param gimnasio El gimnasio donde se llevará a cabo el combate.
     * @param catalogoPokemones El catálogo de pokemones disponibles para elegir (en caso de ganar y poder elegir uno nuevo).
     * @param sc El objeto Scanner para leer la entrada del usuario.
     * @param historial El historial de combates para registrar los resultados.
     * @param numBatalla El número de batalla actual, utilizado para registrar en el historial.
     * @return El número de batalla actualizado después de completar los combates en el gimnasio.
     */
    public int peleaGimnasio(Jugador jugador, Gimnasio gimnasio, Pokemon[] catalogoPokemones, Scanner sc, Historial historial, int numBatalla){
        reiniciarOpciones();
        int ganados = 0;
        System.out.printf("\n¡Bievenido al gimnasio %s!\n",gimnasio.getNombre());
        int oponente = verificarEntrenadores(gimnasio);
        if (oponente >= 0){
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
                            intentar = 1;
                            reiniciarOpciones();
                            while (intentar == 1){
                                CombateEntrenador combate = new CombateEntrenador(jugador, gimnasio.entrenadores()[i]);
                                int resultado = combate.iniciarCombate();
                                //Creó historial del entrenador
                                Entrenador rival = gimnasio.entrenadores()[i];
                                boolean victoria = (resultado == 1);
                                historial.registrarBatalla(numBatalla, victoria, rival.getNombre(), rival.getEquipo(), jugador);
                                numBatalla++;

                                gimnasio.entrenadores()[i].reiniciarEstadisticas(); // Esto posee un problema
                                jugador.reiniciarEstadisticas();
                                if (resultado == 1) {
                                    System.out.println("¡Enhorabuena! Has ganado el combate");
                                    gimnasio.verOponentes();
                                    jugador.subirNiv();
                                    if (i < gimnasio.entrenadores().length - 1){
                                        System.out.printf("\nTu siguiente combate es contra %s",gimnasio.entrenadores()[i+1].getNombre());
                                    } else if (i == gimnasio.entrenadores().length) {
                                        System.out.printf("\nTu último combate es contra el lider del gimnasio %s.",gimnasio.getLider().getNombre());
                                    }
                                    int cerrar = 0;
                                    while (cerrar == 0){
                                        try {
                                            System.out.printf("\nIngresa:\n1) Ir al combate\n2) Retirarse\n",opcion);
                                            int opcion2 = sc.nextInt();
                                            if (opcion2 == 1) {
                                                cerrar = 1;
                                                intentar = 0;
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
                                    ganados++;
                                } else if (resultado == 0) { 
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
        
        if (gimnasio.getLider().getEstado() && retirarse == 0){ // Batalla con el Líder
            if (retirarse == 0) {
                intentar = 1;
                while (intentar == 1){
                    CombateLider combate = new CombateLider(jugador, gimnasio.getLider());
                    int resultado = combate.iniciarCombate();
                    //Historial del líder
                    Lideres lider = gimnasio.getLider();
                    boolean victoria = (resultado == 1);
                    historial.registrarBatalla(numBatalla, victoria, lider.getNombre(), lider.getEquipo(), jugador);
                    numBatalla++;

                    jugador.reiniciarEstadisticas();
                    gimnasio.getLider().reiniciarEstadisticas();
                    if (resultado == 1) {
                        System.out.printf("\n¡Felicidades! Has derrotado al lider del gimnasio, y con ello obtenido la insignia del gimnasio %s",gimnasio.getNombre());
                        gimnasio.getLider().setEstado(false);
                        jugador.subirNiv();
                        System.out.println("\nComo recompensa por tu victoria, puedes elegir uno pokemon adicional para que se una a tu equipo.\n");
                        Pokemon nuevoPoke = elegirPoke(catalogoPokemones, sc);
                        jugador.agregarPok(new Pokemon(nuevoPoke));
                        System.out.println("Excelente. Tu equipo ahora es: ");
                        for(int i = 0; i < jugador.getEquipo().length; i++){
                            System.out.printf("\n%d) %s", i+1, jugador.getEquipo()[i].getNombre());
                        }
                        System.out.println();
                        ganados++;
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

      return numBatalla;
    }

    /*
     * Este método verifica si hay entrenadores vivos en el gimnasio, y si hay, devuelve el índice del primer entrenador vivo encontrado.
     * @param gimnasio El gimnasio que contiene los entrenadores a verificar.
     * @return El índice del primer entrenador vivo encontrado, o -1 si no hay entrenadores vivos.
     */
    private int verificarEntrenadores(Gimnasio gimnasio){
        int entrenadorVivo = -1;
        int salir = 0;
        for (int i = 0 ; i < gimnasio.entrenadores().length && salir < 1 ; i++){
            if (gimnasio.entrenadores()[i].getEstado()) {
                entrenadorVivo = i;
            }
        }
        return entrenadorVivo;
    }

    /*
     * Este método pregunta al jugador si desea continuar con una acción específica (como intentar un combate nuevamente) o retirarse.
     * Este método modifica las variables de la clase para entrar o salir de los bucles correspondientes. Esto, para evitar repeticiones
     * de bloques de código en el método peleaGimnasio.
     * 
     * @param sc El objeto Scanner para leer la entrada del usuario.
     * @param opcion el nombre de la primera acción específica que el jugador puede elegir (por ejemplo, 1) "Volver a intentarlo" (opcion)).
     */
    public void preguntarContinuar(Scanner sc, String opcion){
        int cerrar = 0;
        while (cerrar == 0){
            try {
                System.out.printf("\nIngresa:\n1) %s\n2) Retirarse\n",opcion);
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

    /*
     * Este método reinicia las variables para la gestión de la salida y entradad de los bucles de peleaGimnasio().
     * Controla las opciones de retirarse, intentar y salir, para controlar, además, lo que hace el método de preguntaContinuar().
     * Esto es útil para preparar el estado del menú antes de iniciar un nuevo combate.
     */
    public void reiniciarOpciones(){
        retirarse = 0;
        intentar = 1;
        salir = 0;
    }

}
