import java.io.File;
import java.util.ArrayList;

/**
 * Main del Ejercicio A.
 *
 * Lo que hace:
 *  1. Crea una lista de productos en memoria.
 *  2. Los guarda en data/productos.txt.
 *  3. Los vuelve a cargar desde el fichero.
 *  4. Los imprime para verificar que todo coincide.
 *
 * Ejecutar desde la carpeta EjercicioA/:
 *   javac src/*.java -d out/
 *   cd out && java Main
 */
public class Main {

    public static void main(String[] args) {

        // Crear la carpeta data/ si no existe (igual que hace PersistenciaArchivos en su constructor)
        new File("data").mkdirs();

        GestorProductos gestor = new GestorProductos();

        // 1. Creamos productos en memoria
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Manzana", 1.5, 100));
        productos.add(new Producto("Leche", 0.9, 50));
        productos.add(new Producto("Pan", 1.2, 30));

        // 2. Guardamos en disco → escribe data/productos.txt
        gestor.guardarProductos(productos);
        System.out.println("Productos guardados en data/productos.txt");

        // 3. Cargamos desde disco → lee data/productos.txt línea a línea
        ArrayList<Producto> cargados = gestor.cargarProductos();

        // 4. Mostramos para verificar
        System.out.println("\nProductos cargados desde fichero:");
        for (Producto p : cargados) {
            System.out.println("  " + p);
        }
    }
}
