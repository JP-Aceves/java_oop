import java.util.ArrayList;

public class JefeExpedicion extends Empleado {

    private ArrayList<Transportista> transportistas = new ArrayList<>();

    public JefeExpedicion(int numEmpleado, String nombre, String dni) {
        super(numEmpleado, nombre, dni);
    }

    public void addTransportista(Transportista t){
        transportistas.add(t);
    }

    public ArrayList<Transportista> getTransportistas() {
        return transportistas;
    }

    

    

}
