public class GestorSede {
    private Sede sede;
    private HojaDeRutaRepository repositorio;

    public GestorSede(Sede sede, HojaDeRutaRepository repositorio) {
        this.sede = sede;
        this.repositorio = repositorio;
    }

    public void recibirPaquete(Paquete p) {
        sede.registrarPaquete(p);
    }

    public void actualizarHojasDeRuta() {
        sede.actualizarHojasDeRuta();
    }

    public void cambiarPolitica(PoliticaEntrega p) {
        sede.setPoliticaEntrega(p);
    }

    public void guardarHojasDeRuta() {
        for (Vehiculo v : sede.getVehiculos()) {
            repositorio.guardar(v.getHojaDeRuta(), v.getId());
        }
    }

    public void cargarHojasDeRuta() {
        for (Vehiculo v : sede.getVehiculos()) {
            HojaDeRuta h = repositorio.cargar(v.getId());
            if (h != null) {
                // reemplaza la hoja actual con la cargada
                for (Paquete p : h.getPaquetes()) {
                    v.asignarPaquete(p);
                }
            }
        }
    }
}