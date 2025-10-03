// Clase Lideres que representa un líder de gimnasio con su nombre, nivel, elemento y lista de Pokémon
public class Lideres{
    public String nombre;
    public int nivel;
    public String elemento;
    public Pokemon[] listaPokemones;

    public Lideres(String nombre, int nivel, String elemento){
        this.nombre = nombre;
        this.nivel = nivel;
        this.elemento = elemento;
        this.listaPokemones = new Pokemon[6];

    }
     
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public int getNivel(){
        return nivel;
    }

    public void setElemento(String elemento){
        this.elemento = elemento;
    }

    public String getElemento(){
        return elemento;
    }

    public Pokemon[] getEquipo() {
        return listaPokemones;
    }
}

