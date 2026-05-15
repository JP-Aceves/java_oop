import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Alojamiento> alojamientos = new ArrayList<>();
    static List<Cliente> clientes = new ArrayList<>();
    static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        cargarDatosPrueba();
        int opcion;
        do {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║   SISTEMA DE RESERVAS TURÍSTICAS     ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1. Ver alojamientos y unidades      ║");
            System.out.println("║  2. Buscar unidades disponibles      ║");
            System.out.println("║  3. Hacer una reserva                ║");
            System.out.println("║  4. Ver reservas de un cliente       ║");
            System.out.println("║  5. Calcular precio de una reserva   ║");
            System.out.println("║  6. Añadir nuevo cliente             ║");
            System.out.println("║  0. Salir                            ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Elige opción: ");
            opcion = leerInt();
            switch (opcion) {
                case 1 -> verAlojamientos();
                case 2 -> buscarDisponibles();
                case 3 -> hacerReserva();
                case 4 -> verReservasCliente();
                case 5 -> calcularPrecioReserva();
                case 6 -> añadirCliente();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ─────────────────────────────────────────────
    //  OPCIÓN 1 — Ver alojamientos
    // ─────────────────────────────────────────────
    static void verAlojamientos() {
        System.out.println("\n── ALOJAMIENTOS ──────────────────────────");
        for (int i = 0; i < alojamientos.size(); i++) {
            Alojamiento a = alojamientos.get(i);
            System.out.println("[" + i + "] " + a.getNombre() +
                    " | " + a.getLocalizacion() +
                    " | " + tipoAlojamiento(a));
            for (UnidadReservable u : a.getUnidades()) {
                String precio = (u instanceof UnidadPrecioFijo upf)
                        ? upf.getPrecioPorNoche() + "€/noche"
                        : ((UnidadPrecioVariable) u).getPrecioPorPersonaPorNoche() + "€/persona/noche";
                String cancelacion = u.permiteCancelacionGratuita() ? "✓ cancelación gratuita" : "✗ sin cancelación";
                System.out.println("    → [" + u.getId() + "] cap:" + u.getCapacidad() +
                        "  " + precio + "  " + cancelacion);
            }
        }
    }

    // ─────────────────────────────────────────────
    //  OPCIÓN 2 — Buscar unidades disponibles
    // ─────────────────────────────────────────────
    static void buscarDisponibles() {
        System.out.print("\nFecha de entrada (dd/MM/yyyy): ");
        LocalDate inicio = leerFecha();
        System.out.print("Fecha de salida  (dd/MM/yyyy): ");
        LocalDate fin = leerFecha();
        if (fin.isBefore(inicio) || fin.isEqual(inicio)) {
            System.out.println("La fecha de salida debe ser posterior a la de entrada.");
            return;
        }
        System.out.println("\n── UNIDADES DISPONIBLES del " + inicio.format(fmt) + " al " + fin.format(fmt) + " ──");
        boolean hayAlguna = false;
        for (Alojamiento a : alojamientos) {
            List<UnidadReservable> disponibles = a.getUnidadesDisponibles(inicio, fin);
            if (!disponibles.isEmpty()) {
                System.out.println("  " + a.getNombre() + " (" + tipoAlojamiento(a) + "):");
                for (UnidadReservable u : disponibles) {
                    System.out.println("    → [" + u.getId() + "] capacidad: " + u.getCapacidad() + " personas");
                }
                hayAlguna = true;
            }
        }
        if (!hayAlguna) System.out.println("  No hay unidades disponibles para esas fechas.");
    }

    // ─────────────────────────────────────────────
    //  OPCIÓN 3 — Hacer reserva
    // ─────────────────────────────────────────────
    static void hacerReserva() {
        // Elegir cliente
        Cliente cliente = elegirCliente();
        if (cliente == null) return;

        // Elegir alojamiento
        verAlojamientos();
        System.out.print("\nElige número de alojamiento: ");
        int idxA = leerInt();
        if (idxA < 0 || idxA >= alojamientos.size()) { System.out.println("Alojamiento no válido."); return; }
        Alojamiento alojamiento = alojamientos.get(idxA);

        // Elegir unidad
        System.out.print("ID de la unidad (ej: 101): ");
        String idUnidad = sc.nextLine().trim();
        UnidadReservable unidad = buscarUnidad(alojamiento, idUnidad);
        if (unidad == null) { System.out.println("Unidad no encontrada."); return; }

        // Fechas
        System.out.print("Fecha de entrada (dd/MM/yyyy): ");
        LocalDate inicio = leerFecha();
        System.out.print("Fecha de salida  (dd/MM/yyyy): ");
        LocalDate fin = leerFecha();
        if (fin.isBefore(inicio) || fin.isEqual(inicio)) {
            System.out.println("Fechas no válidas.");
            return;
        }

        // Estrategia de precio
        EstrategiaPrecio estrategia = elegirEstrategia();

        // Crear reserva
        Reserva r = cliente.realizarReserva(unidad, inicio, fin, estrategia);
        if (r != null) {
            System.out.println("\n✓ Reserva creada con éxito.");
            System.out.println("  Cliente : " + cliente.getNombre());
            System.out.println("  Unidad  : " + unidad.getId() + " en " + alojamiento.getNombre());
            System.out.println("  Fechas  : " + inicio.format(fmt) + " → " + fin.format(fmt));
            System.out.println("  Noches  : " + r.getNumNoches());
            System.out.println("  Precio  : " + String.format("%.2f", r.calcularPrecio()) + "€");
        }
    }

    // ─────────────────────────────────────────────
    //  OPCIÓN 4 — Ver reservas de un cliente
    // ─────────────────────────────────────────────
    static void verReservasCliente() {
        Cliente cliente = elegirCliente();
        if (cliente == null) return;
        List<Reserva> reservas = cliente.getReservas();
        if (reservas.isEmpty()) {
            System.out.println("Este cliente no tiene reservas.");
            return;
        }
        System.out.println("\n── RESERVAS DE " + cliente.getNombre().toUpperCase() + " ──");
        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            System.out.println("[" + i + "] Unidad " + r.getUnidad().getId() +
                    " | " + r.getFechaInicio().format(fmt) + " → " + r.getFechaFin().format(fmt) +
                    " | " + r.getNumNoches() + " noches" +
                    " | " + String.format("%.2f", r.calcularPrecio()) + "€");
        }
    }

    // ─────────────────────────────────────────────
    //  OPCIÓN 5 — Recalcular precio con otra estrategia
    // ─────────────────────────────────────────────
    static void calcularPrecioReserva() {
        Cliente cliente = elegirCliente();
        if (cliente == null) return;
        if (cliente.getReservas().isEmpty()) { System.out.println("Sin reservas."); return; }

        verReservasCliente();
        System.out.print("Elige número de reserva: ");
        int idx = leerInt();
        if (idx < 0 || idx >= cliente.getReservas().size()) { System.out.println("No válido."); return; }
        Reserva r = cliente.getReservas().get(idx);

        System.out.println("\n¿Con qué estrategia quieres calcular?");
        EstrategiaPrecio estrategia = elegirEstrategia();
        double precio = estrategia.calcular(r);
        System.out.println("Precio con esa estrategia: " + String.format("%.2f", precio) + "€");
    }

    // ─────────────────────────────────────────────
    //  OPCIÓN 6 — Añadir cliente
    // ─────────────────────────────────────────────
    static void añadirCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("DNI: ");
        String dni = sc.nextLine().trim();
        clientes.add(new Cliente(nombre, dni));
        System.out.println("✓ Cliente añadido.");
    }

    // ─────────────────────────────────────────────
    //  HELPERS
    // ─────────────────────────────────────────────
    static Cliente elegirCliente() {
        System.out.println("\n── CLIENTES ──");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("[" + i + "] " + clientes.get(i).getNombre() +
                    " — " + clientes.get(i).getDni());
        }
        System.out.print("Elige número de cliente: ");
        int idx = leerInt();
        if (idx < 0 || idx >= clientes.size()) { System.out.println("Cliente no válido."); return null; }
        return clientes.get(idx);
    }

    static EstrategiaPrecio elegirEstrategia() {
        System.out.println("\n── ESTRATEGIA DE PRECIO ──");
        System.out.println("[0] Precio base por noche");
        System.out.println("[1] Descuento estancia larga");
        System.out.println("[2] Recargo temporada alta");
        System.out.println("[3] Promoción especial");
        System.out.print("Elige estrategia: ");
        int op = leerInt();
        return switch (op) {
            case 1 -> {
                System.out.print("Mínimo de noches para descuento: ");
                int min = leerInt();
                System.out.print("Porcentaje de descuento (ej: 10 para 10%): ");
                double d = leerDouble() / 100.0;
                yield new PrecioDescuentoEstanciaLarga(min, d);
            }
            case 2 -> {
                System.out.print("Porcentaje de recargo (ej: 20 para 20%): ");
                double r = leerDouble() / 100.0;
                yield new PrecioTemporadaAlta(r);
            }
            case 3 -> {
                System.out.print("Porcentaje de descuento promo (ej: 15 para 15%): ");
                double d = leerDouble() / 100.0;
                yield new PrecioPromocion(d);
            }
            default -> new PrecioBaseNoche();
        };
    }

    static UnidadReservable buscarUnidad(Alojamiento a, String id) {
        for (UnidadReservable u : a.getUnidades()) {
            if (u.getId().equalsIgnoreCase(id)) return u;
        }
        return null;
    }

    static String tipoAlojamiento(Alojamiento a) {
        if (a instanceof Hotel h) return "Hotel " + h.getNumeroEstrellas() + "★";
        if (a instanceof Apartamento ap) return "Apartamento " + ap.getCapacidadTotal() + "hab";
        if (a instanceof CasaRural cr) return "Casa Rural cap." + cr.getNumeroHabitaciones();
        return "Alojamiento";
    }

    static int leerInt() {
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }

    static double leerDouble() {
        try { return Double.parseDouble(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return 0; }
    }

    static LocalDate leerFecha() {
        while (true) {
            try { return LocalDate.parse(sc.nextLine().trim(), fmt); }
            catch (DateTimeParseException e) { System.out.print("Formato incorrecto, usa dd/MM/yyyy: "); }
        }
    }

    // ─────────────────────────────────────────────
    //  DATOS DE PRUEBA
    // ─────────────────────────────────────────────
    static void cargarDatosPrueba() {
        Hotel hotel = new Hotel("Hotel La Mar", "Barcelona", 4, true);
        hotel.agregarUnidad(new UnidadPrecioFijo("101", 2, true, 80.0));
        hotel.agregarUnidad(new UnidadPrecioFijo("102", 2, false, 80.0));
        hotel.agregarUnidad(new UnidadPrecioVariable("201", 4, true, 25.0));

        Apartamento apto = new Apartamento("Apto Sol", "Valencia", 3);
        apto.agregarUnidad(new UnidadPrecioFijo("A1", 6, true, 120.0));
        apto.agregarUnidad(new UnidadPrecioVariable("A2", 4, false, 30.0));

        CasaRural casa = new CasaRural("El Pinar", "Segovia", 10);
        casa.agregarUnidad(new UnidadPrecioFijo("C1", 10, true, 200.0));

        alojamientos.add(hotel);
        alojamientos.add(apto);
        alojamientos.add(casa);

        clientes.add(new Cliente("Ana López", "11111111A"));
        clientes.add(new Cliente("Carlos Ruiz", "22222222B"));
    }
}