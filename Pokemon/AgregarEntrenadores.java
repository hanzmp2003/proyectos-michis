/** 
 *  Clase AgregarEntrenadores que inicializa todos los entrenadores con sus equipos de Pokémon
 * 
 * @author Hanz Madrigal Porras, C4G754
   @author Chun Ping Liu Li, C5G492
   @author Emanuel Sancho Sánchez, C07332
   @author Jefferson Emanuel Miranda Sabala, C24874
 
 * @version 1.0
 */

/**
 * En esta clase se declaran cada uno de los entrenadores que habrán en el gimnasio pokemon 
 */

public class AgregarEntrenadores {
    public Entrenador brittany;
    public Entrenador kimberly;
    public Entrenador brayan;    //variables accesibles 
    public Entrenador kevin;
    public Entrenador byron;
    public Entrenador yandel;

    /**Constructor que inicializa todos los entrenadores con sus respectivos equipos de Pokémon
     * se crean los pokemones y se les asigna un entreandor
     * se almacenan para dar acceso 
     */ 
    Entrenador[] entrenadores = new Entrenador[6];
    public AgregarEntrenadores() {
        AgregarPokemon ap = new AgregarPokemon();
        Pokemon[] equipoBrittany = {ap.choripan, ap.salamandra};
        Pokemon[] equipoKimberly = {ap.pejelagarto, ap.tralalerotralala, ap.gokuFaseTerminal};
        Pokemon[] equipoBrayan = {ap.laSaicaTimida, ap.perikiki, ap.machetearrumbradoo};
        Pokemon[] equipoKevin = {ap.perikiki, ap.machetearrumbradoo, ap.ketamina, ap.fentalino};
        Pokemon[] equipoByron = {ap.fentalino, ap.ketamina, ap.coronavirus};
        Pokemon[] equipoYandel = {ap.coronavirus, ap.fourloko, ap.kamakahai, ap.marihuanauta};

        brittany = new Entrenador("Brittany", false, equipoBrittany);
        kimberly = new Entrenador("Kimberly", false, equipoKimberly);
        brayan = new Entrenador("Brayan", false, equipoBrayan);
        kevin = new Entrenador("Kevin", false, equipoKevin);
        byron = new Entrenador("Byron", false, equipoByron);
        yandel = new Entrenador("Yandel", false, equipoYandel);

        entrenadores = new Entrenador[] {brittany,kimberly,brayan,byron,kevin,yandel};

    }
/**
 * Acá se retornará un areglos con los entrenadores
 * @return entrenadores, un arreglo 
 */
    public Entrenador[] getEntrenadores(){
        return entrenadores;
    }

}
