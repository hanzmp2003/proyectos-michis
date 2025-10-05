// Clase AgregarPokemon que inicializa todos los Pokémon disponibles en el juego
import java.util.Random;
public class AgregarPokemon {

    public Pokemon choripan;
    public Pokemon salamandra;
    public Pokemon pejelagarto;
    public Pokemon tralalerotralala;
    public Pokemon laSaicaTimida;
    public Pokemon gokuFaseTerminal;
    public Pokemon pericrack;
    public Pokemon marihuanauta;
    public Pokemon paracetamol;
    public Pokemon bazuco;
    public Pokemon tiaToxica;
    public Pokemon crackosaurio;
    public Pokemon fentalino;
    public Pokemon ketamina;
    public Pokemon fourloko;
    public Pokemon clonazemugre;
    public Pokemon zsmieo;
    public Pokemon profepasanoselcurso;
    public Pokemon perikiki;
    public Pokemon machetearrumbradoo;
    public Pokemon coronavirus;
    public Pokemon kamakahai;
    public Pokemon[] catalogo;
    public Pokemon[] catalogoEleccion;

    // Constructor que inicializa todos los Pokémon con sus características, stats y ataques

    public AgregarPokemon() {

        choripan = new Pokemon();
        choripan.setCaracteristicas("Choripan", "Fuego");
        choripan.setStats(12, 50, 22, 30, 28);
        choripan.setHabilidades(
            AgregarAtaque.asadoArdiente,
            AgregarAtaque.patadaCallejera,
            AgregarAtaque.ladridoBravo,
            AgregarAtaque.fuegoNegro
        );
        choripan.setEstado(true);

        salamandra = new Pokemon();
        salamandra.setCaracteristicas("Salamandra", "Agua");
        salamandra.setStats(15, 60, 25, 40, 32);
        salamandra.setHabilidades(
            AgregarAtaque.llamaHumeda,
            AgregarAtaque.salpicon,
            AgregarAtaque.golpeAcuatico,
            AgregarAtaque.rayoDescontrolado
        );
        salamandra.setEstado(true);

        pejelagarto = new Pokemon();
        pejelagarto.setCaracteristicas("Pejelagarto", "Tierra");
        pejelagarto.setStats(10, 55, 28, 25, 24);
        pejelagarto.setHabilidades(
            AgregarAtaque.mordidaBarrosa,
            AgregarAtaque.colaAfilada,
            AgregarAtaque.aplaston,
            AgregarAtaque.camuflajeAfilado
        );
        pejelagarto.setEstado(true);

        tralalerotralala = new Pokemon();
        tralalerotralala.setCaracteristicas("Tralalerotralala", "Eléctrico");
        tralalerotralala.setStats(18, 45, 18, 20, 50);
        tralalerotralala.setHabilidades(
            AgregarAtaque.rayoDescontrolado,
            AgregarAtaque.patadaLocura,
            AgregarAtaque.chillidoFeroz,
            AgregarAtaque.saltoLoco
        );
        tralalerotralala.setEstado(true);

        laSaicaTimida = new Pokemon();
        laSaicaTimida.setCaracteristicas("La Saica Tímida", "Psíquico");
        laSaicaTimida.setStats(20, 40, 20, 18, 35);
        laSaicaTimida.setHabilidades(
            AgregarAtaque.besoConLengua,
            AgregarAtaque.ojoDeBarrio,
            AgregarAtaque.golpePension,
            AgregarAtaque.huidaViolenta
        );
        laSaicaTimida.setEstado(true);

        gokuFaseTerminal = new Pokemon();
        gokuFaseTerminal.setCaracteristicas("Goku Fase Terminal", "Fuego");
        gokuFaseTerminal.setStats(50, 120, 45, 40, 55);
        gokuFaseTerminal.setHabilidades(
            AgregarAtaque.quimiokameterapia,
            AgregarAtaque.puñoMortal,
            AgregarAtaque.transfusionSangre,
            AgregarAtaque.golpeTeleton
        );
        gokuFaseTerminal.setEstado(true);

        pericrack = new Pokemon();
        pericrack.setCaracteristicas("Pericrack", "Veneno");
        pericrack.setStats(25, 35, 15, 18, 45);
        pericrack.setHabilidades(
            AgregarAtaque.vueloNervioso,
            AgregarAtaque.demeUnaTejita,
            AgregarAtaque.rugidoSaico,
            AgregarAtaque.ataqueViolento
        );
        pericrack.setEstado(true);

        marihuanauta = new Pokemon();
        marihuanauta.setCaracteristicas("Marihuanauta", "Planta");
        marihuanauta.setStats(22, 60, 24, 25, 20);
        marihuanauta.setHabilidades(
            AgregarAtaque.humoVerdeFatal,
            AgregarAtaque.raizCortante,
            AgregarAtaque.abrazoLetal,
            AgregarAtaque.ritmoDestructivo
        );
        marihuanauta.setEstado(true);

        paracetamol = new Pokemon();
        paracetamol.setCaracteristicas("Paracetamol", "Hielo");
        paracetamol.setStats(18, 55, 22, 22, 25);
        paracetamol.setHabilidades(
            AgregarAtaque.demeUnaTejita,
            AgregarAtaque.golpeTranquilo,
            AgregarAtaque.abrazoLetal,
            AgregarAtaque.escupitajoArdiente
        );
        paracetamol.setEstado(true);

        bazuco = new Pokemon();
        bazuco.setCaracteristicas("Bazuco", "Siniestro");
        bazuco.setStats(30, 45, 26, 20, 40);
        bazuco.setHabilidades(
            AgregarAtaque.explosionCallejera,
            AgregarAtaque.golpeAdiccion,
            AgregarAtaque.fuegoNegro,
            AgregarAtaque.ojoDeBarrio
        );
        bazuco.setEstado(true);

        tiaToxica = new Pokemon();
        tiaToxica.setCaracteristicas("Tía Tóxica", "Eléctrico");
        tiaToxica.setStats(28, 50, 20, 18, 35);
        tiaToxica.setHabilidades(
            AgregarAtaque.golpePension,
            AgregarAtaque.fuegoNegro,
            AgregarAtaque.aplaston,
            AgregarAtaque.explosionCallejera
        );
        tiaToxica.setEstado(true);

        crackosaurio = new Pokemon();
        crackosaurio.setCaracteristicas("Crackosaurio", "Roca");
        crackosaurio.setStats(35, 65, 40, 35, 20);
        crackosaurio.setHabilidades(
            AgregarAtaque.mutacionRapida,
            AgregarAtaque.aplaston,
            AgregarAtaque.punoDelBarrio,
            AgregarAtaque.sombraErrante
        );
        crackosaurio.setEstado(true);

        fentalino = new Pokemon();
        fentalino.setCaracteristicas("Fentalino", "Fantasma");
        fentalino.setStats(40, 55, 28, 22, 45);
        fentalino.setHabilidades(
            AgregarAtaque.punoDelBarrio,
            AgregarAtaque.vueloErratico,
            AgregarAtaque.punaladaTraquea,
            AgregarAtaque.vueloMental
        );
        fentalino.setEstado(true);

        ketamina = new Pokemon();
        ketamina.setCaracteristicas("Ketamina", "Psíquico");
        ketamina.setStats(38, 50, 20, 20, 40);
        ketamina.setHabilidades(
            AgregarAtaque.rugidoBarrio,
            AgregarAtaque.somnolencia,
            AgregarAtaque.vueloMental,
            AgregarAtaque.ataqueSorpresa
        );
        ketamina.setEstado(true);

        fourloko = new Pokemon();
        fourloko.setCaracteristicas("FourLoko", "Hielo");
        fourloko.setStats(28, 55, 24, 20, 35);
        fourloko.setHabilidades(
            AgregarAtaque.bebidaExplosiva,
            AgregarAtaque.patadaAlcoholica,
            AgregarAtaque.resacaMortal,
            AgregarAtaque.escupitajoArdiente
        );
        fourloko.setEstado(true);

        clonazemugre = new Pokemon();
        clonazemugre.setCaracteristicas("Clonazemugre", "Fantasma");
        clonazemugre.setStats(30, 50, 22, 18, 40);
        clonazemugre.setHabilidades(
            AgregarAtaque.confusionCallejera,
            AgregarAtaque.somnolencia,
            AgregarAtaque.gritoMental,
            AgregarAtaque.ataquePsiquiatrico
        );
        clonazemugre.setEstado(true);

        zsmieo = new Pokemon();
        zsmieo.setCaracteristicas("ZsMieo", "Fantasma");
        zsmieo.setStats(35, 45, 25, 20, 50);
        zsmieo.setHabilidades(
            AgregarAtaque.risaMacabra,
            AgregarAtaque.sustoCallejero,
            AgregarAtaque.patadaSorpresa,
            AgregarAtaque.llanteoSinPlacas
        );
        zsmieo.setEstado(true);

        profepasanoselcurso = new Pokemon();
        profepasanoselcurso.setCaracteristicas("ProfePasanosElCurso", "Normal");
        profepasanoselcurso.setStats(20, 60, 25, 25, 30);
        profepasanoselcurso.setHabilidades(
            AgregarAtaque.tienen100,
            AgregarAtaque.hayQuiz,
            AgregarAtaque.noTengoMonster,
            AgregarAtaque.javaSePara
        );
        profepasanoselcurso.setEstado(true);

        perikiki = new Pokemon();
        perikiki.setCaracteristicas("Perikiki", "Eléctrico");
        perikiki.setStats(22, 40, 15, 15, 45);
        perikiki.setHabilidades(
            AgregarAtaque.picotazoCallejero,
            AgregarAtaque.vueloNervioso,
            AgregarAtaque.rugidoBarrio,
            AgregarAtaque.tosLetal
        );
        perikiki.setEstado(true);

        machetearrumbradoo = new Pokemon();
        machetearrumbradoo.setCaracteristicas("MacheteArrumbradoo", "Roca");
        machetearrumbradoo.setStats(40, 70, 45, 40, 20);
        machetearrumbradoo.setHabilidades(
            AgregarAtaque.corteOxidado,
            AgregarAtaque.ataqueMachetazoAbuelo,
            AgregarAtaque.infeccion,
            AgregarAtaque.tetano
        );
        machetearrumbradoo.setEstado(true);

        coronavirus = new Pokemon();
        coronavirus.setCaracteristicas("Coronavirus", "Veneno");
        coronavirus.setStats(50, 60, 35, 30, 40);
        coronavirus.setHabilidades(
            AgregarAtaque.infeccionMasiva,
            AgregarAtaque.tosLetal,
            AgregarAtaque.mutacionRapida,
            AgregarAtaque.cuarentena
        );
        coronavirus.setEstado(true);

        kamakahai = new Pokemon();
        kamakahai.setCaracteristicas("Kamakahai", "Hada");
        kamakahai.setStats(38, 55, 28, 25, 45);
        kamakahai.setHabilidades(
            AgregarAtaque.punoDelBarrio,
            AgregarAtaque.rugidoChino,
            AgregarAtaque.sombraErrante,
            AgregarAtaque.escapeSigiloso
        );
        kamakahai.setEstado(true);

        catalogo = new Pokemon[] {
            choripan, salamandra, pejelagarto, tralalerotralala, laSaicaTimida,
            gokuFaseTerminal, pericrack, marihuanauta, paracetamol, bazuco,
            tiaToxica, crackosaurio, fentalino, ketamina, fourloko,
            clonazemugre, zsmieo, profepasanoselcurso, perikiki, machetearrumbradoo,
            coronavirus, kamakahai
        };
    }

    public Pokemon[] catalogoEleccion(){
        int iteracion = 0;
        Random rand = new Random();
        int max = 7 + rand.nextInt(22 - 7 + 1);
        int min = max - 7;
        Pokemon[] nuevoCatalogo = new Pokemon[7];
        for (int i = min ; i < max ; i++) {
            nuevoCatalogo[iteracion] = catalogo[i];
            iteracion += 1;
        }
        this.catalogoEleccion = nuevoCatalogo;
        return this.catalogoEleccion;
    }
}
