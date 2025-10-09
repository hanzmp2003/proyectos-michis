
/**  
 * Clase AgregarAtaque que inicializa todos los ataques disponibles en el juego
 * 
 * @author Hanz Madrigal Porras, C4G754
   @author Chun Ping Liu Li, C5G492
   @author Emanuel Sancho Sánchez, C07332
   @author Jefferson Emanuel Miranda Sabala, C24874

   @version 1.0 
*/

public class AgregarAtaque {

/**
 * Se almacenan los ataques de cada uno de los pokemones y su valor de ataque 
 */
    public static Ataque asadoArdiente = new Ataque("Asado Ardiente", 40, "Fuego", 15);
    public static Ataque patadaCallejera = new Ataque("Patada Callejera", 35, "Lucha", 20);
    public static Ataque ladridoBravo = new Ataque("Ladrido Bravo", 30, "Normal", 25);
    public static Ataque fuegoNegro = new Ataque("Fuego Negro", 50, "Siniestro", 10);

    public static Ataque llamaHumeda = new Ataque("Llama Húmeda", 40, "Agua", 15);
    public static Ataque salpicon = new Ataque("Salpicón", 30, "Planta", 20);
    public static Ataque golpeAcuatico = new Ataque("Golpe Acuático", 45, "Hielo", 15);
    public static Ataque rayoDescontrolado = new Ataque("Rayo Descontrolado", 45, "Eléctrico", 15);

    public static Ataque mordidaBarrosa = new Ataque("Mordida Barrosa", 35, "Tierra", 20);
    public static Ataque colaAfilada = new Ataque("Cola Afilada", 40, "Acero", 15);
    public static Ataque aplaston = new Ataque("Aplastón", 50, "Roca", 10);
    public static Ataque camuflajeAfilado = new Ataque("Camuflaje Afilado", 30, "Fantasma", 20);

    public static Ataque patadaLocura = new Ataque("Patada Locura", 40, "Lucha", 20);
    public static Ataque chillidoFeroz = new Ataque("Chillido Feroz", 35, "Hielo", 20);
    public static Ataque saltoLoco = new Ataque("Salto Loco", 35, "Normal", 20);

    public static Ataque besoConLengua = new Ataque("Beso con Lengua", 30, "Psíquico", 20);
    public static Ataque ojoDeBarrio = new Ataque("Ojo de Barrio", 30, "Siniestro", 20);
    public static Ataque golpePension = new Ataque("Golpe Pensivo", 40, "Veneno", 15);
    public static Ataque huidaViolenta = new Ataque("Huida Violenta", 25, "Fantasma", 20);

    public static Ataque quimiokameterapia = new Ataque("Quimiokameterapia", 50, "Fuego", 10);
    public static Ataque puñoMortal = new Ataque("Puño Mortal", 55, "Lucha", 10);
    public static Ataque transfusionSangre = new Ataque("Transfusión de Sangre", 40, "Psíquico", 15);
    public static Ataque golpeTeleton = new Ataque("Golpe Teletón", 45, "Normal", 15);

    public static Ataque vueloNervioso = new Ataque("Vuelo Nervioso", 35, "Veneno", 20);
    public static Ataque demeUnaTejita = new Ataque("Deme Una Tejita", 30, "Planta", 20);
    public static Ataque rugidoSaico = new Ataque("Rugido Saico", 40, "Veneno", 15);
    public static Ataque ataqueViolento = new Ataque("Ataque Violento", 35, "Acero", 20);

    public static Ataque humoVerdeFatal = new Ataque("Humo Verde Fatal", 30, "Planta", 20);
    public static Ataque raizCortante = new Ataque("Raíz Cortante", 35, "Planta", 20);
    public static Ataque abrazoLetal = new Ataque("Abrazo Letal", 30, "Fantasma", 20);
    public static Ataque ritmoDestructivo = new Ataque("Ritmo Destructivo", 25, "Normal", 15);

