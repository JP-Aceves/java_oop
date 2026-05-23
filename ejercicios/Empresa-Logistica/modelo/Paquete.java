import java.util.Date;

public class Paquete {

    private String idUnico;
    private Date fechaLlegadaSede;
    private String direccionEntrega;
    private HorasEntrega horasEntrega;
    private TamanoPaquete tamanoPaquete;
    private Importancia importanciaCliente = Importancia.BAJA;
    private String telefonoEntrega;
    private Cliente cliente;

    public Paquete(String idUnico, String direccionEntrega, HorasEntrega horasEntrega,
                   TamanoPaquete tamanoPaquete, String telefonoEntrega, Cliente cliente) {
        this.idUnico = idUnico;
        this.fechaLlegadaSede = new Date();
        this.direccionEntrega = direccionEntrega;
        this.horasEntrega = horasEntrega;
        this.tamanoPaquete = tamanoPaquete;
        this.telefonoEntrega = telefonoEntrega;
        this.cliente = cliente;
        this.importanciaCliente = cliente.getImportancia();
    }

    public Importancia getImportanciaCliente() {
        return cliente.getImportancia(); // siempre actualizada desde el cliente
    }

    @Override
    public String toString() {
        return "[" + idUnico + "] " + direccionEntrega + " | " + horasEntrega.getHoras() + "h | "
                + tamanoPaquete + " | Importancia: " + cliente.getImportancia() + " | Tel: " + telefonoEntrega;
    }

    public String getIdUnico() { return idUnico; }
    public Date getFechaLlegadaSede() { return fechaLlegadaSede; }
    public String getDireccionEntrega() { return direccionEntrega; }
    public HorasEntrega getHorasEntrega() { return horasEntrega; }
    public TamanoPaquete getTamanoPaquete() { return tamanoPaquete; }
    public String getTelefonoEntrega() { return telefonoEntrega; }
    public Cliente getCliente() { return cliente; }
}