public class PrecioBaseNoche implements EstrategiaPrecio {

    @Override
    public double calcular(Reserva reserva) {
        int noches = reserva.getNumNoches();
        // Asume 1 persona por defecto para precio base
        return reserva.getUnidad().calcularPrecioBase(noches, 1);
    }
}