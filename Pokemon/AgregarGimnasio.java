public class AgregarGimnasio {
    Gimnasio laJungla;
    Gimnasio elBunker;
    Gimnasio LosTigres; 

    public AgregarGimnasio() {
        // Instancias de gimnasios bien chatas
        laJungla = new Gimnasio("La Jungla del Precario", "Fácil");
        elBunker = new Gimnasio("El Búnker de los Chatas", "Intermedio");
        LosTigres = new Gimnasio("Los Tigres del Guarco", "Difícil");
    }

 // Imprime los nombres de los gimansios
    public void MostrarGimnasio(Gimnasio nombre, Entrenador entrenador1, Entrenador entrenador2, Lideres lider){
    System.out.println("Gimnasio: " + nombre.getNombre() + " | Nivel: " + nombre.getNivel());
    System.out.println("Rivales: ");
    MostrarRivales(entrenador1, entrenador2, lider);
    }
// Ver información de los rivales que hay en el gimnasio
    public void MostrarRivales(Entrenador entrenador1, Entrenador entrenador2, Lideres lider ){
        for (int i = 0; i < 3; i++) {
        System.out.printf("%d) ", i + 1);
        if (i == 0) {
            System.out.println("Entrenador 1: " + entrenador1.getNombre());
            mostrarEquipo(entrenador1.getEquipo());
        } else if (i == 1) {
            System.out.println("Entrenador 2: " + entrenador2.getNombre());
            mostrarEquipo(entrenador2.getEquipo());
        } else if (i == 2) {
            System.out.println("Líder: " + lider.getNombre());
            mostrarEquipo(lider.getEquipo());
        }

        }
    }
    public void mostrarEquipo(Pokemon[] equipo) {
    for (Pokemon p : equipo) {
        System.out.println("   - " + p.getNombre());
    }

  }
}


