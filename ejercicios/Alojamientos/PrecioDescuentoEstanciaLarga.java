public class PrecioDescuentoEstanciaLarga implements EstrategiaPrecio {

    private int minimoNoches;  // a partir de cuántas noches aplica el descuento
    private double descuento;  // ej: 0.10 = 10%

    public PrecioDescuentoEstanciaLarga(int minimoNoches, double descuento) {
        this.minimoNoches = minimoNoches;
        this.descuento = descuento;
    }

    @Override
    public double calcular(Reserva reserva) {
        int noches = reserva.getNumNoches();
        double precioBase = reserva.getUnidad().calcularPrecioBase(noches, 1);
        if (noches >= minimoNoches) {
            return precioBase * (1 - descuento);
        }
        return precioBase;
    }
}