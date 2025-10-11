
/**
 * Clase que representa un gimnasio en el juego de Pokémon. Un gimnasio tiene un nombre, una dificultad, un conjunto de entrenadores y un líder.
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Chun Ping Liu Li, C5G492
 * @author Emanuel Sancho Sánchez, C07332
 * @author Jefferson Emanuel Miranda Sabala, C24874
 *
 * @version 1.0 
 */
public class Gimnasio {
    private String nombre;
    private String dificultad;
    private Entrenador[] entrenadores;
    private Lideres lider;

    /**
     * Constructor para el gimnasio con su nombre, dificultad, entrenadores y líder.
     * A partir del nombre del gimnasio, se asignan automáticamente los entrenadores y el líder correspondientes.
     * 
     * @param nombre El nombre del gimnasio.
     * @param dificultad La dificultad del gimnasio (fácil, intermedio, difícil).
     */
    public Gimnasio(String nombre, String dificultad) {
        AgregarLideres objetoLid = new AgregarLideres();
        AgregarEntrenadores objetoEnt = new AgregarEntrenadores();
        this.nombre = nombre;
        this.dificultad = dificultad;

        switch (nombre) {
            case "La Jungla del Precario":
                this.entrenadores = new Entrenador[]{objetoEnt.brittany, objetoEnt.kimberly};
                this.lider = objetoLid.juankiloco;
                break;
            case "Monte del Porcionzón":
                this.entrenadores = new Entrenador[]{objetoEnt.brayan, objetoEnt.byron};
                this.lider = objetoLid.porcionzon;
                break;
            case "Cueva del Chunche":
                this.entrenadores = new Entrenador[]{objetoEnt.kevin, objetoEnt.yandel};
                this.lider = objetoLid.chunche;
                break;
            default:
                this.entrenadores = new Entrenador[0];
                this.lider = new Lideres("Líder desconocido", 1, "Normal", new Pokemon[0]);
                break;
        }
    }

    /**
     * Setter para el nombre del gimnasio.
     * 
     * @param nombre El nuevo nombre del gimnasio.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Setter para la dificultad del gimnasio.
     * 
     * @param nivel La nueva dificultad del gimnasio (fácil, intermedio, difícil).
     */
    public void setNivel(String nivel) { this.dificultad = nivel; }

    /**
     * Setter para los rivales del gimnasio (entrenadores y líder).
     * 
     * @param lider El nuevo líder del gimnasio.
     * @param entrenador1 El primer entrenador del gimnasio.
     * @param entrenador2 El segundo entrenador del gimnasio.
     */
    public void setRivales(Lideres lider, Entrenador entrenador1, Entrenador entrenador2){
        this.lider = lider;
        this.entrenadores = new Entrenador[] {entrenador1, entrenador2};
    }

    /**
     * Getter para el nombre del gimnasio.
     * 
     * @return El nombre del gimnasio (String).
     */
    public String getNombre() { return nombre; }

    /**
     * Getter para la dificultad del gimnasio.
     * 
     * @return La dificultad del gimnasio (String).
     */
    public String getNivel() { return dificultad; } 

    /**
     * Getter para el lider del gimnasio.
     * 
     * @return El líder del gimnasio.
     */
    public Lideres getLider(){
        return lider;
    }

    /**
     * Getter para los entrenadores del gimnasio.
     * 
     * @return Una lista de los entrenadores del gimnasio.
     */
    public Entrenador[] entrenadores(){
        return entrenadores;
    }
    
    /**
     * Método para ver los oponentes del gimnasio (entrenadores y líder).
     * Muestra una lista numerada de los entrenadores y el líder, indicando, además, si han sido derrotados; en caso de que lo hayan sido.
     * Muestra los primeros dos entrenadores, y luego el líder al final.
     */
    public void verOponentes(){ 
        int contador = 1;
        for (Entrenador i : entrenadores){
            System.out.printf("\n%d) %s", contador, i.getNombre());
            if (!i.getEstado())
                System.out.printf("  ----> Ha sido derrotado");
            contador++;
        }

        if (lider != null) {
            System.out.printf("\n%d) (LIDER) %s", contador, lider.getNombre());
            if (!lider.getEstado()) {
                System.out.printf("  ----> Ha sido derrotado");
            }
            System.out.println();
        }
    }
}
