package eventos;

public class BandaTocandoEvent extends Evento {
    private final String nombreBanda;
    private final String nombreCancion;
    private final int duracion; // en segundos

    public BandaTocandoEvent(String nombreBanda, String nombreCancion, int duracion) {
        super();
        this.nombreBanda = nombreBanda;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    public String getNombreBanda() { return nombreBanda; }
    public String getNombreCancion() { return nombreCancion; }
    public int getDuracion() { return duracion; }
}