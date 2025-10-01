
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

        // STAB: Si el ataque coincide con el tipo del Pokémon atacante
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
            System.out.println("súper efectivo");
        } else if (efectividad >= 1 && efectividad < 2) {
            System.out.println("efectivo");
        } else if (efectividad >= 0.5 && efectividad < 1) {
            System.out.println("poco efectivo");
        } else {
            System.out.println("no efectivo");
        }
    }

    public void iniciarCombate() {
        System.out.println("¡El combate entre " + jugador.getNombre() + " y " + entrenador.getNombre() + " ha comenzado!");
        // Aquí va la lógica del combate
    }
}
