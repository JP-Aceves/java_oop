import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GestorClientes {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente registrarCliente(String nombre, String dni) {
        Cliente c = new Cliente(nombre, dni);
        clientes.add(c);
        return c;
    }

    public List<Cliente> ordenarPorFacturacion() {
        return clientes.stream()
                .sorted(Comparator.comparingDouble(Cliente::getFacturacionTotal).reversed())
                .collect(Collectors.toList());
    }
}
