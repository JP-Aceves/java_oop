import java.util.List;

public class SistemaLogistica {
    private Empresa empresa;

    public SistemaLogistica(String nombreEmpresa) {
        this.empresa = new Empresa(nombreEmpresa);
    }

    public void agregarSede(Sede s) {
        empresa.addSede(s);
    }

    public Envio registrarEnvio(Cliente cliente, List<Paquete> paquetes) {
        String codigo = "ENV-" + System.currentTimeMillis();
        Envio envio = new Envio(codigo, cliente);
        for (Paquete p : paquetes) {
            p.setImportanciaCliente(cliente.getImportancia());
            envio.addPaquete(p);
        }
        cliente.addEnvio(envio);
        return envio;
    }

    public void asignarPaqueteAVehiculo(Paquete p, Vehiculo v) {
        v.asignarPaquete(p);
    }

    public Empresa getEmpresa() {
        return empresa;
    }
}
