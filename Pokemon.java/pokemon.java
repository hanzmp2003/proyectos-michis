public class Pokemon {    //Método modelo para Pokemon
    private String nombre;
    private int nivel;
    private int hp;
    private int def;
    private int velocidad;
    private String elemento;
    private String[] habilidades;
    private boolean estado;

    public Pokemon() {
        nombre = "";
        elemento = "";
        nivel = 0;
        hp = 0;
        def = 0;
        velocidad = 0;
        estado = true;
        habilidades = new String[4]; 
    }

    // Setters de las Características
    public void setCaracteristicas(String nombre, String elemento) {
        this.nombre = nombre;
        this.elemento = elemento;
    }
    
    // Getters individuales para características
    public String getNombre() {
        return nombre;
    }
    
    public String getElemento() {
        return elemento;
    }
    
    // Setter de Stats
    public void setStats(int nivel, int hp, int def, int velocidad) {
        this.nivel = nivel;
        this.hp = hp;
        this.def = def;
        this.velocidad = velocidad;
    }
    
    // Getters individuales para cada Stat 
    public int getNivel() {
        return nivel;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int getDef() {
        return def;
    }
    
    public int getVelocidad() {
        return velocidad;
    }
    
    // Setter de Habilidades del pokemon 
    public void setHabilidades(String habilidad1, String habilidad2, String habilidad3, String habilidad4) {
        habilidades = new String[4];
        habilidades [0] = habilidad1;
        habilidades [1] = habilidad2;
        habilidades [2] = habilidad3;
        habilidades [3] = habilidad4;
    }

    // Getter de Habilidades
    public String[] getHabilidades() {
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
}
