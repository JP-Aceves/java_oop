import java.util.ArrayList;

/**
 * Main del Ejercicio B.
 *
 * Lo que hace:
 *  1. Guarda 3 pedidos en data/pedidos/ (uno por fichero: 1.dat, 2.dat, 3.dat)
 *  2. Lista los IDs de todos los pedidos en disco.
 *  3. Carga e imprime cada pedido por su ID.
 *  4. Elimina el pedido con ID 2.
 *  5. Lista de nuevo para verificar que desapareció.
 *
 * Ejecutar desde la carpeta EjercicioB/:
 *   javac src/*.java -d out/
 *   cd out && java Main
 */
public class Main {

    public static void main(String[] args) {

        GestorPedidos gestor = new GestorPedidos();

        // 1. Guardamos 3 pedidos — cada uno crea su propio fichero ID.dat
        gestor.guardarPedido(1, "jose",  "Manzana", 3);
        gestor.guardarPedido(2, "pepe",  "Leche",   5);
        gestor.guardarPedido(3, "maria", "Pan",      2);
        System.out.println("Pedidos guardados en data/pedidos/");

        // 2. Listamos los IDs que hay en disco
        ArrayList<Integer> ids = gestor.listarPedidos();
        System.out.println("\nPedidos en disco: " + ids);

        // 3. Cargamos cada pedido por su ID y lo mostramos
        System.out.println("\nContenido de cada pedido:");
        for (int id : ids) {
            String datos = gestor.cargarPedido(id);
            // datos tiene formato "usuario,producto,cantidad"
            String[] partes = datos.split(",");
            System.out.println("  ID " + id + " → usuario=" + partes[0]
                    + ", producto=" + partes[1] + ", cantidad=" + partes[2]);
        }

        // 4. Eliminamos el pedido 2
        gestor.eliminarPedido(2);
        System.out.println("\nPedido 2 eliminado.");

        // 5. Listamos de nuevo para verificar
        System.out.println("Pedidos restantes: " + gestor.listarPedidos());
    }
}
