public class Historial {
    private String[][] batalla;
    public Historial(){
        batalla = new String[31][5]; //31 batallas

    }

    public void registrarBatalla(int numBatalla, boolean victoria, String rival, Pokemon[] equipoRival, Jugador jugador) {
        batalla[numBatalla][0] = victoria ? "Victoria" : "Derrota";
        batalla[numBatalla][1] = rival;

        String equipoRivalStr = "";
        for (Pokemon p : equipoRival) {
            equipoRivalStr += p.getNombre() + " ";
        }
        batalla[numBatalla][2] = equipoRivalStr;

        batalla[numBatalla][3] = jugador.getNombre();

        String equipoJugadorStr = "";
        for (Pokemon p : jugador.getEquipo()) {
            equipoJugadorStr += p.getNombre() + " ";
        }
        batalla[numBatalla][4] = equipoJugadorStr;
    }

    public void mostrarResumenGimnasio(String nombreGimnasio, int[] indicesBatalla) {
        int victorias = 0;
        int derrotas = 0;

        System.out.printf("\nHistorial del %s:\n", nombreGimnasio);
        for (int i : indicesBatalla) {
            if (batalla[i][0] != null) {
                System.out.printf("\nBatalla %d:\n", i + 1);
                System.out.println("Resultado: " + batalla[i][0]);
                System.out.println("Rival: " + batalla[i][1]);
                System.out.println("Equipo del Rival: " + batalla[i][2]);
                System.out.println("Jugador: " + batalla[i][3]);
                System.out.println("Equipo del Jugador: " + batalla[i][4]);

                if (batalla[i][0].equals("Victoria")) victorias++;
                else if (batalla[i][0].equals("Derrota")) derrotas++;
            } else {
                System.out.printf("\nBatalla %d: No registrada\n", i + 1);
            }
        }

        System.out.println("\n Resumen:");
        System.out.println("Victorias: " + victorias);
        System.out.println("Derrotas: " + derrotas);
    }
}
