// Clase Ataque que representa un ataque de un Pokémon
public class Ataque {
    private String nombre;
    private int poder;
    private String tipo;
    private int pp;
    private int ppReset;

    public Ataque() {
        this.nombre = "";
        this.poder = 0;
        this.tipo = "";
        this.pp = 0;
    }

    public Ataque(String nombre, int poder, String tipo, int pp) {
        this.nombre = nombre;
        this.poder = poder;
        this.tipo = tipo;
        this.pp = pp;
        this.ppReset = pp;
    }

    // Constructor para copiar ataques
    public Ataque(Ataque ataque) {
        this.nombre = ataque.nombre;
        this.poder = ataque.poder;
        this.tipo = ataque.tipo;
        this.pp = ataque.pp;
        this.ppReset = ataque.ppReset;
    }

    public void resetPP(){
        this.pp = this.ppReset;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPoder() { return poder; }
    public void setPoder(int poder) { this.poder = poder; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getPp() { return pp; }
    public void setPp(int pp) { this.pp = pp; }
}