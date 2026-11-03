package componentes;

import bus.EventBus;
import eventos.BebidaServidaEvent;
import eventos.PedidoRealizadoEvent;

public class Barra {
    private final EventBus eventBus;

    public Barra(EventBus eventBus) {
        this.eventBus = eventBus;
        // Suscripción automática al iniciar
        this.eventBus.suscribir(PedidoRealizadoEvent.class, this::procesarPedido);
    }

    private void procesarPedido(PedidoRealizadoEvent evento) {
        for (String item : evento.getItems()) {
            // Lógica simple para detectar bebidas (ej. cerveza, vino, refresco)
            if (item.toLowerCase().contains("cerveza") || item.toLowerCase().contains("bebida") || item.toLowerCase().contains("agua")) {
                System.out.println("[Barra] Preparando bebida: " + item + " para la " + evento.getMesaId());
                
                // Simulación de tiempo de preparación (2 segundos)
                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                        eventBus.publicar(new BebidaServidaEvent(evento.getMesaId(), item));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
            }
        }
    }
}