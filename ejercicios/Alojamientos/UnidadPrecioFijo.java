public class UnidadPrecioFijo extends UnidadReservable {

    private double precioPorNoche;

    public UnidadPrecioFijo(String id, int capacidad, boolean cancelacionGratuita, double precioPorNoche) {
        super(id, capacidad, cancelacionGratuita);
        this.precioPorNoche = precioPorNoche;
    }

    public double getPrecioPorNoche() { return precioPorNoche; }

    @Override
    public double calcularPrecioBase(int numNoches, int numPersonas) {
        // El número de personas NO afecta al precio
        return precioPorNoche * numNoches;
    }
}