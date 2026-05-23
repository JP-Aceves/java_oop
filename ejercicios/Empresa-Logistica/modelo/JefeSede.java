public class JefeSede extends Empleado {


    private ArrayList<JefeExpedicion> jefesExpedicion = new ArrayList<>();


    public JefeSede(int numEmpleado, String nombre, String dni) {
        super(numEmpleado, nombre, dni);
    }
    
    public void addJefeExpedicion(JefeExpedicion j){
        jefesExpedicion.add(j);
    }

    public ArrayList<JefeExpedicion> getJefesExpedicion() {
        return jefesExpedicion;
    }
    
}
