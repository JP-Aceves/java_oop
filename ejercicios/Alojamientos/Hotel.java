public class Hotel extends Alojamiento {

    private int numeroEstrellas;
    private boolean tienePiscina;

    public Hotel(String nombre, String localizacion, int numeroEstrellas, boolean tienePiscina) {
        super(nombre, localizacion);
        this.numeroEstrellas = numeroEstrellas;
        this.tienePiscina = tienePiscina;
    }

    public int getNumeroEstrellas() {
        return numeroEstrellas;
    }

    public boolean isTienePiscina() {
        return tienePiscina;
    }

    

    
}
