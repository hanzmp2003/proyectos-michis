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

    // Constructor pokemon para copiarlo
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

    // Setters de las Características
    public void setCaracteristicas(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    // Getters individuales para características
    public String getNombre() {
        return nombre;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    // Setter de Stats
    public void setStats(int nivel, int hp, int atq, int def, int velocidad) {
        this.nivel = nivel;
        this.hp = hp;
        this.atq = atq;
        this.def = def;
        this.velocidad = velocidad;
        this.hpReset = hp;
    }
    
    public void setAtaque(){
        int suma = 0;
        for (int i = 0; i < habilidades.length; i++) {
            suma += habilidades[i].getPoder();
        }
        this.ataque = (int) Math.round(suma / habilidades.length); // Devuelve el entero más grande menor que el promedio
    }

    public int getAtaque(){
        return ataque;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    // Getters individuales para cada Stat 
    public int getNivel() {
        return nivel;
    }
    
    public int getHp() {
        return hp;
    }

    public int getAtq(){
        return atq;
    }
    
    public int getDef() {
        return def;
    }
    
    public int getVelocidad() {
        return velocidad;
    }
    
    // Setter de Habilidades del pokemon 
    public void setHabilidades(Ataque habilidad1, Ataque habilidad2, Ataque habilidad3, Ataque habilidad4) {
        habilidades = new Ataque[4];
        habilidades [0] = habilidad1;
        habilidades [1] = habilidad2;
        habilidades [2] = habilidad3;
        habilidades [3] = habilidad4;
    }

    // Getter de Habilidades
    public Ataque[] getHabilidades() {
        return habilidades;
    }
   
    // Setter para estado
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
     
    // Getter para estado
    public boolean getEstado() {
        return estado;
    }

    public void resetHp(){
        this.hp = this.hpReset;
    }
   
    //sube de nivel cuando gana una batalla
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

    public boolean mostrar(){
        return mostrar;
    }

    public void setMostrar(boolean mostrar){
        this.mostrar = mostrar;
    }

    public String toString() {  //Convertir a texto para mostrar el catalogo
    return String.format("%s (Tipo: %s, Nivel: %d, Vida: %d, Ataque: %d, Defensa: %d, Velocidad: %d)", 
        this.nombre, this.tipo, this.nivel, this.hp, this.atq, this.def, this.velocidad);
}

}

