public class GestorFacturacion {

    public double calcularImportanciaCliente(Cliente c) {
        return c.getFacturacionTotal();
    }

    public void acumularFacturacion(Cliente c, double monto) {
        c.acumularFacturacion(monto);
    }
}