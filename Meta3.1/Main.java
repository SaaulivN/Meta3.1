import bus.EventBus;
import componentes.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== INICIANDO LA TABERNA: EL GÓLEM ALQUÍMICO ===");

        EventBus eventBus = EventBus.getInstancia();

        SistemaDePedidos sistemaPedidos = new SistemaDePedidos(eventBus);
        Barra barra = new Barra(eventBus);
        Cocina cocina = new Cocina(eventBus);
        SistemaDeSonido sistemaSonido = new SistemaDeSonido(eventBus);
        PanelLED panelLED = new PanelLED(eventBus);

        Banda banda = new Banda(eventBus, "Los Seguidores de Dijkstra");

        System.out.println("\n--- SIMULACIÓN DE PEDIDO ---");
        sistemaPedidos.registrarPedido("Mesa 5", "pedido_123", Arrays.asList("cerveza", "hamburguesa"));

        Thread.sleep(6000);

        System.out.println("\n--- SIMULACIÓN DE CONCIERTO ---");
        banda.tocarCancion("El Algoritmo del Amor", 180);

        Thread.sleep(1000);

        System.out.println("\n--- DEMOSTRACIÓN DE EXTENSIBILIDAD (AGREGANDO SISTEMA DE HUMO) ---");
        SistemaDeHumo sistemaHumo = new SistemaDeHumo(eventBus);

        banda.tocarCancion("Through the Fire and Flames", 300);

        Thread.sleep(2000);
        System.out.println("\n=== FIN DE LA SIMULACIÓN ===");
    }
}
