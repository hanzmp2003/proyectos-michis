// Clase AgregarEntrenadores que inicializa todos los entrenadores con sus equipos de Pokémon
public class AgregarEntrenadores {
    public Entrenador brittany;
    public Entrenador kimberly;
    public Entrenador brayan;    //variables accesibles 
    public Entrenador kevin;
    public Entrenador byron;
    public Entrenador yandel;
    // Constructor que inicializa todos los entrenadores con sus respectivos equipos de Pokémon
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

    public Entrenador[] getEntrenadores(){
        return entrenadores;
    }

}
