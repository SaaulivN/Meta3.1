package eventos;

public class BebidaServidaEvent extends Evento {
    private final String mesaId;
    private final String bebida;

    public BebidaServidaEvent(String mesaId, String bebida) {
        super();
        this.mesaId = mesaId;
        this.bebida = bebida;
    }

    public String getMesaId() { return mesaId; }
    public String getBebida() { return bebida; }
}