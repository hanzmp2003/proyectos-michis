
/**  
 * Clase AgregarGimnasio que inicializa todos los ataques disponibles en el juego
 * 
 * @author Hanz Madrigal Porras, C4G754
   @author Chun Ping Liu Li, C5G492
   @author Emanuel Sancho Sánchez, C07332
   @author Jefferson Emanuel Miranda Sabala, C24874

   @version 1.0 
*/


public class AgregarGimnasio {
    Gimnasio laJungla;
    Gimnasio elBunker;
    Gimnasio LosTigres; 


/**
 * Constructor donde se inicializan los gimnasion con el respectivo nivel de dificultad 
 * Instancias de gimnasios bien chatas
 * Gimnasio la jungla es el fácil 
 * Gimnasio el bunker es el intermedio 
 * Gimnasio los tigres es el difícil
 */

    public AgregarGimnasio() {
        laJungla = new Gimnasio("La Jungla del Precario", "Fácil");
        elBunker = new Gimnasio("El Búnker de los Chatas", "Intermedio");
        LosTigres = new Gimnasio("Los Tigres del Guarco", "Difícil");
    }


 /**  
  * Imprime los nombres de los gimnasios
  * @param nombre 
  * @param entrenador1 rival uno 
  * @param entrenador2 rival dos 
  * @param lider rival final 
  */ 



    public void MostrarGimnasio(Gimnasio nombre, Entrenador entrenador1, Entrenador entrenador2, Lideres lider){
    System.out.println("Gimnasio: " + nombre.getNombre() + " | Nivel: " + nombre.getNivel());
    System.out.println("Rivales: \n");
    MostrarRivales(entrenador1, entrenador2, lider);
    }

/**
 * muestra la  información de los rivales que hay en el gimnasio
 * @param entrenador1 rival uno 
 * @param entrenador2 rival dos 
 * @param lider rival final 
 */

    public void MostrarRivales(Entrenador entrenador1, Entrenador entrenador2, Lideres lider ){
        for (int i = 0; i < 3; i++) {
        System.out.printf("%d) ", i + 1);
        if (i == 0) {
            System.out.println("Entrenador 1: " + entrenador1.getNombre());
            mostrarEquipo(entrenador1.getEquipo());
        } else if (i == 1) {
            System.out.println("Entrenador 2: " + entrenador2.getNombre());
            mostrarEquipo(entrenador2.getEquipo());
        } else if (i == 2) {
            System.out.println("Líder: " + lider.getNombre());
            mostrarEquipo(lider.getEquipo());
        }

        }
    /**
     * Muestra el equipo de pokemones de cada entrenador
     * @param equipo
     */
    }

    /**
     * 
     * @param  arreglo pokemones de equipos 
     */
    public void mostrarEquipo(Pokemon[] equipo) {
    for (Pokemon p : equipo) {
        System.out.println("   - " + p.getNombre());
    }

  }
}