    public static Ataque golpeTranquilo = new Ataque("Golpe Tranquilo", 30, "Normal", 20);
    public static Ataque escupitajoArdiente = new Ataque("Escupitajo Ardiente", 25, "Fuego", 20);
    public static Ataque punaladaTraquea = new Ataque("Puñalada Traquea", 45, "Psíquico", 15);
    public static Ataque vueloErratico = new Ataque("Vuelo Errático", 35, "Eléctrico", 20);

    public static Ataque explosionCallejera = new Ataque("Explosión Callejera", 50, "Fuego", 10);
    public static Ataque golpeAdiccion = new Ataque("Golpe Adicción", 45, "Veneno", 15);
    public static Ataque bebidaExplosiva = new Ataque("Bebida Explosiva", 40, "Psíquico", 15);
    public static Ataque patadaAlcoholica = new Ataque("Patada Alcohólica", 35, "Lucha", 20);
    public static Ataque resacaMortal = new Ataque("Resaca Mortal", 45, "Hielo", 15);

    public static Ataque confusión = new Ataque("Confusión", 35, "Psíquico", 20);
    public static Ataque somnolencia = new Ataque("Somnolencia", 30, "Planta", 20);
    public static Ataque vueloMental = new Ataque("Vuelo Mental", 40, "Psíquico", 15);
    public static Ataque ataqueSorpresa = new Ataque("Ataque Sorpresa", 35, "Eléctrico", 20);

    public static Ataque confusionCallejera = new Ataque("Confusión Callejera", 30, "Siniestro", 20);
    public static Ataque gritoMental = new Ataque("Grito Mental", 40, "Psíquico", 15);
    public static Ataque ataquePsiquiatrico = new Ataque("Ataque Psiquiátrico", 45, "Psíquico", 15);

    public static Ataque risaMacabra = new Ataque("Risa Macabra", 35, "Siniestro", 20);
    public static Ataque sustoCallejero = new Ataque("Susto Callejero", 30, "Fantasma", 20);
    public static Ataque patadaSorpresa = new Ataque("Patada Sorpresa", 40, "Lucha", 15);
    public static Ataque llanteoSinPlacas = new Ataque("Llanteo Sin Placas", 25, "Roca", 15);

    public static Ataque tienen100 = new Ataque("Tienen 100", 0, "Normal", 10);
    public static Ataque hayQuiz = new Ataque("Hay Quiz", 0, "Normal", 10);
    public static Ataque noTengoMonster = new Ataque("No Tengo Monster", 0, "Normal", 10);
    public static Ataque javaSePara = new Ataque("Java Se Para", 0, "Acero", 10);

    public static Ataque picotazoCallejero = new Ataque("Picotazo Callejero", 35, "Eléctrico", 20);
    public static Ataque rugidoBarrio = new Ataque("Rugido Barrio", 40, "Normal", 15);
    public static Ataque corteOxidado = new Ataque("Corte Oxidado", 45, "Roca", 15);
    public static Ataque ataqueMachetazoAbuelo = new Ataque("Ataque Machetazo Abuelo", 50, "Lucha", 10);
    public static Ataque infeccion = new Ataque("Infección", 40, "Veneno", 15);
    public static Ataque tetano = new Ataque("Tétano", 35, "Veneno", 20);

    public static Ataque infeccionMasiva = new Ataque("Infección Masiva", 50, "Veneno", 10);
    public static Ataque tosLetal = new Ataque("Tos Letal", 45, "Normal", 15);
    public static Ataque mutacionRapida = new Ataque("Mutación Rápida", 40, "Psíquico", 15);
    public static Ataque cuarentena = new Ataque("Cuarentena", 35, "Acero", 20);

    public static Ataque punoDelBarrio = new Ataque("Puño Del Barrio", 40, "Lucha", 15);
    public static Ataque rugidoChino = new Ataque("Rugido Chino", 35, "Normal", 20);
    public static Ataque sombraErrante = new Ataque("Sombra Errante", 45, "Fantasma", 15);
    public static Ataque escapeSigiloso = new Ataque("Escape Sigiloso", 30, "Fantasma", 20);
}
