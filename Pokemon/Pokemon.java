/**
 * Esta clase crea y representa pokemones con sus características, stats y habilidades.
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Emanuel Sancho Sánchez, C07332
 * @author Chun Ping Liu Li, C5G492
 * @author Jefferson Miranda Sabala, C24874
 * @version 1.0
 *  
 */
public class Pokemon {    //Método modelo para Pokemon
    private String nombre;
    private boolean mostrar; // Solo funciona para mostrar catalogo inicial
    private int nivel;
    private int hp;
    private int atq;
    private int ataque;
    private int hpReset;
    private int def;
    private int velocidad;
    private String tipo;
    private Ataque[] habilidades;
    private boolean estado;
    
    /**
     * Constructor para los pokemones y sus características.
     * 
     */

    public Pokemon() {
        nombre = "";
        tipo = "";
        nivel = 0;
        hp = 0;
        atq = 0;
        def = 0;
        velocidad = 0;
        estado = true;
        habilidades = new Ataque[4];
        mostrar = true; 
    }

    /**
     * Este es un constructor copia que crea un nuevo objeto Pokemon con las mismas características que otro objeto Pokemon dado.
     * @param pokemon El objeto Pokemon del cual se copiarán las características.
     */
    public Pokemon(Pokemon pokemon){
        this.mostrar = true;
        this.nivel = pokemon.getNivel();
        this.nombre = pokemon.getNombre();
        this.hp = pokemon.getHp();
        this.atq = pokemon.getAtq();
        this.def = pokemon.getDef();
        this.velocidad = pokemon.getVelocidad();
        this.hpReset = pokemon.getHp();
        this.tipo = pokemon.getTipo();
        this.estado = pokemon.getEstado();
        habilidades = new Ataque[pokemon.getHabilidades().length];
        for (int i = 0 ; i < habilidades.length ; i++) {
            habilidades[i] = new Ataque(pokemon.getHabilidades()[i]);
        }
    }

