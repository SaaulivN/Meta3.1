package componentes;

import bus.EventBus;
import eventos.PedidoRealizadoEvent;
import java.util.List;

public class SistemaDePedidos {
    private final EventBus eventBus;

    public SistemaDePedidos(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void registrarPedido(String mesaId, String pedidoId, List<String> items) {
        System.out.println("[SistemaDePedidos] Registrando nuevo pedido " + pedidoId + " para " + mesaId);
        PedidoRealizadoEvent evento = new PedidoRealizadoEvent(mesaId, pedidoId, items);
        eventBus.publicar(evento);
    }
}