public class UnidadPrecioVariable extends UnidadReservable {

    private double precioPorPersonaPorNoche;

    public UnidadPrecioVariable(String id, int capacidad, boolean cancelacionGratuita, double precioPorPersonaPorNoche) {
        super(id, capacidad, cancelacionGratuita);
        this.precioPorPersonaPorNoche = precioPorPersonaPorNoche;
    }

    public double getPrecioPorPersonaPorNoche() { return precioPorPersonaPorNoche; }

    @Override
    public double calcularPrecioBase(int numNoches, int numPersonas) {
        // El número de personas SÍ afecta al precio
        return precioPorPersonaPorNoche * numPersonas * numNoches;
    }
}