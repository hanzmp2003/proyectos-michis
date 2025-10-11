/**  
 * Clase AgregarLideres que inicializa todos los líderes de gimnasio con sus equipos de Pokémon
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Chun Ping Liu Li, C5G492
 * @author Emanuel Sancho Sánchez, C07332
 * @author Jefferson Emanuel Miranda Sabala, C24874
 *
 *  @version 1.0 
*/

public class AgregarLideres {
    Lideres juankiloco;
    Lideres porcionzon;
    Lideres chunche;
    
/**
 * Constructor que inicializa todos los líderes de gimnasio con sus respectivos equipos de Pokémon.
 */
    public AgregarLideres() {
        AgregarPokemon ap = new AgregarPokemon();
        // Líder 1: El Juankiloco -> 3 Pokémon, tipo Siniestro
        Pokemon[] equipoJuankiloco = {ap.kamakahai, ap.zsmieo, ap.fentalino};
        juankiloco = new Lideres("El Juankiloco", 50, "Siniestro", equipoJuankiloco);

        // Líder 2: El Porcionzón -> 4 Pokémon, tipo Roca
        Pokemon[] equipoPorcionzon = {ap.crackosaurio, ap.machetearrumbradoo, ap.pejelagarto, ap.choripan};
        porcionzon = new Lideres("El Porcionzón", 75, "Roca", equipoPorcionzon);

        // Líder 3: El Chunche -> 5 Pokémon, tipo Veneno
        Pokemon[] equipoChunche = {ap.perikiki, ap.ketamina, ap.marihuanauta, ap.bazuco, ap.paracetamol};
        chunche = new Lideres("El Chunche", 100, "Veneno", equipoChunche);
        
    } 

}
