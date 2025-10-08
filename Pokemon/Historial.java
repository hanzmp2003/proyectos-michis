public class Historial {
    private String[][] batalla;
    public Historial(){
        batalla = new String[31][5];

    }

    public void setHistorialEntrenador(int numBatalla, boolean estadoBatalla, Entrenador entrenador, Jugador jugador, Lideres lider) {
        if (numBatalla < 0 || numBatalla >= batalla.length) {
            System.out.println("Número de batalla fuera de rango.");
            return;
        }

        if (numBatalla != 6 && numBatalla != 7 && numBatalla != 8 &&
            numBatalla != 16 && numBatalla != 17 && numBatalla != 18 &&
            numBatalla != 19 && numBatalla != 27 && numBatalla != 28 &&
            numBatalla != 29 && numBatalla != 30 && numBatalla != 31) {

            batalla[numBatalla][0] = estadoBatalla ? "Victoria" : "Derrota";
            batalla[numBatalla][1] = entrenador.getNombre();
            System.out.printf("Resultado: %s%n", batalla[numBatalla][0]);
            System.out.printf("Nombre del Rival: %s%n", batalla[numBatalla][1]);

            String equipoStr = "";
            System.out.println("Equipo de Pokémon del Rival:");
            for (Pokemon pokemon : entrenador.getEquipo()) {
                System.out.println("- " + pokemon.getNombre());
                equipoStr += pokemon.getNombre() + " ";
            }
            batalla[numBatalla][2] = equipoStr;

            batalla[numBatalla][3] = jugador.getNombre();
            System.out.printf("Nombre del Jugador: %s%n", batalla[numBatalla][3]);

            String equipoJugadorStr = "";
            System.out.println("Equipo de Pokémon del Jugador:");
            for (Pokemon pokemon : jugador.getEquipo()) {
                System.out.println("- " + pokemon.getNombre());
                equipoJugadorStr += pokemon.getNombre() + " ";
            }
            batalla[numBatalla][4] = equipoJugadorStr;

        } else {
            batalla[numBatalla][0] = estadoBatalla ? "Victoria" : "Derrota";
            batalla[numBatalla][1] = lider.getNombre();
            System.out.printf("Resultado: %s%n", batalla[numBatalla][0]);
            System.out.printf("Nombre del Rival: %s%n", batalla[numBatalla][1]);

            String equipoStr = "";
            System.out.println("Equipo de Pokémon del Rival:");
            for (Pokemon pokemon : lider.getEquipo()) {
                System.out.println("- " + pokemon.getNombre());
                equipoStr += pokemon.getNombre() + " ";
            }
            batalla[numBatalla][2] = equipoStr;

            batalla[numBatalla][3] = jugador.getNombre();
            System.out.printf("Nombre del Jugador: %s%n", batalla[numBatalla][3]);

            String equipoJugadorStr = "";
            System.out.println("Equipo de Pokémon del Jugador:");
            for (Pokemon pokemon : jugador.getEquipo()) {
                System.out.println("- " + pokemon.getNombre());
                equipoJugadorStr += pokemon.getNombre() + " ";
            }
            batalla[numBatalla][4] = equipoJugadorStr;
        }
    }

    public String[] getBatalla(int numBatalla) {
        return batalla[numBatalla];
    }
}
