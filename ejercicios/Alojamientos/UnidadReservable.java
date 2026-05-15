import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class UnidadReservable {

    private String id;
    private int capacidad;
    private boolean cancelacionGratuita;
    private List<Reserva> reservas; // para saber si está ocupada

    public UnidadReservable(String id, int capacidad, boolean cancelacionGratuita) {
        this.id = id;
        this.capacidad = capacidad;
        this.cancelacionGratuita = cancelacionGratuita;
        this.reservas = new ArrayList<>();
    }

    public boolean permiteCancelacionGratuita() {
        return cancelacionGratuita;
    }

    // Comprueba si hay solapamiento con alguna reserva existente
    public boolean estaDisponible(LocalDate inicio, LocalDate fin) {
        for (Reserva r : reservas) {
            boolean solapa = !fin.isBefore(r.getFechaInicio()) &&
                             !inicio.isAfter(r.getFechaFin());
            if (solapa) return false;
        }
        return true;
    }

    public void agregarReserva(Reserva r) {
        reservas.add(r);
    }

    // Cada subclase define cómo calcula su precio base
    public abstract double calcularPrecioBase(int numNoches, int numPersonas);

    public String getId() { return id; }
    public int getCapacidad() { return capacidad; }
}