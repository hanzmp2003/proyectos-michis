// Clase AgregarLideres que inicializa todos los líderes de gimnasio con sus equipos de Pokémon
public class AgregarLideres {
    Lideres juankiloco;
    Lideres porcionzon;
    Lideres chunche;
    public Lideres[] listaLideres;
    // Constructor que inicializa todos los líderes con sus respectivos equipos de Pokémon
    public AgregarLideres() {
        AgregarPokemon ap = new AgregarPokemon();
        listaLideres = new Lideres[3];
        // Líder 1: El Juankiloco -> 3 Pokémon, tipo Siniestro
        juankiloco = new Lideres("El Juankiloco", 50, "Siniestro");
        juankiloco.listaPokemones[0] = ap.kamakahai;
        juankiloco.listaPokemones[1] = ap.zsmieo;
        juankiloco.listaPokemones[2] = ap.fentalino;

        // Líder 2: El Porcionzón -> 4 Pokémon, tipo Roca
        porcionzon = new Lideres("El Porcionzón", 75, "Roca");
        porcionzon.listaPokemones[0] = ap.crackosaurio;
        porcionzon.listaPokemones[1] = ap.machetearrumbradoo;
        porcionzon.listaPokemones[2] = ap.pejelagarto;
        porcionzon.listaPokemones[3] = ap.choripan;

        // Líder 3: El Chunche -> 5 Pokémon, tipo Veneno
        chunche = new Lideres("El Chunche", 100, "Veneno");
        chunche.listaPokemones[0] = ap.perikiki;
        chunche.listaPokemones[1] = ap.ketamina;
        chunche.listaPokemones[2] = ap.marihuanauta;
        chunche.listaPokemones[3] = ap.bazuco;
        chunche.listaPokemones[4] = ap.paracetamol;

        listaLideres[0] = juankiloco;
        listaLideres[1] = porcionzon;
        listaLideres[2] = chunche;
    }

    public Lideres[] lideres(){
        return listaLideres;
    }

}
