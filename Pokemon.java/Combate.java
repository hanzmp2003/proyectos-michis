import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Clase para manejar el combate entre un jugador y un entrenador
public class Combate {
    Jugador jugador;
    Entrenador entrenador;

    public Combate(Jugador jugador, Entrenador entrenador) {
        this.jugador = jugador;
        this.entrenador = entrenador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
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
        int vidasJugador = 1;
        int vidasRival = 1;
        System.out.println("¡El combate entre " + jugador.getNombre() + " y " + entrenador.getNombre() + " ha comenzado!");
        // Aquí va la lógica del combate
        while (vidasJugador > 0 && vidasRival > 0) {
            vidasJugador = 0;
            vidasRival = 0;
            int seleccionJugador = jugador.elegirPokeJugador(); // AGREGAR CASO EN QUE SEA -1
            int seleccionRival = entrenador.npcElige();
            System.out.println();
            System.out.printf("\nHas elegido a %s (HP: %d)",jugador.getEquipo()[seleccionJugador].getNombre(),jugador.getEquipo()[seleccionJugador].getHp());
            System.out.printf("\n%s elige a %s (HP: %d)",entrenador.getNombre(),entrenador.getEquipo()[seleccionRival].getNombre(),entrenador.getEquipo()[seleccionRival].getHp());
            peleaPokemon(jugador.getEquipo()[seleccionJugador], entrenador.getEquipo()[seleccionRival]);
            for (Pokemon i : jugador.getEquipo()){
                if (i.getEstado() == true){
                    vidasJugador += 1; // La idea es que si nunca suma más de 0, el jugador pierde
                }
            }
            for (Pokemon j : entrenador.getEquipo()){
                if (j.getEstado() == true){
                    vidasRival += 1; // Lo mismo para el rival
                }
            }
        }
        if (vidasJugador == 0){
            System.out.printf("\n¡Has sido derrotado por %s!\n",entrenador.getNombre());
            return 0;
        } else if (vidasRival == 0){
            System.out.printf("\n¡Has derrotado a %s!\n",entrenador.getNombre());
            return 1;
        } else {   
            return -1; // No debería llegar aquí. Se deja para manejar un posible error.
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

    public void peleaPokemon(Pokemon pokemonJugador, Pokemon pokemonRival){
        int cerrarAtaque = 0;
        int opcionAtaque = 0;
        Scanner scanner = new Scanner(System.in);

        // Pierde el que se quede sin vida
        while (pokemonJugador.getHp() > 0 && pokemonRival.getHp() > 0) { 
            cerrarAtaque = 0;
            // Quien ataca primero según velocidad
            if (pokemonJugador.getVelocidad() >= pokemonRival.getVelocidad()) {
                System.out.println("Tu pokemon es más rápido y ataca primero. Selecciona un ataque: ");
                while (cerrarAtaque == 0) {
                    try {
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
                            int ppActual = ataquesdisp[opcionAtaque].getPp();
                            ataquesdisp[opcionAtaque].setPp(ppActual - 1);
                            cerrarAtaque = 1;
                            if (pokemonRival.getHp() < 0) {
                                // Evita que la vida quede negativa
                                pokemonRival.setHp(0);
                            }
                        } else {
                            System.out.println("Opción inválida. Por favor, seleccione un ataque.\n");
                        }
                    } catch (InputMismatchException e) {
                        System.err.println("Error: " + e);
                        System.err.println("Por favor, ingresa una opción válida para el ataque.");
                        scanner.nextLine();
                    }
                // Ataque del rival si sigue con vida
                if (pokemonRival.getHp() > 0) {
                    int posAtkRival = entrenador.ataqueNPC(pokemonRival);
                    int ppActual = pokemonRival.getHabilidades()[posAtkRival].getPp();
                    pokemonJugador.setHp(pokemonJugador.getHp() - ataque(pokemonRival,pokemonJugador,pokemonRival.getHabilidades()[posAtkRival]));
                    pokemonRival.getHabilidades()[posAtkRival].setPp(ppActual - 1);                    
                }
                }
            } else if (pokemonJugador.getVelocidad() < pokemonRival.getVelocidad()) {

                // Lo mismo de arriba pero el rival ataca primero
                System.out.println("El pokemon rival es más rápido y ataca primero.");
                if (pokemonRival.getHp() > 0) {
                    int posAtkRival = entrenador.ataqueNPC(pokemonRival);
                    int ppActual = pokemonRival.getHabilidades()[posAtkRival].getPp();
                    pokemonJugador.setHp(pokemonJugador.getHp() - ataque(pokemonRival,pokemonJugador,pokemonRival.getHabilidades()[posAtkRival]));
                    pokemonRival.getHabilidades()[posAtkRival].setPp(ppActual - 1);                    
                }
                System.out.println("Es tu turno. Selecciona un ataque: ");
                while (cerrarAtaque == 0) {
                    try {
                        int cantataques = 0;
                        int posicionAtk = 0;
                        for (Ataque i : pokemonJugador.getHabilidades()){
                            if (i.getPp() > 0){
                                cantataques += 1;
                            }
                        }
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
                        if (opcionAtaque >= 0 && opcionAtaque < ataquesdisp.length) {
                            pokemonRival.setHp(pokemonRival.getHp() - ataque(pokemonJugador,pokemonRival,ataquesdisp[opcionAtaque]));
                            int ppActual = ataquesdisp[opcionAtaque].getPp();
                            ataquesdisp[opcionAtaque].setPp(ppActual - 1);
                            cerrarAtaque = 1;
                            if (pokemonRival.getHp() < 0) {
                                pokemonRival.setHp(0);
                            }
                        } else {
                            System.out.println("Opción inválida. Por favor, seleccione un ataque.\n");
                        }
                    } catch (InputMismatchException e) {
                        System.err.println("Error: " + e);
                        System.err.println("Por favor, ingresa una opción válida para el ataque.");
                        scanner.nextLine();
                    }
                }
            }
        }
        scanner.close();
        if (pokemonJugador.getHp() <= 0) {
            pokemonJugador.setEstado(false);
            System.out.printf("\nTu pokemon %s ha sido derrotado.\n", pokemonJugador.getNombre());
        } else if (pokemonRival.getHp() <= 0) {
            pokemonRival.setEstado(false);
            System.out.printf("\nEl pokemon rival %s ha sido derrotado.\n", pokemonRival.getNombre());
        }
    }

}
