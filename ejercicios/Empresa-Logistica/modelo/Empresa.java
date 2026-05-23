import java.util.ArrayList;

public class Empresa {

    private String nombreEmpresa;
    private ArrayList<Sede> sedes = new ArrayList<>();


    public Empresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Empresa(String nombreEmpresa, ArrayList<Sede> sedes) {
        this.nombreEmpresa = nombreEmpresa;
        this.sedes = sedes;
    }

    public void addSede(Sede s){
        sedes.add(s);
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }


    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    



    

}
