import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String dni;
    private List<Reserva> reservas;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.reservas = new ArrayList<>();
    }

    public Reserva realizarReserva(UnidadReservable unidad, LocalDate inicio,
                                   LocalDate fin, EstrategiaPrecio estrategia) {
        if (!unidad.estaDisponible(inicio, fin)) {
            System.out.println("La unidad no está disponible en esas fechas.");
            return null;
        }
        Reserva r = new Reserva(unidad, this, inicio, fin, estrategia);
        reservas.add(r);
        unidad.agregarReserva(r);
        return r;
    }

    public List<Reserva> getReservas() { return reservas; }
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
}