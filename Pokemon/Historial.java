
/*
 * Esta clase tiene una tiene como objetivo registrar, almacenar y resumir los resultados de las batallas del juego (a modo de historial).
 * Actúa como una base de datos simple para las estadísticas del jugador.
 * Cada vez que el jugador completa una batalla, ya sea contra un líder de gimnasio o un NPC, se registra el resultado (victoria o derrota),
 * el nombre del rival, el equipo del rival, el nombre del jugador y el equipo del jugador.
 * Luego, al final del juego, se puede mostrar un resumen de todas las batallas, incluyendo el número de victorias y derrotas.
 * Esto permite al jugador ver su progreso y desempeño a lo largo del juego.
 * La clase utiliza una matriz bidimensional para almacenar la información de cada batalla.
 * Cada fila representa una batalla y las columnas almacenan los detalles mencionados.
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Emanuel Sancho Sánchez, C07332
 * @author Chun Ping Liu Li, C5G492
 * @author Jefferson Miranda Sabala, C24874
 * @version 1.0
 */
public class Historial {
    private String[][] batalla;
    public Historial(){
        batalla = new String[31][5]; //31 batallas
    }

    /*
     * Este método se encarga de guardar los datos de una batalla terminada en la matriz.
     * Toma todos los datos clave de un combate (quién peleó, qué equipos usaron y quién ganó) y
     * los guarda en la fila de la matriz correspondiente al número de batalla.
     * 
     * @param numBatalla El número de la batalla (índice de la fila en la matriz).
     * @param victoria Indica si el jugador ganó (true) o perdió (false).
     * @param rival El nombre del rival contra el que se peleó.
     * @param equipoRival El equipo de Pokemones del rival.
     * @param jugador El objeto Jugador que contiene el nombre y equipo del jugador (usuario).
     */
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

    /*
     * Este método muestra un resumen de todas las batallas registradas en el historial.
     * Muestra los detalles de cada batalla (resultado, rival, equipos) y un conteo total
     * de victorias y derrotas.
     * 
     * @param nombreGimnasio El nombre del gimnasio o contexto de las batallas (por ejemplo, "Gimnasio Fuego").
     * @param indicesBatalla Una lista con los índices de las batallas que se desean mostrar en el resumen.
     */
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
