public class Cronometro { 
    private long inicio;
    private long fin;
    private boolean enMarcha;

    // Inicia el cronómetro
    public void iniciar() {
        inicio = System.currentTimeMillis();
        enMarcha = true;
    }

    // Detiene el cronómetro
    public void detener() {
        if (enMarcha) {
            fin = System.currentTimeMillis();
            enMarcha = false;
        }
    }

    // Reinicia el cronómetro
    public void reiniciar() {
        inicio = 0;
        fin = 0;
        enMarcha = false;
    }

    // Tiempo transcurrido en milisegundos
    private long getTiempoTranscurrido() {
        if (enMarcha) {
            return System.currentTimeMillis() - inicio;
        } else {
            return fin - inicio;
        }
    }

    // Devuelve el tiempo formateado en Horas : Minutos : Segundos
    public String getTiempoFormateado() {
        long tiempo = getTiempoTranscurrido() / 1000; 
        long horas = tiempo / 3600;
        long minutos = (tiempo % 3600) / 60;
        long segundos = tiempo % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}
    
