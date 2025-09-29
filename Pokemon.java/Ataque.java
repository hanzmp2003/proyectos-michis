public class Ataque {
    private String nombre;
    private int poder;
    private String tipo;

    public Ataque() {
        nombre = "";
        poder = 0;
        tipo = "";
    }

    public Ataque(String nombre, int poder, String tipo) {
        this.nombre = nombre;
        this.poder = poder;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPoder() { return poder; }
    public void setPoder(int poder) { this.poder = poder; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}