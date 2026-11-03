package bus;

import eventos.Evento;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class EventBus {
    private static EventBus instanciaUnica;
    
    // Almacena los suscriptores agrupados por el tipo de clase del Evento
    private final Map<Class<?>, List<Consumer<Evento>>> suscriptores;

    private EventBus() {
        suscriptores = new ConcurrentHashMap<>();
    }

    // Patrón Singleton opcional pero recomendado para centralizar el bus
    public static synchronized EventBus getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new EventBus();
        }
        return instanciaUnica;
    }

    @SuppressWarnings("unchecked")
    public <T extends Evento> void suscribir(Class<T> tipoEvento, Consumer<T> suscriptor) {
        suscriptores.computeIfAbsent(tipoEvento, k -> new ArrayList<>())
                    .add((Consumer<Evento>) suscriptor);
    }

    public <T extends Evento> void desuscribir(Class<T> tipoEvento, Consumer<T> suscriptor) {
        List<Consumer<Evento>> lista = suscriptores.get(tipoEvento);
        if (lista != null) {
            lista.remove(suscriptor);
        }
    }

    public void publicar(Evento evento) {
        Class<?> tipo = evento.getClass();
        List<Consumer<Evento>> lista = suscriptores.get(tipo);
        if (lista != null) {
            for (Consumer<Evento> suscriptor : new ArrayList<>(lista)) {
                // Ejecución segura de cada suscriptor
                try {
                    suscriptor.accept(evento);
                } catch (Exception e) {
                    System.err.println("Error procesando evento en suscriptor: " + e.getMessage());
                }
            }
        }
    }
}