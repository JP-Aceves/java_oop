/**
 * Representa un producto con nombre, precio y stock.
 * Sabe serializarse a una línea de texto y reconstruirse desde ella.
 */
public class Producto {

    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Serializa el producto a una línea de texto.
     * Formato: nombre,precio,stock
     * Ejemplo: "Manzana,1.5,100"
     */
    public String toArchivo() {
        return nombre + ";" + precio + ";" + stock;
    }

    /**
     * Reconstruye un Producto desde una línea de texto.
     * Formato esperado: nombre,precio,stock
     */
    public static Producto fromArchivo(String linea) {
        String[] partes = linea.split(";");
        String nombre = partes[0];
        double precio = Double.parseDouble(partes[1]);
        int stock = Integer.parseInt(partes[2]);
        return new Producto(nombre, precio, stock);

    }

    // Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock()     { return stock; }

    @Override
    public String toString() {
        return "Producto{nombre='" + nombre + "', precio=" + precio + ", stock=" + stock + "}";
    }
}