public class Apartamento extends Alojamiento {

    private int capacidadTotal;

    public Apartamento(String nombre, String localizacion, int capacidadTotal) {
        super(nombre, localizacion);
        this.capacidadTotal = capacidadTotal;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }
    

    
}
