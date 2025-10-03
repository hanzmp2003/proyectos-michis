public class Historial {
    private boolean estadoBatalla; // true = Victoria, false = Derrota
    private Entrenador entrenador;
    private Lideres lider;
    private Jugador jugador;

    public void setHistorialEntrenador(int numBatalla, boolean estadoBatalla, Entrenador entrenador,  Jugador jugador) {
        String[][] batalla = new String[31][5];  // matriz para almacenar múltiples batallas 5 datos, 31 batallas
        if (numBatalla != 6 && numBatalla != 7 && numBatalla != 8 && numBatalla != 16 && numBatalla != 17 && numBatalla != 18 && numBatalla != 19 && numBatalla != 27 && numBatalla != 28 && numBatalla != 29 && numBatalla != 30 && numBatalla != 31){
        //Caso Entrenador 
         for(int i = 0; i < 5; i++) {
        if(i == 0) {  // Resultado de la batalla
            batalla[numBatalla][i] = estadoBatalla ? "Victoria" : "Derrota";
            System.out.printf("Resultado: %s%n", batalla[numBatalla][i]);
            
        } else if(i == 1) {   //Nombre del rival
            batalla[numBatalla][i] = entrenador.getNombre();
            System.out.printf("Nombre del Rival: %s%n", entrenador.getNombre());

        } else if (i == 2) { // Equipo del rival 
            String equipoStr = ""; //Mausqueramienta para convertir los datos a string de la lista
            System.out.println("Equipo de Pokémon del Rival:");
            for (Pokemon pokemon : entrenador.getEquipo()) {
                System.out.println("- " + pokemon.getNombre());
                equipoStr += pokemon.getNombre() + " "; //
            }
            batalla[numBatalla][i] = equipoStr;
            
        } else if(i == 3) { //Nombre del jugador
            batalla[numBatalla][i] = jugador.getNombre();
            System.out.printf("Nombre del Jugador: %s%n", jugador.getNombre());
            
        } else if(i == 4){ //Equipo del jugador como String
            String equipoJugadorStr = "";
            System.out.println("Equipo de Pokémon del Jugador:");
            for (Pokemon pokemon : jugador.getEquipo()) {
                System.out.println("- " + pokemon.getNombre());
                equipoJugadorStr += pokemon.getNombre() + " ";
            }
            batalla[numBatalla][i] = equipoJugadorStr;
        }

        }

        }else{ //Ahora si no cumple el if imprime lo mismo pero para los lideres
            //Caso Líderes 
        for(int i = 0; i < 5; i++) {
        if(i == 0) {  // Resultado de la batalla
            batalla[numBatalla][i] = estadoBatalla ? "Victoria" : "Derrota";
            System.out.printf("Resultado: %s%n", batalla[numBatalla][i]);
            
        } else if(i == 1) {   //Nombre del rival
            batalla[numBatalla][i] = lider.getNombre();
            System.out.printf("Nombre del Rival: %s%n", entrenador.getNombre());

        } else if (i == 2) { // Equipo del rival 
            String equipoStr = ""; //Mausqueramienta para convertir los datos a string de la lista
            System.out.println("Equipo de Pokémon del Rival:");
            for (Pokemon pokemon : lider.getEquipo()) {
                System.out.println("- " + pokemon.getNombre());
                equipoStr += pokemon.getNombre() + " "; //
            }
            batalla[numBatalla][i] = equipoStr;
            
        } else if(i == 3) { //Nombre del jugador
            batalla[numBatalla][i] = jugador.getNombre();
            System.out.printf("Nombre del Jugador: %s%n", jugador.getNombre());
            
        } else if(i == 4){ //Equipo del jugador como String
            String equipoJugadorStr = "";
            System.out.println("Equipo de Pokémon del Jugador:");
            for (Pokemon pokemon : jugador.getEquipo()) {
                System.out.println("- " + pokemon.getNombre());
                equipoJugadorStr += pokemon.getNombre() + " ";
            }
            batalla[numBatalla][i] = equipoJugadorStr;
        }

        }
       }

      }
    
}
