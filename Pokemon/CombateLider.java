import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Clase para manejar el combate entre un jugador y un entrenador
public class CombateLider {
    private Jugador jugador;
    private Lideres lider;
    private Scanner scanner = new Scanner(System.in);
    private int vidasJugador; 
    private int vidasRival;

    public CombateLider(Jugador jugador, Lideres entrenador) {
        this.jugador = jugador;
        this.lider = entrenador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Lideres getLider() {
        return lider;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setLider(Lideres entrenador) {
        this.lider = entrenador;
    }

    // Método para calcular la efectividad del ataque basado en tipos
    // Incluye STAB (Same Type Attack Bonus), tal como en los juegos oficiales de Pokémon
    // Tabla de tipos basada en los juegos oficiales de Pokémon
    public double calcularEfectividad(Pokemon atacante, Pokemon defensor, Ataque ataque) {
        String tipoAtacante = atacante.getTipo().toLowerCase();
        String tipoAtaque = ataque.getTipo().toLowerCase();
        String tipoDefensor = defensor.getTipo().toLowerCase();

        double efectividad = 1.0;

        // STAB: Si el ataque coincide con el tipo del Pokémon atacante (eso lo tienen los juegos originales)
        if (tipoAtacante.equals(tipoAtaque)) {
            efectividad *= 1.5;
        }

        // Tabla de tipos completa basada en el tipo del ataque
        switch (tipoAtaque) {
            case "normal":
                if (tipoDefensor.equals("roca") || tipoDefensor.equals("acero")) efectividad *= 0.5;
                else if (tipoDefensor.equals("fantasma")) efectividad *= 0;
                break;
            case "fuego":
                if (tipoDefensor.equals("planta") || tipoDefensor.equals("hielo") || tipoDefensor.equals("bicho") || tipoDefensor.equals("acero"))
                    efectividad *= 2.0;
                else if (tipoDefensor.equals("fuego") || tipoDefensor.equals("agua") || tipoDefensor.equals("roca") || tipoDefensor.equals("dragón"))
                    efectividad *= 0.5;
                break;
            case "agua":
                if (tipoDefensor.equals("fuego") || tipoDefensor.equals("tierra") || tipoDefensor.equals("roca"))
                    efectividad *= 2.0;
                else if (tipoDefensor.equals("agua") || tipoDefensor.equals("planta") || tipoDefensor.equals("dragón"))
                    efectividad *= 0.5;
                break;
            case "eléctrico":
                if (tipoDefensor.equals("agua") || tipoDefensor.equals("volador")) efectividad *= 2.0;
                else if (tipoDefensor.equals("eléctrico") || tipoDefensor.equals("planta") || tipoDefensor.equals("dragón")) efectividad *= 0.5;
                else if (tipoDefensor.equals("tierra")) efectividad *= 0;
                break;
            case "planta":
                if (tipoDefensor.equals("agua") || tipoDefensor.equals("tierra") || tipoDefensor.equals("roca")) efectividad *= 2.0;
                else if (tipoDefensor.equals("fuego") || tipoDefensor.equals("planta") || tipoDefensor.equals("veneno") || tipoDefensor.equals("volador") || tipoDefensor.equals("bicho") || tipoDefensor.equals("dragón") || tipoDefensor.equals("acero"))
                    efectividad *= 0.5;
                break;
            case "hielo":
                if (tipoDefensor.equals("planta") || tipoDefensor.equals("tierra") || tipoDefensor.equals("volador") || tipoDefensor.equals("dragón")) efectividad *= 2.0;
                else if (tipoDefensor.equals("fuego") || tipoDefensor.equals("agua") || tipoDefensor.equals("hielo") || tipoDefensor.equals("acero")) efectividad *= 0.5;
                break;
            case "lucha":
                if (tipoDefensor.equals("normal") || tipoDefensor.equals("hielo") || tipoDefensor.equals("roca") || tipoDefensor.equals("siniestro") || tipoDefensor.equals("acero"))
                    efectividad *= 2.0;
                else if (tipoDefensor.equals("veneno") || tipoDefensor.equals("volador") || tipoDefensor.equals("psíquico") || tipoDefensor.equals("hada")) efectividad *= 0.5;
                else if (tipoDefensor.equals("fantasma")) efectividad *= 0;
                break;
            case "veneno":
                if (tipoDefensor.equals("planta") || tipoDefensor.equals("hada")) efectividad *= 2.0;
                else if (tipoDefensor.equals("veneno") || tipoDefensor.equals("tierra") || tipoDefensor.equals("roca") || tipoDefensor.equals("fantasma")) efectividad *= 0.5;
                break;
            case "tierra":
                if (tipoDefensor.equals("fuego") || tipoDefensor.equals("eléctrico") || tipoDefensor.equals("veneno") || tipoDefensor.equals("roca") || tipoDefensor.equals("acero")) efectividad *= 2.0;
                else if (tipoDefensor.equals("planta") || tipoDefensor.equals("bicho")) efectividad *= 0.5;
                else if (tipoDefensor.equals("volador")) efectividad *= 0;
                break;
            case "volador":
                if (tipoDefensor.equals("planta") || tipoDefensor.equals("lucha") || tipoDefensor.equals("bicho")) efectividad *= 2.0;
                else if (tipoDefensor.equals("eléctrico") || tipoDefensor.equals("roca") || tipoDefensor.equals("acero")) efectividad *= 0.5;
                break;
            case "psíquico":
                if (tipoDefensor.equals("lucha") || tipoDefensor.equals("veneno")) efectividad *= 2.0;
                else if (tipoDefensor.equals("psíquico") || tipoDefensor.equals("acero")) efectividad *= 0.5;
                else if (tipoDefensor.equals("siniestro")) efectividad *= 0;
                break;
            case "fantasma":
                if (tipoDefensor.equals("fantasma") || tipoDefensor.equals("psíquico")) efectividad *= 2.0;
                else if (tipoDefensor.equals("normal")) efectividad *= 0;
                break;
            case "dragón":
                if (tipoDefensor.equals("dragón")) efectividad *= 2.0;
                else if (tipoDefensor.equals("acero")) efectividad *= 0.5;
                break;
            case "siniestro":
                if (tipoDefensor.equals("psíquico") || tipoDefensor.equals("fantasma")) efectividad *= 2.0;
                else if (tipoDefensor.equals("lucha") || tipoDefensor.equals("siniestro") || tipoDefensor.equals("hada")) efectividad *= 0.5;
                break;
            case "acero":
                if (tipoDefensor.equals("hielo") || tipoDefensor.equals("roca") || tipoDefensor.equals("hada")) efectividad *= 2.0;
                else if (tipoDefensor.equals("fuego") || tipoDefensor.equals("agua") || tipoDefensor.equals("acero")) efectividad *= 0.5;
                break;
            case "hada":
                if (tipoDefensor.equals("lucha") || tipoDefensor.equals("dragón") || tipoDefensor.equals("siniestro")) efectividad *= 2.0;
                else if (tipoDefensor.equals("fuego") || tipoDefensor.equals("veneno") || tipoDefensor.equals("acero")) efectividad *= 0.5;
                break;
        }

        return efectividad;
    }

    public void imprimirCategoriaDanio(double efectividad){
        if (efectividad >= 2) {
            System.out.println("¡Es súper efectivo!");
        } else if (efectividad >= 1 && efectividad < 2) {
            System.out.println("¡Es efectivo!");
        } else if (efectividad >= 0.5 && efectividad < 1) {
            System.out.println("Es poco efectivo");
        } else {
            System.out.println("Es no efectivo");
        }
    }

    public double calcularProbabilidadCritico() {
        Random random = new Random();
        int probabilidad = random.nextInt(100);
        if (probabilidad < 10) { // 10% de probabilidad de crítico
            return 2.0; // Daño crítico
        } else {
            return 1.0; // Daño normal
        }
    }

    public void imprimirProbabilidadCritico(double probabilidadCritico) {
        if (probabilidadCritico == 2.0) {
            System.out.println("¡Golpe crítico!");
        } 
    }
    
    // Cuando se termine de realizar toda la lógica del combate, se debe crear un método para determinar el daño final basado en una fórmula
    // Ya tenemos efectividad y probabilidad de crítico, falta la fórmula completa que incluya lo anterior, nivel, poder del ataque, etc.
    // Aún no se ha implementado la fórmula de daño completa porque no se ha definido cómo se seleccionarán los ataques ni cómo se manejarán los turnos en el combate.
    // Una vez que se defina esa lógica, se podrá implementar la fórmula de daño completa, pero está casi lista.


    // Método para iniciar el combate. Tiene un return para saber en el menú principal si el jugador ganó o perdió.

    public int iniciarCombate() {
        int salir = 0;
        int seleccionJugador = 0;
        int seleccionRival = 0;
        int decisionPelea = -4;
        System.out.println("¡El combate entre " + jugador.getNombre() + " y " + lider.getNombre() + " ha comenzado!");
        vidasJugador = 0;   
        vidasRival = 0;

        // Contar pokémones vivos del Jugador
        for (Pokemon pokemon : jugador.getEquipo()) { 
        if (pokemon.getEstado()) {
            vidasJugador++;
        }
    }

        // Contar pokémones vivos del Rival
        for (Pokemon pokemon : lider.getEquipo()) {
        if (pokemon.getEstado()) {
            vidasRival++;
        }
    }   
        // Aquí va la lógica del combate
        while (vidasJugador > 0 && vidasRival > 0 && salir == 0) {

            switch (decisionPelea){ // Se utilizan casos negativos pues el return de decisionPelea contiene la posición del nuevo pokemon, en caso de cambio
                
                case -1 :
                    seleccionRival = lider.npcElige();
                    System.out.printf("\n%s elige a %s (HP: %d)",lider.getNombre(),lider.getEquipo()[seleccionRival].getNombre(),lider.getEquipo()[seleccionRival].getHp());
                    break;
                case -2 :
                    seleccionJugador = jugador.elegirPokeJugador(0);
                    System.out.printf("\nHas elegido a %s (HP: %d)",jugador.getEquipo()[seleccionJugador].getNombre(),jugador.getEquipo()[seleccionJugador].getHp());
                    break;
                case -3 :
                    System.out.println("\n¡Has decidido retirarte del combate!");
                    salir = -1;
                    break;
                case -4 :
                    // En este caso siempre entra la primera vez
                    // Aquí se muestran las elecciones
                    seleccionJugador = jugador.elegirPokeJugador(0);
                    seleccionRival = lider.npcElige();
                    System.out.printf("\nHas elegido a %s (HP: %d)",jugador.getEquipo()[seleccionJugador].getNombre(),jugador.getEquipo()[seleccionJugador].getHp());
                    System.out.printf("\n%s elige a %s (HP: %d)",lider.getNombre(),lider.getEquipo()[seleccionRival].getNombre(),lider.getEquipo()[seleccionRival].getHp());
                    break;
                }

            if (salir == 0){ // Si no se ha decidido salir, se procede a la pelea
                System.out.println();
                decisionPelea = peleaPokemon(jugador.getEquipo()[seleccionJugador], lider.getEquipo()[seleccionRival]);
                
                while (decisionPelea >= 0) { // Este while maneja la posibilidad de que se cambie de pokemon todo el momento

                    System.out.printf("\nHas elegido a %s (HP: %d)",jugador.getEquipo()[decisionPelea].getNombre(),jugador.getEquipo()[decisionPelea].getHp());
                    decisionPelea = peleaPokemon(jugador.getEquipo()[decisionPelea], lider.getEquipo()[seleccionRival]);

                }

                //recuenta los pokemones vivos
                vidasJugador = 0;
                vidasRival = 0; 

                for (Pokemon pokemon : jugador.getEquipo()) { 
                if (pokemon.getEstado()) {
                vidasJugador++;
                    }
                }

                for (Pokemon pokemon : lider.getEquipo()) {
                if (pokemon.getEstado()) {
                vidasRival++;
                    }
                }
            }
        }
         //Condicionales para determinar el ganador   
        if (vidasJugador == 0){
            System.out.printf("\n¡Has sido derrotado por %s!\n",lider.getNombre());
            return 0; //derrota
        } else if (vidasRival == 0){
            System.out.printf("\n¡Has derrotado a %s!\n",lider.getNombre());
            lider.setEstado(false);
            return 1; //victoria
        }  else {
            return salir;
        }    
    }

    // Ejecuta el ataque con mensajes y devuelve el daño total, para ser restado a la vida del que recibe
    public int ataque(Pokemon ofensivo, Pokemon defensivo, Ataque ataque){
        double critico = calcularProbabilidadCritico();
        double efectiv = calcularEfectividad(ofensivo, defensivo, ataque);
        double danioB = ataque.getPoder() * ofensivo.getAtq() / defensivo.getDef();
        int daniototal = (int) Math.round(danioB * critico * efectiv);
        System.out.printf("\n¡%s realiza %s!\n",ofensivo.getNombre(),ataque.getNombre());
        imprimirProbabilidadCritico(critico);
        imprimirCategoriaDanio(efectiv);
        System.out.printf("\n%s recibe un total de %d de daño.",defensivo.getNombre(),daniototal);
        return daniototal;
    }

    public int peleaPokemon(Pokemon pokemonJugador, Pokemon pokemonRival){
        int inicio = 0;
        int cambiarPokemon = -1;
        int salir = -1;
        int seleccion = 1;

        // Pierde el que se quede sin vida
        while (pokemonJugador.getHp() > 0 && pokemonRival.getHp() > 0 && salir == -1) { 

            // Quien ataca primero según velocidad
            if (pokemonJugador.getVelocidad() >= pokemonRival.getVelocidad()) {
                if (inicio < 1) {
                    System.out.println("\nTu pokemon es más rápido y ataca primero.");  // Seleccionar ataque va más abajo
                    inicio ++;
                }
                seleccion = turnoJugador(pokemonJugador, pokemonRival, scanner);
                if (seleccion == 2){
                    cambiarPokemon = jugador.elegirPokeJugador(1);
                    if (cambiarPokemon >= 0){
                        salir = 0;
                    }
                } else if (seleccion == -3){
                    salir = 0;
                }
                // Ataque del rival si sigue con vida
                if (pokemonRival.getHp() > 0 && seleccion != -3) {
                    turnoRival(pokemonJugador, pokemonRival);                   
                }
                
            } else if (pokemonJugador.getVelocidad() < pokemonRival.getVelocidad()) {

                // Lo mismo de arriba pero el rival ataca primero
                if (inicio < 1){
                    System.out.println("\nEl pokemon rival es más rápido y ataca primero.");
                }

                turnoRival(pokemonJugador, pokemonRival);

                if (pokemonJugador.getHp() > 0) {
                    System.out.println("Es tu turno.");
                    seleccion = turnoJugador(pokemonJugador, pokemonRival, scanner);
                    if (seleccion == 2){
                        cambiarPokemon = jugador.elegirPokeJugador(1);
                        if (cambiarPokemon >= 0){
                            salir = 0;
                            System.out.printf("Has cambiado a %s\n", pokemonJugador.getNombre());
                            continue;
                        }
                    } else if (seleccion == -3){
                        salir = 0;
                    }
                }
            }

        }
  
        if (pokemonJugador.getHp() <= 0) {
            pokemonJugador.setEstado(false);
            return -2;
            // System.out.printf("\nTu pokemon %s ha sido derrotado.\n", pokemonJugador.getNombre());
        } else if (pokemonRival.getHp() <= 0){
            pokemonRival.setEstado(false);
            return -1;
            // System.out.printf("\nEl pokemon rival %s ha sido derrotado.\n", pokemonRival.getNombre());
        } else if (seleccion == 2 && cambiarPokemon >= 0){
            return cambiarPokemon;
        } else {
            return -3;
        }
    }

    private void turnoRival(Pokemon pokemonJugador, Pokemon pokemonRival){
        mostrarVida(pokemonJugador, pokemonRival);
        System.out.printf("\nEs el turno de %s...",lider.getNombre());
        int posAtkRival = lider.ataqueNPC(pokemonRival);
        Ataque atk = pokemonRival.getHabilidades()[posAtkRival];
        int ppActual = pokemonRival.getHabilidades()[posAtkRival].getPp();
        pokemonJugador.setHp(pokemonJugador.getHp() - ataque(pokemonRival,pokemonJugador,atk));
        if (pokemonJugador.getHp() <= 0) {
            System.out.printf("\n%s ha sido derrotado.\n",pokemonJugador.getNombre());
        }
        pokemonRival.getHabilidades()[posAtkRival].setPp(ppActual - 1);
    }

    private int turnoJugador(Pokemon pokemonJugador, Pokemon pokemonRival, Scanner scanner){
        int decision = 0;
        int turno = 0;
        int opcionTurno;
        while (turno == 0){
            try {
                mostrarVida(pokemonJugador, pokemonRival);
                System.out.println("¡Es tu turno!\n");
                System.out.println("1) Atacar\n2) Cambiar pokemon\n3) Retirarse\n");
                opcionTurno = scanner.nextInt();
                if (opcionTurno == 1) {
                    int cerrarAtaque = 0;
                    int opcionAtaque;
                    while (cerrarAtaque == 0) {
                        try {
                            System.out.println("\nSelecciona un ataque: ");
                            int cantataques = 0;
                            int posicionAtk = 0;
                            for (Ataque i : pokemonJugador.getHabilidades()){
                                if (i.getPp() > 0){
                                    cantataques += 1;
                                }
                            }
                            // Lista temporal para mostrar solo los ataques con PP > 0
                            Ataque[] ataquesdisp = new Ataque[cantataques];
                            for (int i = 0 ; i < pokemonJugador.getHabilidades().length ; i++){
                                if (pokemonJugador.getHabilidades()[i].getPp() > 0){
                                    ataquesdisp[posicionAtk] = pokemonJugador.getHabilidades()[i];
                                    posicionAtk += 1;
                                }
                            }
                            for (int i = 0 ; i < ataquesdisp.length ; i++){
                                System.out.printf("\n%d) %s (Poder: %d, PP: %d)", i+1, pokemonJugador.getHabilidades()[i].getNombre(), pokemonJugador.getHabilidades()[i].getPoder(), pokemonJugador.getHabilidades()[i].getPp());
                            }
                            opcionAtaque = scanner.nextInt() - 1;
                            // Verifica que la opción sea válida
                            if (opcionAtaque >= 0 && opcionAtaque < ataquesdisp.length) {

                                // Realiza el ataque y resta el PP
                                pokemonRival.setHp(pokemonRival.getHp() - ataque(pokemonJugador,pokemonRival,ataquesdisp[opcionAtaque]));
                                if (pokemonRival.getHp() <= 0) {
                                    System.out.printf("\n%s ha sido derrotado.\n",pokemonRival.getNombre());
                                }
                                int ppActual = ataquesdisp[opcionAtaque].getPp();
                                ataquesdisp[opcionAtaque].setPp(ppActual - 1);
                                cerrarAtaque = 1;
                                turno = 1;
                                if (pokemonRival.getHp() < 0) {
                                    // Evita que la vida quede negativa
                                    pokemonRival.setHp(0);
                                }
                            } else {
                                System.out.println("Opción inválida. Por favor, seleccione un ataque.\n");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("Error: " + e);
                            System.err.println("Por favor, ingresa una opción válida para el ataque.\n");
                            scanner.nextLine();
                        }
                    }
                } else if (opcionTurno == 2) {
                    decision = opcionTurno;
                    turno = 1;
                } else if (opcionTurno == 3) {
                    decision = -3;
                    turno = 1;
                } else {
                    System.out.println("Por favor, introduzca una de las opciones.\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca una de las opciones.\n");
            }
        }
        return decision;
    }

    public void mostrarVida(Pokemon pokemon1, Pokemon pokemon2){
        if (pokemon1.getVelocidad() >= pokemon2.getVelocidad()){
            System.out.printf("\nHP de %s: %d/%d",pokemon1.getNombre(),pokemon1.getHp(),pokemon1.getHpReset());
            System.out.printf("\nHP de %s: %d/%d\n",pokemon2.getNombre(),pokemon2.getHp(),pokemon2.getHpReset());
        } else {
            System.out.printf("\nHP de %s: %d/%d",pokemon2.getNombre(),pokemon2.getHp(),pokemon2.getHpReset());
            System.out.printf("\nHP de %s: %d/%d\n",pokemon1.getNombre(),pokemon1.getHp(),pokemon1.getHpReset());
        }
        System.out.println("--------------------------------------------------------------------------------------\n");
    }

}
