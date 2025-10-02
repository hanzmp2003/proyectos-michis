// Clase AgregarLideres que inicializa todos los líderes de gimnasio con sus equipos de Pokémon
public class AgregarLideres {
    public Lideres[] listaLideres;
    // Constructor que inicializa todos los líderes con sus respectivos equipos de Pokémon
    public AgregarLideres() {
        listaLideres = new Lideres[3];
        // Líder 1: El Juankiloco -> 3 Pokémon, tipo Siniestro
        Lideres juankiloco = new Lideres("El Juankiloco", 50, "Siniestro");
        juankiloco.listaPokemones[0] = AgregarPokemon.kamakahai;
        juankiloco.listaPokemones[1] = AgregarPokemon.zsmieo;
        juankiloco.listaPokemones[2] = AgregarPokemon.fentalino;

        // Líder 2: El Porcionzón -> 4 Pokémon, tipo Roca
        Lideres porcionzon = new Lideres("El Porcionzón", 75, "Roca");
        porcionzon.listaPokemones[0] = AgregarPokemon.crackosaurio;
        porcionzon.listaPokemones[1] = AgregarPokemon.machetearrumbradoo;
        porcionzon.listaPokemones[2] = AgregarPokemon.pejelagarto;
        porcionzon.listaPokemones[3] = AgregarPokemon.choripan;

        // Líder 3: El Chunche -> 5 Pokémon, tipo Veneno
        Lideres chunche = new Lideres("El Chunche", 100, "Veneno");
        chunche.listaPokemones[0] = AgregarPokemon.perikiki;
        chunche.listaPokemones[1] = AgregarPokemon.ketamina;
        chunche.listaPokemones[2] = AgregarPokemon.marihuanauta;
        chunche.listaPokemones[3] = AgregarPokemon.bazuco;
        chunche.listaPokemones[4] = AgregarPokemon.paracetamol;

        listaLideres[0] = juankiloco;
        listaLideres[1] = porcionzon;
        listaLideres[2] = chunche;
    }
}
