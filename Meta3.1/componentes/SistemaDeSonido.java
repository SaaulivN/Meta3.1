package componentes;

import bus.EventBus;
import eventos.BandaTocandoEvent;

public class SistemaDeSonido {
    private final EventBus eventBus;

    public SistemaDeSonido(EventBus eventBus) {
        this.eventBus = eventBus;
        this.eventBus.suscribir(BandaTocandoEvent.class, this::ajustarSonido);
    }

    private void ajustarSonido(BandaTocandoEvent evento) {
        System.out.println("Ajustando ecualizador para: " + evento.getNombreCancion());
    }
}