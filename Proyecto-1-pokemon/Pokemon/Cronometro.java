/** 
 * Clase Cronometro: permite medir el tiempo transcurrido en cada batalla Pokemon.
 * Proporciona métodos para iniciar, detener, reiniciar y obtener el tiempo formateado.
 * El tiempo se mide inicialmente en milisegundos, luego se formatea.
 * 
 * @author Hanz Madrigal Porras, C4G754
 * @author Chun Ping Liu Li, C5G492
 * @author Emanuel Sancho Sánchez, C07332
 * @author Jefferson Emanuel Miranda Sabala, C24874
 
 * @version 1.0
 */


public class Cronometro { 
    private long inicio;
    private long fin;
    private boolean enMarcha;
    /**
     * Inicia el cronómetro desde el momento actual.
     * Si ya estaba en marcha, sobrescribe el tiempo de inicio.
     */
    public void iniciar() {
        inicio = System.currentTimeMillis();
        enMarcha = true;
    }

    /**
     * Detiene el cronómetro y guarda el tiempo final.
     * Solo tiene efecto si el cronómetro estaba en marcha.
     */
    public void detener() {
        if (enMarcha) {
            fin = System.currentTimeMillis();
            enMarcha = false;
        }
    }

   /**
     * Reinicia el cronómetro, borrando los tiempos de inicio y fin.
     * El cronómetro queda detenido.
     */
    public void reiniciar() {
        inicio = 0;
        fin = 0;
        enMarcha = false;
    }

    /**
     * Un getter del tiempo transcurrido en milisegundos.
     * Si el cronómetro está en marcha, se calcula desde el inicio hasta el momento actual.
     * Si está detenido, se calcula desde el inicio hasta el fin.
     *
     * @return tiempo transcurrido en milisegundos
     */
    private long getTiempoTranscurrido() {
        if (enMarcha) {
            return System.currentTimeMillis() - inicio;
        } else {
            return fin - inicio;
        }
    }

    /**
     * Utiliza el tiempo transcurrido en milisegundos y lo formatea en Horas : Minutos : Segundos
     * @return devuelve una cadena con el tiempo formateado
     */

    public String getTiempoFormateado() {
        long tiempo = getTiempoTranscurrido() / 1000; 
        long horas = tiempo / 3600;
        long minutos = (tiempo % 3600) / 60;
        long segundos = tiempo % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}
    
