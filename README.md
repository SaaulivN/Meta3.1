# La Taberna del Bus de Eventos: El Gólem Alquímico

Sistema de gestión para una taberna universitaria desarrollado en Java bajo el patrón arquitectónico **Event Bus**, logrando un desacoplamiento completo entre sus diferentes módulos y servicios (pedidos, barra, cocina, sonido, panel LED y efectos de humo).

## Tecnologías y Herramientas Utilizadas
- **Lenguaje:** Java 17+
- **Paradigma:** Programación orientada a eventos, asincronía con Hilos (`Threads`) y desacoplamiento mediante `Event Bus`.
- **Control de Versiones:** Git / GitHub

---

## Estructura de Archivos y Clases

El proyecto está organizado en paquetes limpios que separan la lógica del bus central, los objetos de eventos y los componentes del negocio:

```text
Meta3.1/
│
├── bus/
│   └── EventBus.java              # Administrador central de eventos (Publicación y Suscripción)
│
├── eventos/
│   ├── Evento.java                # Clase base abstracta con timestamp
│   ├── PedidoRealizadoEvent.java  # DTO para nuevos pedidos (mesa, ID, items)
│   ├── BebidaServidaEvent.java    # DTO para notificación de bebidas listas
│   ├── ComidaPreparadaEvent.java  # DTO para notificación de platillos listos
│   └── BandaTocandoEvent.java     # DTO para información de música en vivo
│
├── componentes/
│   ├── SistemaDePedidos.java      # Publicador de pedidos
│   ├── Barra.java                 # Suscriptor/Publicador de bebidas (Simula preparación)
│   ├── Cocina.java                # Suscriptor/Publicador de alimentos (Simula preparación)
│   ├── Banda.java                 # Publicador de conciertos musicales
│   ├── SistemaDeSonido.java       # Suscriptor que ajusta el ecualizador
│   ├── PanelLED.java              # Suscriptor global para notificaciones visuales
│   └── SistemaDeHumo.java         # Suscriptor de extensibilidad (Efectos especiales)
│
└── main/
    └── Main.java                  # Clase principal de ejecución y simulación de escenarios

```
Clonar
git clone [https://github.com/SaaulivN/Meta3.1.git](https://github.com/SaaulivN/Meta3.1.git)
cd Meta3.1

Compilar
javac bus/*.java eventos/*.java componentes/*.java main/*.java

Ejecutar
java main.Main
