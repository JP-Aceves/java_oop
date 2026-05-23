public class Transportista extends Empleado {

    private Vehiculo vehiculo;
    private String telefono;

    public Transportista(int numEmpleado, String nombre, String dni, String telefono) {
        super(numEmpleado, nombre, dni);
        this.telefono = telefono;
    }

    public void setVehiculo(Vehiculo v) {
        this.vehiculo = v;
    }

    public void imprimirHojaRuta(){
        vehiculo.getHojaDeRuta().imprimir();
    }


}
