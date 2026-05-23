import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HojaDeRuta {

    private Date fecha;
    private List<Paquete> paquetes = new ArrayList<>();

    public HojaDeRuta() {
        this.fecha = new Date();
    }

    public HojaDeRuta(Date fecha) {
        this.fecha = fecha;
    }

    public void addPaquete(Paquete p) {
        paquetes.add(p);
    }

    public void ordenar(PoliticaEntrega politicaEntrega) {
        paquetes = politicaEntrega.ordenar(paquetes);
    }

    public void imprimir() {
        System.out.println("=== HOJA DE RUTA - " + fecha + " ===");
        for (int i = 0; i < paquetes.size(); i++) {
            System.out.println((i + 1) + ". " + paquetes.get(i).toString());
        }
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public Date getFecha() {
        return fecha;
    }
}
