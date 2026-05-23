public interface HojaDeRutaRepository {
    void guardar(HojaDeRuta h, int vehiculoId);
    HojaDeRuta cargar(int vehiculoId);
}
