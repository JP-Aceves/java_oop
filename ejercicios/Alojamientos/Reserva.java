
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {

    private UnidadReservable unidad;
    private Cliente cliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstrategiaPrecio estrategia;

    public Reserva(UnidadReservable unidad, Cliente cliente,
                   LocalDate fechaInicio, LocalDate fechaFin,
                   EstrategiaPrecio estrategia) {
        this.unidad = unidad;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estrategia = estrategia;
    }

    // Delega el cálculo en la estrategia inyectada
    public double calcularPrecio() {
        return estrategia.calcular(this);
    }

    public int getNumNoches() {
        return (int) ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }

    public UnidadReservable getUnidad() { return unidad; }
    public Cliente getCliente() { return cliente; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
}