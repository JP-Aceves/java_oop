public class Empleado {

    protected int numEmpleado;
    protected String nombre;
    protected String dni;
    
    public Empleado(int numEmpleado, String nombre, String dni) {
        this.numEmpleado = numEmpleado;
        this.nombre = nombre;
        this.dni = dni;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    

}
