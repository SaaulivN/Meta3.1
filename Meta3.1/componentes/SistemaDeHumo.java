package componentes;

import bus.EventBus;
import eventos.BandaTocandoEvent;

public class SistemaDeHumo {
    private final EventBus eventBus;

    public SistemaDeHumo(EventBus eventBus) {
        this.eventBus = eventBus;
        // Suscripción limpia sin modificar la Banda ni el EventBus
        this.eventBus.suscribir(BandaTocandoEvent.class, this::verificarEfectos);
    }

    private void verificarEfectos(BandaTocandoEvent evento) {
        if ("Through the Fire and Flames".equalsIgnoreCase(evento.getNombreCancion())) {
            System.out.println(">>> [SISTEMA DE HUMO] ¡Activando efectos especiales de humo y pirotecnia extrema para '" + evento.getNombreCancion() + "'! <<<");
        }
    }
}