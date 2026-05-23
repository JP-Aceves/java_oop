import java.util.ArrayList;

public class Envio {
    private Cliente cliente;
    private String idUnico;
    private ArrayList<Paquete> listaPaquetes = new ArrayList<>();


    public Envio(String idUnico, Cliente cliente) {
        this.idUnico = idUnico;
        this.cliente = cliente;
    }

    public void addPaquete(Paquete p){
        listaPaquetes.add(p);
    }

    public ArrayList<Paquete> getListaPaquetes(){
        return listaPaquetes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getIdUnico() {
        return idUnico;
    }

    

    

}