    /**
     * Setter de Características para los pokemones
     * @param nombre nombre del pokemon
     * @param tipo tipo del pokemon (Hada, Veneno, Roca, Agua, Fuego, Planta, Electrico, Fantasma, Hielo, Psíquico, Normal, Siniestro, Tierra)
     */
    public void setCaracteristicas(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    /*
     * Getter del nombre del pokemon
     * @return nombre del pokemon
     */
    public String getNombre() {
        return nombre;
    }
    
    /*
     * Getter del tipo del pokemon
     * @return tipo del pokemon
     */
    public String getTipo() {
        return tipo;
    }
    
    /*
     * Setter para las stats básicas del pokemon
     * @param nivel nivel del pokemon
     * @param hp puntos de vida del pokemon
     * @param atq puntos de ataque del pokemon
     * @param def puntos de defensa del pokemon
     * @param velocidad puntos de velocidad del pokemon
     */
    public void setStats(int nivel, int hp, int atq, int def, int velocidad) {
        this.nivel = nivel;
        this.hp = hp;
        this.atq = atq;
        this.def = def;
        this.velocidad = velocidad;
        this.hpReset = hp;
    }
    
    /*
     * Setter para el poder de ataque del pokemon (esta es una versión alternativa; podría no usarse luego),
     * calculado como el promedio de los poderes de sus habilidades.
     */
    public void setAtaque(){
        int suma = 0;
        for (int i = 0; i < habilidades.length; i++) {
            suma += habilidades[i].getPoder();
        }
        this.ataque = (int) Math.round(suma / habilidades.length); // Devuelve el entero más grande menor que el promedio
    }

    /*
     * Getter para el poder de ataque del pokemon
     * @return poder de ataque del pokemon
     */
    public int getAtaque(){
        return ataque;
    }

    /*
     * Setter para los puntos de vida del pokemon
     * @param hp puntos de vida a asignar al pokemon
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /*
     * Getter para el nivel del pokemon
     * @return nivel del pokemon
     */
    public int getNivel() {
        return nivel;
    }
    
    /*
     * Getter para los puntos de vida del pokemon
     * @return puntos de vida del pokemon
     */
    public int getHp() {
        return hp;
    }

    /*
     * Este es un getter de la vida máxima, inicial o base del pokemon
     * @return puntos de vida iniciales del pokemon
     */
    public int getHpReset(){
        return hpReset;
    }

    /*
     * Getter de puntos de ataque del pokemon
     * @return puntos de ataque del pokemon
     */
    public int getAtq(){
        return atq;
    }
    
    /*
     * Getter de puntos de defensa del pokemon
     * @return puntos de defensa del pokemon
     */
    public int getDef() {
        return def;
    }
    
    /*
     * Getter de puntos de velocidad del pokemon
     * @return puntos de velocidad del pokemon
     */
    public int getVelocidad() {
        return velocidad;
    }
    
    /*
     * Setter de las Habilidades y ataques del pokemon
     * @param habilidad1 primer ataque del pokemon
     * @param habilidad2 segundo ataque del pokemon
     * @param habilidad3 tercer ataque del pokemon
     * @param habilidad4 cuarto ataque del pokemon
     */
    public void setHabilidades(Ataque habilidad1, Ataque habilidad2, Ataque habilidad3, Ataque habilidad4) {
        habilidades = new Ataque[4];
        habilidades [0] = habilidad1;
        habilidades [1] = habilidad2;
        habilidades [2] = habilidad3;
        habilidades [3] = habilidad4;
    }

    /*
     * Getter para las habilidades del pokemon
     * @return lista de habilidades y ataques del pokemon
     */
    public Ataque[] getHabilidades() {
        return habilidades;
    }
   
    /*
     * Setter para estado (vivo o no) del pokemon
     * @param estado estado a asignar (true: vivo, false: no vivo)
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
     
    /*
     * Getter para estado (vivo o no) del pokemon
     * @return estado del pokemon (true: vivo, false: no vivo)
     */
    public boolean getEstado() {
        return estado;
    }

    /*
     * Esta función reinicia los puntos de vida del pokemon a su valor inicial (hpReset).
     */
    public void resetHp(){
        this.hp = this.hpReset;
    }
   
    /*
     * Esta función incrementa el nivel del pokemon en 1 y mejora sus stats (en principio, por combate ganado).
     */
    public void subirNivel() {
    setStats(
        this.nivel + 1,
        this.hp + 5,
        this.atq + 15,
        this.def + 5,
        this.velocidad + 5
    );
    System.out.println(nombre + " ha subido al nivel " + this.nivel + "!");
  }

    /*
     * Getter para saber si el pokemon debe mostrarse en el catálogo inicial (sólo funciona para este fin)
     * @return true si el pokemon debe mostrarse, false si ya fue elegido
     */
    public boolean mostrar(){
        return mostrar;
    }

    /*
     * Setter para modificar si el pokemon debe mostrarse en el catálogo inicial (sólo funciona para este fin)
     * @param mostrar true si el pokemon debe mostrarse, false si ya fue elegido
     */
    public void setMostrar(boolean mostrar){
        this.mostrar = mostrar;
    }

    /*
     * Este método devuelve una representación en forma de cadena de texto del objeto Pokemon, incluyendo su nombre, tipo, nivel y stats principales.
     * El objetivo es convertir a texto el objeto para mostrarlo en el catálogo.
     * @return Una cadena de texto que representa al objeto Pokemon con sus características principales.
     */
    @Override
    public String toString() {  //Convertir a texto para mostrar el catalogo
    return String.format("%s (Tipo: %s, Nivel: %d, Vida: %d, Ataque: %d, Defensa: %d, Velocidad: %d)", 
        this.nombre, this.tipo, this.nivel, this.hp, this.atq, this.def, this.velocidad);
}

}

