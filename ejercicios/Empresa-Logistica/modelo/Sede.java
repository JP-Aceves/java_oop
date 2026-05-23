import java.util.ArrayList;

public class Sede {

    private int idUnico;
    private String ciudad;
    private JefeSede jefeSede;
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private PoliticaEntrega politicaEntrega;

    public Sede(int idUnico, String ciudad) {
        this.idUnico = idUnico;
        this.ciudad = ciudad;
    }

    public void setJefeSede(JefeSede jefeSede) {
        this.jefeSede = jefeSede;
    }

    public void addVehiculo(Vehiculo v){
        vehiculos.add(v);
    }

    public void setPoliticaEntrega(PoliticaEntrega politicaEntrega) {
        this.politicaEntrega = politicaEntrega;
    }

    public int getIdUnico() {
        return idUnico;
    }

    public String getCiudad() {
        return ciudad;
    }

    public JefeSede getJefeSede() {
        return jefeSede;
    }


    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public PoliticaEntrega getPoliticaEntrega() {
        return politicaEntrega;
    }

    public void registrarPaquete(Paquete p){
        for(Vehiculo v : vehiculos){
            if (v.admite(p)) {
                v.asignarPaquete(p);
                return;
            }
        }
    }

    public void actualizarHojasDeRuta(){
        for (Vehiculo v : vehiculos) {
            v.getHojaDeRuta().ordenar(politicaEntrega);
        }
    }


    

    

    



}
