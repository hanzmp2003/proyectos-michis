// Clase Lideres que representa un líder de gimnasio con su nombre, nivel, elemento y lista de Pokémon

import java.util.Random;

public class Lideres{
    public String nombre;
    public int nivel;
    public String elemento;
     private Pokemon[] equipo;
    public Pokemon[] listaPokemones;
    public boolean estado;

    public Lideres(String nombre, int nivel, String elemento, Pokemon[] equipo){
        this.nombre = nombre;
        this.nivel = nivel;
        this.elemento = elemento;
        this.equipo = equipo;
        this.estado = true;
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

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public boolean getEstado(){
        return estado;
    }

    public void setElemento(String elemento){
        this.elemento = elemento;
    }

    public String getElemento(){
        return elemento;
    }


    public void reiniciarEstadisticas(){
        for (Pokemon i : listaPokemones){
            i.resetHp();
            i.setEstado(true);
            for (Ataque j : i.getHabilidades()) {
                j.resetPP();
            }
        }
    }

    public int npcElige(){
        int cerrarElegir = 0;
        int seleccionNPC = 0;
        for (int i = 0 ; i < listaPokemones.length && cerrarElegir < 1 ; i++){
            if (listaPokemones[i].getEstado()){
                seleccionNPC = i;
                cerrarElegir++;
            }
        }
        return seleccionNPC;
    }

    public int ataqueNPC(Pokemon pokemon){
        int seleccion = 0; 
        Random rand = new Random();
        int posicion = 0;
        int tamaño = 0;
        for (Ataque a : pokemon.getHabilidades()) {
            if (a.getPp()>0){
                tamaño += 1;
            }
        }

        Ataque[] atqdis = new Ataque[tamaño];
        int aleatorio = rand.nextInt(tamaño);

        for (int i = 0; i < pokemon.getHabilidades().length ; i ++){
            if (pokemon.getHabilidades()[i].getPp() > 0){
                atqdis[posicion] = pokemon.getHabilidades()[i];
                posicion += 1;
            }
        }

        for (int j = 0; j < pokemon.getHabilidades().length;j++){
            if (atqdis[aleatorio] == pokemon.getHabilidades()[j]){
                seleccion = j;
            }
        }
        if (tamaño > 0){
            return seleccion;
        } else {
            return -1;
        }  
    }

     public Pokemon[] getEquipo() { 
        return equipo; 
        }

    public void setEquipo(Pokemon[] equipo) { 
        this.equipo = equipo; 
        }
}

