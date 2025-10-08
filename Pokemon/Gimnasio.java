// Clase Gimnasio que representa un gimnasio con su nombre, tipo y nivel
public class Gimnasio {
    private String nombre;
    private String dificultad;  // Es para mencionar si es facil, intermedio o díficil
    private Entrenador[] entrenadores;
    private Lideres lider;

    // Constructor con parámetros
    public Gimnasio(String nombre, String dificultad) {
    AgregarLideres objetoLid = new AgregarLideres();
    AgregarEntrenadores objetoEnt = new AgregarEntrenadores();
    this.nombre = nombre;
    this.dificultad = dificultad;

    switch (nombre) {
        case "La Jungla del Precario":
            this.entrenadores = new Entrenador[]{objetoEnt.brittany, objetoEnt.kimberly};
            this.lider = objetoLid.juankiloco;
            break;
        case "Monte del Porcionzón":
            this.entrenadores = new Entrenador[]{objetoEnt.brayan, objetoEnt.byron};
            this.lider = objetoLid.porcionzon;
            break;
        case "Cueva del Chunche":
            this.entrenadores = new Entrenador[]{objetoEnt.kevin, objetoEnt.yandel};
            this.lider = objetoLid.chunche;
            break;
        default:
            this.entrenadores = new Entrenador[0];
            this.lider = new Lideres("Líder desconocido", 1, "Normal", new Pokemon[0]);
            break;
        }
   }


    // Getters y setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setNivel(String nivel) { this.dificultad = nivel; }

    public void setRivales(Lideres lider, Entrenador entrenador1, Entrenador entrenador2){
        this.lider = lider;
        this.entrenadores = new Entrenador[] {entrenador1, entrenador2};
    }

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
        System.out.printf("\n%d) %s", contador, i.getNombre());
        if (!i.getEstado())
            System.out.printf("  ----> Ha sido derrotado");
        contador++;
    }

    // Mostrar al líder solo una vez al final
    if (lider != null) {
        System.out.printf("\n%d) (LIDER) %s", contador, lider.getNombre());
        if (!lider.getEstado()) {
            System.out.printf("  ----> Ha sido derrotado");
        }
        System.out.println();
        }
    }
}
