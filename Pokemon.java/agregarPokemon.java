public class AgregarPokemon {

    public static Pokemon choripan;
    public static Pokemon salamandra;
    public static Pokemon pejelagarto;
    public static Pokemon tralalerotralala;
    public static Pokemon laSaicaTimida;
    public static Pokemon gokuFaseTerminal;
    public static Pokemon pericrack;
    public static Pokemon marihuanauta;
    public static Pokemon paracetamol;
    public static Pokemon bazuco;
    public static Pokemon tiaToxica;
    public static Pokemon crackosaurio;
    public static Pokemon fentalino;
    public static Pokemon ketamina;
    public static Pokemon fourloko;
    public static Pokemon clonazemugre;
    public static Pokemon zsmieo;
    public static Pokemon profepasanoselcurso;
    public static Pokemon perikiki;
    public static Pokemon machetearrumbradoo;
    public static Pokemon coronavirus;
    public static Pokemon kamakahai;

    public AgregarPokemon() {

        choripan = new Pokemon();
        choripan.setCaracteristicas("Choripan", "Fuego");
        choripan.setStats(12, 50, 20, 30);
        choripan.setHabilidades(
            AgregarAtaque.asadoArdiente,
            AgregarAtaque.patadaCallejera,
            AgregarAtaque.ladridoBravo,
            AgregarAtaque.fuegoNegro
        );
        choripan.setEstado(true);

        salamandra = new Pokemon();
        salamandra.setCaracteristicas("Salamandra", "Agua");
        salamandra.setStats(15, 60, 25, 40);
        salamandra.setHabilidades(
            AgregarAtaque.llamaHumeda,
            AgregarAtaque.salpicon,
            AgregarAtaque.golpeAcuatico,
            AgregarAtaque.rayoDescontrolado
        );
        salamandra.setEstado(true);

        pejelagarto = new Pokemon();
        pejelagarto.setCaracteristicas("Pejelagarto", "Tierra");
        pejelagarto.setStats(10, 55, 30, 25);
        pejelagarto.setHabilidades(
            AgregarAtaque.mordidaBarrosa,
            AgregarAtaque.colaAfilada,
            AgregarAtaque.aplaston,
            AgregarAtaque.camuflajeAfilado
        );
        pejelagarto.setEstado(true);

        tralalerotralala = new Pokemon();
        tralalerotralala.setCaracteristicas("Tralalerotralala", "Eléctrico");
        tralalerotralala.setStats(18, 45, 15, 50);
        tralalerotralala.setHabilidades(
            AgregarAtaque.rayoDescontrolado,
            AgregarAtaque.patadaLocura,
            AgregarAtaque.chillidoFeroz,
            AgregarAtaque.saltoLoco
        );
        tralalerotralala.setEstado(true);

        laSaicaTimida = new Pokemon();
        laSaicaTimida.setCaracteristicas("La Saica Tímida", "Siniestro");
        laSaicaTimida.setStats(20, 40, 18, 35);
        laSaicaTimida.setHabilidades(
            AgregarAtaque.besoConLengua,
            AgregarAtaque.ojoDeBarrio,
            AgregarAtaque.golpePension,
            AgregarAtaque.huidaViolenta
        );
        laSaicaTimida.setEstado(true);

        gokuFaseTerminal = new Pokemon();
        gokuFaseTerminal.setCaracteristicas("Goku Fase Terminal", "Fuego");
        gokuFaseTerminal.setStats(50, 120, 40, 60);
        gokuFaseTerminal.setHabilidades(
            AgregarAtaque.quimiokameterapia,
            AgregarAtaque.puñoMortal,
            AgregarAtaque.transfusionSangre,
            AgregarAtaque.golpeTeleton
        );
        gokuFaseTerminal.setEstado(true);

        pericrack = new Pokemon();
        pericrack.setCaracteristicas("Pericrack", "Veneno");
        pericrack.setStats(25, 35, 15, 45);
        pericrack.setHabilidades(
            AgregarAtaque.vueloNervioso,
            AgregarAtaque.demeUnaTejita,
            AgregarAtaque.rugidoSaico,
            AgregarAtaque.ataqueViolento
        );
        pericrack.setEstado(true);

        marihuanauta = new Pokemon();
        marihuanauta.setCaracteristicas("Marihuanauta", "Planta");
        marihuanauta.setStats(22, 60, 20, 20);
        marihuanauta.setHabilidades(
            AgregarAtaque.humoVerdeFatal,
            AgregarAtaque.raizCortante,
            AgregarAtaque.abrazoLetal,
            AgregarAtaque.ritmoDestructivo
        );
        marihuanauta.setEstado(true);

        paracetamol = new Pokemon();
        paracetamol.setCaracteristicas("Paracetamol", "Normal");
        paracetamol.setStats(18, 55, 22, 25);
        paracetamol.setHabilidades(
            AgregarAtaque.demeUnaTejita,
            AgregarAtaque.golpeTranquilo,
            AgregarAtaque.patadaFuerte,
            AgregarAtaque.escupitajoArdiente
        );
        paracetamol.setEstado(true);

        bazuco = new Pokemon();
        bazuco.setCaracteristicas("Bazuco", "Fuego");
        bazuco.setStats(30, 45, 20, 40);
        bazuco.setHabilidades(
            AgregarAtaque.explosionCallejera,
            AgregarAtaque.golpeAdiccion,
            AgregarAtaque.fuegoNegro,
            AgregarAtaque.aplastaTodo
        );
        bazuco.setEstado(true);

        tiaToxica = new Pokemon();
        tiaToxica.setCaracteristicas("Tía Tóxica", "Veneno");
        tiaToxica.setStats(28, 50, 18, 35);
        tiaToxica.setHabilidades(
            AgregarAtaque.venenoMortal,
            AgregarAtaque.chancletazoAcido,
            AgregarAtaque.chisme,
            AgregarAtaque.escapeVenenoso
        );
        tiaToxica.setEstado(true);

        crackosaurio = new Pokemon();
        crackosaurio.setCaracteristicas("Crackosaurio", "Roca");
        crackosaurio.setStats(35, 65, 40, 20);
        crackosaurio.setHabilidades(
            AgregarAtaque.mordidaDura,
            AgregarAtaque.aplaston,
            AgregarAtaque.patadaFuerte,
            AgregarAtaque.gritoPiedrero
        );
        crackosaurio.setEstado(true);

        fentalino = new Pokemon();
        fentalino.setCaracteristicas("Fentalino", "Veneno");
        fentalino.setStats(40, 55, 25, 45);
        fentalino.setHabilidades(
            AgregarAtaque.polvoMortal,
            AgregarAtaque.vueloErratico,
            AgregarAtaque.punaladaTraquea,
            AgregarAtaque.escapeRapido
        );
        fentalino.setEstado(true);

        ketamina = new Pokemon();
        ketamina.setCaracteristicas("Ketamina", "Psíquico");
        ketamina.setStats(38, 50, 20, 40);
        ketamina.setHabilidades(
            AgregarAtaque.confusion,
            AgregarAtaque.somnolencia,
            AgregarAtaque.vueloMental,
            AgregarAtaque.ataqueSorpresa
        );
        ketamina.setEstado(true);

        fourloko = new Pokemon();
        fourloko.setCaracteristicas("FourLoko", "Fuego");
        fourloko.setStats(28, 55, 20, 35);
        fourloko.setHabilidades(
            AgregarAtaque.bebidaExplosiva,
            AgregarAtaque.patadaAlcoholica,
            AgregarAtaque.resacaMortal,
            AgregarAtaque.escupitajoArdiente
        );
        fourloko.setEstado(true);

        clonazemugre = new Pokemon();
        clonazemugre.setCaracteristicas("Clonazemugre", "Psíquico");
        clonazemugre.setStats(30, 50, 18, 40);
        clonazemugre.setHabilidades(
            AgregarAtaque.confusionCallejera,
            AgregarAtaque.somnolencia,
            AgregarAtaque.gritoMental,
            AgregarAtaque.ataquePsiquiatrico
        );
        clonazemugre.setEstado(true);

        zsmieo = new Pokemon();
        zsmieo.setCaracteristicas("ZsMieo", "Siniestro");
        zsmieo.setStats(35, 45, 20, 50);
        zsmieo.setHabilidades(
            AgregarAtaque.risaMacabra,
            AgregarAtaque.sustoCallejero,
            AgregarAtaque.patadaSorpresa,
            AgregarAtaque.llanteoSinPlacas
        );
        zsmieo.setEstado(true);

        profepasanoselcurso = new Pokemon();
        profepasanoselcurso.setCaracteristicas("ProfePasanosElCurso", "Normal");
        profepasanoselcurso.setStats(20, 60, 25, 30);
        profepasanoselcurso.setHabilidades(
            AgregarAtaque.tienen100,
            AgregarAtaque.hayQuiz,
            AgregarAtaque.noTengoMonster,
            AgregarAtaque.javaSePara
        );
        profepasanoselcurso.setEstado(true);

        perikiki = new Pokemon();
        perikiki.setCaracteristicas("Perikiki", "Veneno");
        perikiki.setStats(22, 40, 15, 45);
        perikiki.setHabilidades(
            AgregarAtaque.picotazoCallejero,
            AgregarAtaque.vueloNervioso,
            AgregarAtaque.rugidoBarrio,
            AgregarAtaque.escapeRapido
        );
        perikiki.setEstado(true);

        machetearrumbradoo = new Pokemon();
        machetearrumbradoo.setCaracteristicas("MacheteArrumbradoo", "Roca");
        machetearrumbradoo.setStats(40, 70, 45, 20);
        machetearrumbradoo.setHabilidades(
            AgregarAtaque.corteOxidado,
            AgregarAtaque.ataqueMachetazoAbuelo,
            AgregarAtaque.infeccion,
            AgregarAtaque.tetano
        );
        machetearrumbradoo.setEstado(true);

        coronavirus = new Pokemon();
        coronavirus.setCaracteristicas("Coronavirus", "Veneno");
        coronavirus.setStats(50, 60, 30, 40);
        coronavirus.setHabilidades(
            AgregarAtaque.infeccionMasiva,
            AgregarAtaque.tosLetal,
            AgregarAtaque.mutacionRapida,
            AgregarAtaque.cuarentena
        );
        coronavirus.setEstado(true);

        kamakahai = new Pokemon();
        kamakahai.setCaracteristicas("Kamakahai", "Siniestro");
        kamakahai.setStats(38, 55, 25, 45);
        kamakahai.setHabilidades(
            AgregarAtaque.punoDelBarrio,
            AgregarAtaque.rugidoChino,
            AgregarAtaque.sombraErrante,
            AgregarAtaque.escapeSigiloso
        );
        kamakahai.setEstado(true);
    }
}
