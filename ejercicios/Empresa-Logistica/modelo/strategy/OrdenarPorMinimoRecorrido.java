public class OrdenarPorMinimoRecorrido implements PoliticaEntrega {
    @Override
    public List<Paquete> ordenar(List<Paquete> paquetes) {
        // lógica de optimización de ruta — simplificado como orden por dirección
        return paquetes.stream()
                .sorted(Comparator.comparing(Paquete::getDireccionEntrega))
                .collect(Collectors.toList());
    }
}
