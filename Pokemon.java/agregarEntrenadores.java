public class AgregarEntrenadores {
    public AgregarEntrenadores() {
        Pokemon[] equipoBrittany = {choripan, salamandra};
        Pokemon[] equipoKimberly = {pejelagarto, tralalerotralala, gokuFaseTerminal};
        Pokemon[] equipoBrayan = {laSaicaTimida, perikiki, machetearrumbradoo};
        Pokemon[] equipoKevin = {perikiki, machetearrumbradoo, ketamina, fentalino};
        Pokemon[] equipoByron = {fentalino, ketamina, coronavirus};
        Pokemon[] equipoYandel = {coronavirus, fourloko, kamakahai, marihuanauta};

        Entrenador brittany = new Entrenador("Brittany", false, equipoBrittany);
        Entrenador kimberly = new Entrenador("Kimberly", false, equipoKimberly);
        Entrenador brayan = new Entrenador("Brayan", false, equipoBrayan);
        Entrenador kevin = new Entrenador("Kevin", false, equipoKevin);
        Entrenador byron = new Entrenador("Byron", false, equipoByron);
        Entrenador yandel = new Entrenador("Yandel", false, equipoYandel);
    }
}
