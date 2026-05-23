public class Vehiculo {

    private Transportista transportista;
    private int id;
    private TamañoPaquete capacidad;
    private HojaDeRuta hojaDeRuta;

    public Vehiculo(int id, TamañoPaquete capacidad) {
        this.id = id;
        this.capacidad = capacidad;
        this.hojaDeRuta = new HojaDeRuta();
    }

    public void asignarTransportista(Transportista t) {
        this.transportista = t;
        t.setVehiculo(this);
    }

    public boolean admite(Paquete p) {
        return p.getTamañoPaquete().ordinal() <= capacidad.ordinal();
    }

    public void asignarPaquete(Paquete p) {
        hojaDeRuta.addPaquete(p);
    }

    public HojaDeRuta getHojaDeRuta() {
        return hojaDeRuta;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public int getId() {
        return id;
    }
}
