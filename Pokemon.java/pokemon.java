public class Pokemon {    //Método modelo para Pokemon
    private String nombre;
    private int nivel;
    private int hp;
    private int atq;
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

}

