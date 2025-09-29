public class AgregarLideres {
    public AgregarLideres() {
        // Líder 1: El Juankiloco -> 3 Pokémon, tipo Siniestro
        Lideres juankiloco = new Lideres("El Juankiloco", 50, "Siniestro");
        juankiloco.listaPokemones[0] = kamakahai;
        juankiloco.listaPokemones[1] = zsmieo;
        juankiloco.listaPokemones[2] = fentalino;

        // Líder 2: El Porcionzón -> 4 Pokémon, tipo Roca
        Lideres porcionzon = new Lideres("El Porcionzón", 75, "Roca");
        porcionzon.listaPokemones[0] = crackosaurio;
        porcionzon.listaPokemones[1] = machetearrumbradoo;
        porcionzon.listaPokemones[2] = pejelagarto;
        porcionzon.listaPokemones[3] = choripan;

        // Líder 3: El Chunche -> 5 Pokémon, tipo Veneno
        Lideres chunche = new Lideres("El Chunche", 100, "Veneno");
        chunche.listaPokemones[0] = perikiki;
        chunche.listaPokemones[1] = ketamina;
        chunche.listaPokemones[2] = marihuanauta;
        chunche.listaPokemones[3] = bazuco;
        chunche.listaPokemones[4] = paracetamol;
    }
}
