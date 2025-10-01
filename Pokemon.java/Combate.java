import java.util.Random;

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

    // Método para iniciar el combate
    public void iniciarCombate() {
        System.out.println("¡El combate entre " + jugador.getNombre() + " y " + entrenador.getNombre() + " ha comenzado!");
        // Aquí va la lógica del combate

    }

    // Ejecuta el ataque con mensajes y devuelve el daño total, para ser restado a la vida del que recibe
    public double ataque(Pokemon ofensivo, Pokemon defensivo, Ataque ataque){
        double critico = calcularProbabilidadCritico();
        double efectiv = calcularEfectividad(ofensivo, defensivo, ataque);
        double danioB = ataque.getPoder() * ofensivo.getAtq() / defensivo.getDef();
        int daniototal = (int) Math.round(danioB * critico * efectiv);
        System.out.printf("\n¡%s realiza %s!\n",ofensivo.getNombre(),ataque.getNombre());
        imprimirProbabilidadCritico(critico);
        imprimirCategoriaDanio(efectiv);
        System.out.printf("\n%s recibe un total de %d de daño.",ofensivo.getNombre(),daniototal);
        return daniototal;
    }

}
