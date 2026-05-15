public class CasaRural extends Alojamiento {

    private int numeroHabitaciones;

    public CasaRural(String nombre, String localizacion, int numeroHabitaciones) {
        super(nombre, localizacion);
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    
}
