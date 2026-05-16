import java.io.*;
import java.util.ArrayList;

/**
 * Lee y escribe pedidos en ficheros individuales dentro de data/pedidos/.
 * Cada pedido se guarda en su propio fichero: data/pedidos/ID.dat
 *
 * Formato de cada fichero:
 *   usuario,producto,cantidad
 *   Ejemplo: "jose,Manzana,3"
 *
 * Equivalente exacto en tu proyecto:
 *   guardarPartidaPausada / cargarPartidaPausada / eliminarPartidaPausada / listarPartidasPausadas
 *   en PersistenciaArchivos.java
 */
public class GestorPedidos {

    private static final String CARPETA = "data/pedidos/";

    public GestorPedidos() {
        // Crea la carpeta si no existe, igual que en PersistenciaArchivos()
        new File(CARPETA).mkdirs();
    }

    /**
     * Guarda un pedido en data/pedidos/ID.dat
     * Formato: "usuario,producto,cantidad"
     *
     * Equivale a: guardarPartidaPausada(int id, String estado)
     */
    public void guardarPedido(int id, String usuario, String producto, int cantidad) {
       String contenido = id + ";" + usuario + ";" + producto + ";" + cantidad;
       try {
        BufferedWriter bf = new BufferedWriter(new FileWriter(CARPETA + id + ".dat"));
        bf.write(contenido);

       } catch(Exception e){
        System.out.println("Error al escribir en fichero." + e.getMessage());
       }
    }

    /**
     * Carga el contenido del fichero data/pedidos/ID.dat
     * Devuelve null si no existe.
     *
     * Equivale a: cargarPartidaPausada(int id)
     */
    public String cargarPedido(int id) {
        File f = new File(CARPETA + id + ".dat");
        if (!f.exists()) return null;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            return br.readLine();
        } catch (IOException e) {
            System.err.println("Error al cargar pedido: " + e.getMessage());
            return null;
        }
       
    }

    /**
     * Elimina el fichero data/pedidos/ID.dat
     *
     * Equivale a: eliminarPartidaPausada(int id)
     */
    public void eliminarPedido(int id) {
        File f = new File(CARPETA + id + ".dat");
        if (f.exists()) f.delete();
    }

    /**
     * Lista los IDs de todos los pedidos guardados en disco.
     * Lee los nombres de fichero y extrae el número.
     *
     * Equivale a: listarPartidasPausadas()
     */
    public ArrayList<Integer> listarPedidos() {
        ArrayList<Integer> ids = new ArrayList<>();
        File carpeta = new File(CARPETA);
        File[] ficheros = carpeta.listFiles((dir, name) -> name.endsWith(".dat"));
        if (ficheros == null) return ids;
        for (File f : ficheros) {
            String nombre = f.getName().replace(".dat", "");
            ids.add(Integer.parseInt(nombre));
        }
        return ids;
    }
}

