package componentes;

import bus.EventBus;
import eventos.*;

public class PanelLED {
    private final EventBus eventBus;

    public PanelLED(EventBus eventBus) {
        this.eventBus = eventBus;
        // Se suscribe a todos los eventos relevantes del sistema
        this.eventBus.suscribir(PedidoRealizadoEvent.class, e -> 
            System.out.println("[PANEL LED] ¡Nuevo pedido recibido de la " + e.getMesaId() + "!"));
        
        this.eventBus.suscribir(BebidaServidaEvent.class, e -> 
            System.out.println("[PANEL LED] ¡Nueva bebida (" + e.getBebida() + ") servida en la " + e.getMesaId() + "!"));
        
        this.eventBus.suscribir(ComidaPreparadaEvent.class, e -> 
            System.out.println("[PANEL LED] ¡El pedido " + e.getPedidoId() + " está listo en cocina!"));
        
        this.eventBus.suscribir(BandaTocandoEvent.class, e -> 
            System.out.println("[PANEL LED] ¡La banda " + e.getNombreBanda() + " está interpretando " + e.getNombreCancion() + "!"));
    }
}