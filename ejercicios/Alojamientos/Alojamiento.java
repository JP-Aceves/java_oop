import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Alojamiento {
    protected String nombre;
    protected String localizacion;
    protected ArrayList<UnidadReservable> unidades = new ArrayList<>();

    public Alojamiento(String nombre, String localizacion){
        this.nombre = nombre;
        this.localizacion = localizacion;
    }

    public void agregarUnidad(UnidadReservable unidad) {
        unidades.add(unidad);
    }

    public ArrayList<UnidadReservable> getUnidadesDisponibles(LocalDate inicio, LocalDate fin) {
        ArrayList<UnidadReservable> disponibles = new ArrayList<>();
        for (UnidadReservable u : unidades) {
            if (u.estaDisponible(inicio, fin)) {
                disponibles.add(u);
            }
        }
        return disponibles;
    }

    public void mostrarUnidades() {
        System.out.println("=== " + nombre + " (" + localizacion + ") ===");
        for (UnidadReservable u : unidades) {
            System.out.println("  " + u);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public ArrayList<UnidadReservable> getUnidades() {
        return unidades;
    }


}
