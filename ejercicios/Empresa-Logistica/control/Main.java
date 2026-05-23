public class Main {
    public static void main(String[] args) {

        // === SISTEMA ===
        SistemaLogistica sistema = new SistemaLogistica("Logística España S.L.");

        // === SEDE ===
        Sede madrid = new Sede(1, "Madrid");
        madrid.setPoliticaEntrega(new OrdenarPorUrgencia());
        sistema.agregarSede(madrid);

        // === EMPLEADOS ===
        JefeSede jefe = new JefeSede(1, "Ana García", "12345678A");
        madrid.setJefeSede(jefe);

        JefeExpedicion jefeExp = new JefeExpedicion(2, "Pedro Ruiz", "22222222B");
        madrid.addJefeExpedicion(jefeExp);

        Transportista t1 = new Transportista(3, "Luis Pérez", "33333333C", "600111222");
        Transportista t2 = new Transportista(4, "Marta Sanz", "44444444D", "600333444");
        jefeExp.addTransportista(t1);
        jefeExp.addTransportista(t2);

        // === VEHÍCULOS ===
        Vehiculo v1 = new Vehiculo(1, TamañoPaquete.GRANDE);
        Vehiculo v2 = new Vehiculo(2, TamañoPaquete.MEDIANO);
        v1.asignarTransportista(t1);
        v2.asignarTransportista(t2);
        madrid.addVehiculo(v1);
        madrid.addVehiculo(v2);

        // === CLIENTES ===
        GestorClientes gestorClientes = new GestorClientes();
        GestorFacturacion gestorFact = new GestorFacturacion();

        Cliente c1 = gestorClientes.registrarCliente("Carlos López", "11111111E");
        Cliente c2 = gestorClientes.registrarCliente("Sofía Mora", "55555555F");
        gestorFact.acumularFacturacion(c1, 1200.0);
        gestorFact.acumularFacturacion(c2, 300.0);

        // === PAQUETES Y ENVÍOS ===
        Paquete p1 = new Paquete("PKG-001", "Calle Mayor 1, Madrid",
                HorasEntrega.URGENTE, TamañoPaquete.PEQUEÑO, "600000001");
        p1.setImportanciaCliente(c1.getImportancia());

        Paquete p2 = new Paquete("PKG-002", "Avenida Paz 5, Madrid",
                HorasEntrega.ESTANDAR, TamañoPaquete.MEDIANO, "600000002");
        p2.setImportanciaCliente(c1.getImportancia());

        Paquete p3 = new Paquete("PKG-003", "Gran Vía 10, Madrid",
                HorasEntrega.NORMAL, TamañoPaquete.PEQUEÑO, "600000003");
        p3.setImportanciaCliente(c2.getImportancia());

        Envio envio1 = new Envio("ENV-001", c1);
        envio1.addPaquete(p1);
        envio1.addPaquete(p2);
        c1.addEnvio(envio1);

        Envio envio2 = new Envio("ENV-002", c2);
        envio2.addPaquete(p3);
        c2.addEnvio(envio2);

        // === GESTIÓN DE SEDE ===
        HojaDeRutaRepository repo = new HojaDeRutaFileRepository("./hojas");
        GestorSede gestorMadrid = new GestorSede(madrid, repo);

        gestorMadrid.recibirPaquete(p1);
        gestorMadrid.recibirPaquete(p2);
        gestorMadrid.recibirPaquete(p3);

        // ordenar hojas de ruta con la política activa (urgencia)
        gestorMadrid.actualizarHojasDeRuta();

        // guardar en fichero
        gestorMadrid.guardarHojasDeRuta();

        // === TRANSPORTISTAS IMPRIMEN SU HOJA ===
        System.out.println("\n--- Hoja de ruta de " + t1.getNombre() + " ---");
        t1.imprimirHojaRuta();

        System.out.println("\n--- Hoja de ruta de " + t2.getNombre() + " ---");
        t2.imprimirHojaRuta();

        // === CAMBIAR POLÍTICA Y REORDENAR ===
        System.out.println("\n--- Cambiando política a importancia de cliente ---");
        gestorMadrid.cambiarPolitica(new OrdenarPorImportanciaCliente());
        gestorMadrid.actualizarHojasDeRuta();

        System.out.println("\n--- Hoja de ruta de " + t1.getNombre() + " tras cambio ---");
        t1.imprimirHojaRuta();

        // === RANKING DE CLIENTES ===
        System.out.println("\n--- Ranking clientes por facturación ---");
        gestorClientes.ordenarPorFacturacion()
                .forEach(c -> System.out.println(c.getNombre() + ": " + c.getFacturacionTotal() + "€"));
    }
}
