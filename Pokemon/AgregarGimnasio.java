public class AgregarGimnasio {
    public AgregarGimnasio() {
        // Instancias de gimnasios bien chatas
        Gimnasio laJungla = new Gimnasio("La Jungla del Precario", "Fácil");
        Gimnasio elBunker = new Gimnasio("El Búnker de los Chatas", "Intermedio");
        Gimnasio LosTigres = new Gimnasio("Los Tigres del Guarco", "Difícil");
    }

 // Imprime los nombres de los gimansios
    public void mostrarGimnasio(Gimnasio nombre){
    System.out.println("Gimnasio: " + nombre.getNombre() + " | Nivel: " + nombre.getNivel());
    }

}