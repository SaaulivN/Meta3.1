package eventos;
import java.util.List;

public class PedidoRealizadoEvent extends Evento {
    private final String mesaId;
    private final String pedidoId;
    private final List<String> items;

    public PedidoRealizadoEvent(String mesaId, String pedidoId, List<String> items) {
        super();
        this.mesaId = mesaId;
        this.pedidoId = pedidoId;
        this.items = items;
    }

    public String getMesaId() { return mesaId; }
    public String getPedidoId() { return pedidoId; }
    public List<String> getItems() { return items; }
}