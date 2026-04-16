public class CajeroAutomatico {
    private Monedero monedero; // relación 0..1

    public CajeroAutomatico() {
        this.monedero = new Monedero();
    }

    public void sacar(Integer dineroPedido) {
        // TODO: usar monedero.calcularBilletes() y mostrar el resultado
    }
}
