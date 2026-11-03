package eventos;

import java.util.List;

// Evento base abstracto (o interfaz)
public abstract class Evento {
    private final long timestamp;

    public Evento() {
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }
}