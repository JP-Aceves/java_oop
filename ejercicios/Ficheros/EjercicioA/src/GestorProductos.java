import java.io.*;
import java.util.ArrayList;

/**
 * Lee y escribe la lista de productos en data/productos.txt.
 *
 * Formato del fichero — cada línea es un producto:
 *   nombre,precio,stock
 *   Manzana,1.5,100
 *   Leche,0.9,50
 *
 * Equivalente en tu proyecto a: PersistenciaArchivos.guardarUsuarios / cargarUsuarios
 */
public class GestorProductos {

    private static final String FICHERO = "data/productos.txt";

    /**
     * Guarda la lista completa sobreescribiendo el fichero.
     * Igual que guardarUsuarios() en PersistenciaArchivos.
     */
    public void guardarProductos(ArrayList<Producto> lista) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(FICHERO))) {
            for(Producto p : lista){
                bf.write(p.toArchivo());
                bf.newLine();
            }
        } catch (Exception e){
            System.out.println("No se encontro donde escribir." + e.getMessage());
        }
    }

    /**
     * Lee el fichero línea a línea y reconstruye la lista de productos.
     * Igual que cargarUsuarios() en PersistenciaArchivos.
     */
    public ArrayList<Producto> cargarProductos() {
        ArrayList<Producto> lista = new ArrayList<>();
        File ficheroExiste = new File(FICHERO);
        if (!ficheroExiste.exists()) {
            return lista;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroExiste))) {
            String linea;
            while((linea = br.readLine())!= null){
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                lista.add(Producto.fromArchivo(linea));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar productos: " + e.getMessage());
        }
        return lista;
}
}


