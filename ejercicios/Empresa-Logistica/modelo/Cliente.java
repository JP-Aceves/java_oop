import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String dni;
    private double facturacionTotal;
    private ArrayList<Envio> listaEnvios = new ArrayList<>();

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
    
    public void acumularFacturacion(double monto){
        facturacionTotal += monto;
    }

    public double getFacturacionTotal() {
        return facturacionTotal;
    }

    public void addEnvio(Envio e){
        listaEnvios.add(e);
    }

    public ArrayList<Envio> getListaEnvios() {
        return listaEnvios;
    }

    public Importancia getImportancia() {
        if (facturacionTotal < 500) {
            return Importancia.BAJA;
        } else if (facturacionTotal < 1000) {
            return Importancia.MEDIA;
        } else {
            return Importancia.ALTA;
        }
    }



    

    

    

    

}
