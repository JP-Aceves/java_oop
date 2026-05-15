public class PrecioTemporadaAlta implements EstrategiaPrecio {

    private double recargo; // ej: 0.20 = 20% más caro

    public PrecioTemporadaAlta(double recargo) {
        this.recargo = recargo;
    }

    @Override
    public double calcular(Reserva reserva) {
        int noches = reserva.getNumNoches();
        double precioBase = reserva.getUnidad().calcularPrecioBase(noches, 1);
        return precioBase * (1 + recargo);
    }
}