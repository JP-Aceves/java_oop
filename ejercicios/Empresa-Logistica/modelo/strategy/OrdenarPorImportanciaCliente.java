import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenarPorImportanciaCliente implements PoliticaEntrega {
    @Override
    public List<Paquete> ordenar(List<Paquete> paquetes) {
        return paquetes.stream()
                .sorted(Comparator.comparingInt((Paquete p) -> p.getImportanciaCliente().getNivel()).reversed())
                .collect(Collectors.toList());
    }
}
