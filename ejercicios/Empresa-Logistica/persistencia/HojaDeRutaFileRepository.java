import java.io.*;
import java.util.List;

public class HojaDeRutaFileRepository implements HojaDeRutaRepository {
    private String rutaDirectorio;

    public HojaDeRutaFileRepository(String rutaDirectorio) {
        this.rutaDirectorio = rutaDirectorio;
    }

    @Override
    public void guardar(HojaDeRuta h, int vehiculoId) {
        String ruta = rutaDirectorio + "/hoja_" + vehiculoId + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
            writer.println("=== HOJA DE RUTA - Vehículo " + vehiculoId + " ===");
            writer.println("Fecha: " + h.getFecha());
            writer.println("---");
            List<Paquete> paquetes = h.getPaquetes();
            for (int i = 0; i < paquetes.size(); i++) {
                writer.println((i + 1) + ". " + paquetes.get(i).toString());
            }
        } catch (IOException e) {
            System.err.println("Error al guardar hoja de ruta: " + e.getMessage());
        }
    }

    @Override
    public HojaDeRuta cargar(int vehiculoId) {
        String ruta = rutaDirectorio + "/hoja_" + vehiculoId + ".txt";
        File fichero = new File(ruta);
        if (!fichero.exists()) return null;

        HojaDeRuta hoja = new HojaDeRuta();
        try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.matches("^\\d+\\..*")) {
                    // stub: reconstruir paquete desde texto requeriría formato adicional
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar hoja de ruta: " + e.getMessage());
        }
        return hoja;
    }
}
