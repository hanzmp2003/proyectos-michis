/**  
 * Clase AgregarPokemon que inicializa todos los Pokémon disponibles en el juego.
 * 
 * @author Hanz Madrigal Porras, C4G754
   @author Chun Ping Liu Li, C5G492
   @author Emanuel Sancho Sánchez, C07332
   @author Jefferson Emanuel Miranda Sabala, C24874

   @version 1.0 
*/

public class Ataque {
    private String nombre;
    private int poder;
    private String tipo;
    private int pp;
    private int ppReset;

    /**
     * Constructor por defecto y constructor con parámetros
     */
    public Ataque() {
        this.nombre = "";
        this.poder = 0;
        this.tipo = "";
        this.pp = 0;
    }

    /**
     * Constructor con parámetros
     * @param nombre Nombre del ataque
     * @param poder Poder del ataque
     * @param tipo Tipo del ataque
     * @param pp Puntos de poder del ataque
     */
    public Ataque(String nombre, int poder, String tipo, int pp) {
        this.nombre = nombre;
        this.poder = poder;
        this.tipo = tipo;
        this.pp = pp;
        this.ppReset = pp;
    }

    /**
     * Constructor de copia
     * @param ataque Objeto de tipo Ataque a copiar
     */
    public Ataque(Ataque ataque) {
        this.nombre = ataque.nombre;
        this.poder = ataque.poder;
        this.tipo = ataque.tipo;
        this.pp = ataque.pp;
        this.ppReset = ataque.ppReset;
    }
    /**
     * Método para resetear los puntos de poder del ataque a su valor inicial
     */
    public void resetPP(){
        this.pp = this.ppReset;
    }
    /**
     * Getters y Setters
     */
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPoder() { return poder; }
    public void setPoder(int poder) { this.poder = poder; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getPp() { return pp; }
    public void setPp(int pp) { this.pp = pp; }
}