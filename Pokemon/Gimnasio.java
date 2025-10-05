// Clase Gimnasio que representa un gimnasio con su nombre, tipo y nivel
public class Gimnasio {
    private String nombre;
    private String dificultad;  // Es para mencionar si es facil, intermedio o díficil
    private Entrenador[] entrenadores;
    private Lideres lider;

    // Constructor con parámetros
    public Gimnasio(String nombre, String dificultad) {

        AgregarEntrenadores objetoEnt = new AgregarEntrenadores();
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.entrenadores = objetoEnt.getEntrenadores();

    }

    // Getters y setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setNivel(String nivel) { this.dificultad = nivel; }

    public String getNombre() { return nombre; }
    public String getNivel() { return dificultad; } 

    public Lideres getLider(){
        return lider;
    }

    public Entrenador[] entrenadores(){
        return entrenadores;
    }
    
    public void verOponentes(){ 
        int contador = 1;
        for (Entrenador i : entrenadores){
            System.out.printf("\n%d) %s",contador,i.getNombre());
            if (!i.getEstado())
                System.out.printf("  ----> Ha sido derrotado");
            if (contador % 2 == 0) {
                contador++;
                System.out.printf("\n%d) (LIDER) %s",contador,lider.getNombre());
                if (lider.getEstado()) {
                    System.out.printf("  ----> Ha sido derrotado");
                }
                System.out.println();
            }
            contador++;
        }
    }
}
