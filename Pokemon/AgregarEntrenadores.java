// Clase AgregarEntrenadores que inicializa todos los entrenadores con sus equipos de Pokémon
public class AgregarEntrenadores {
    // Constructor que inicializa todos los entrenadores con sus respectivos equipos de Pokémon
    Entrenador[] entrenadores = new Entrenador[6];
    public AgregarEntrenadores() {
        Pokemon[] equipoBrittany = {AgregarPokemon.choripan, AgregarPokemon.salamandra};
        Pokemon[] equipoKimberly = {AgregarPokemon.pejelagarto, AgregarPokemon.tralalerotralala, AgregarPokemon.gokuFaseTerminal};
        Pokemon[] equipoBrayan = {AgregarPokemon.laSaicaTimida, AgregarPokemon.perikiki, AgregarPokemon.machetearrumbradoo};
        Pokemon[] equipoKevin = {AgregarPokemon.perikiki, AgregarPokemon.machetearrumbradoo, AgregarPokemon.ketamina, AgregarPokemon.fentalino};
        Pokemon[] equipoByron = {AgregarPokemon.fentalino, AgregarPokemon.ketamina, AgregarPokemon.coronavirus};
        Pokemon[] equipoYandel = {AgregarPokemon.coronavirus, AgregarPokemon.fourloko, AgregarPokemon.kamakahai, AgregarPokemon.marihuanauta};

        Entrenador brittany = new Entrenador("Brittany", false, equipoBrittany);
        Entrenador kimberly = new Entrenador("Kimberly", false, equipoKimberly);
        Entrenador brayan = new Entrenador("Brayan", false, equipoBrayan);
        Entrenador kevin = new Entrenador("Kevin", false, equipoKevin);
        Entrenador byron = new Entrenador("Byron", false, equipoByron);
        Entrenador yandel = new Entrenador("Yandel", false, equipoYandel);

        entrenadores = new Entrenador[] {brittany,kimberly,brayan,byron,kevin,yandel};

    }

    public Entrenador[] getEntrenadores(){
        return entrenadores;
    }

}
