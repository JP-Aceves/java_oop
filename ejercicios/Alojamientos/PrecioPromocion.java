public class PrecioPromocion implements EstrategiaPrecio {

    private double descuento; // ej: 0.15 = 15% de descuento

    public PrecioPromocion(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public double calcular(Reserva reserva) {
        int noches = reserva.getNumNoches();
        double precioBase = reserva.getUnidad().calcularPrecioBase(noches, 1);
        return precioBase * (1 - descuento);
    }
}