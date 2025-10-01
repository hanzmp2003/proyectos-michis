public class Combate {
    Jugador jugador;
    Entrenador entrenador;

    public Combate(Jugador jugador, Entrenador entrenador) {
        this.jugador = jugador;
        this.entrenador = entrenador;
    }

    public void iniciarCombate() {
        System.out.println("¡El combate entre " + jugador.getNombre() + " y " + entrenador.getNombre() + " ha comenzado!");
        // Aquí pondrías la lógica del combate
    }
}
