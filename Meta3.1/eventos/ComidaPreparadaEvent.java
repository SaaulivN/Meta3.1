package eventos;

public class ComidaPreparadaEvent extends Evento {
    private final String pedidoId;
    private final String plato;

    public ComidaPreparadaEvent(String pedidoId, String plato) {
        super();
        this.pedidoId = pedidoId;
        this.plato = plato;
    }

    public String getPedidoId() { return pedidoId; }
    public String getPlato() { return plato; }
}