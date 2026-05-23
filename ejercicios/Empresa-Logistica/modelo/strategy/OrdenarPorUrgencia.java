import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenarPorUrgencia implements PoliticaEntrega {

    @Override
    public List<Paquete> ordenar(List<Paquete> paquetes) {
        return paquetes.stream()
                .sorted(Comparator.comparingInt(p -> p.getHorasEntrega().getHoras()))
                .collect(Collectors.toList());
    }
}
