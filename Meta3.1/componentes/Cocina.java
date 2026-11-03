package componentes;

import bus.EventBus;
import eventos.ComidaPreparadaEvent;
import eventos.PedidoRealizadoEvent;

public class Cocina {
    private final EventBus eventBus;

    public Cocina(EventBus eventBus) {
        this.eventBus = eventBus;
        this.eventBus.suscribir(PedidoRealizadoEvent.class, this::procesarPedido);
    }

    private void procesarPedido(PedidoRealizadoEvent evento) {
        for (String item : evento.getItems()) {
            // Lógica simple para detectar alimentos (ej. hamburguesa, tacos, pizza)
            if (!item.toLowerCase().contains("cerveza") && !item.toLowerCase().contains("bebida")) {
                System.out.println("[Cocina] Preparando platillo: " + item + " (Pedido: " + evento.getPedidoId() + ")");
                
                // Simulación de tiempo de preparación (5 segundos)
                new Thread(() -> {
                    try {
                        Thread.sleep(5000);
                        eventBus.publicar(new ComidaPreparadaEvent(evento.getPedidoId(), item));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            }
        }
    }
}