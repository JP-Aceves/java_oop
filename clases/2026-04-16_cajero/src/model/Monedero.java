public class Monedero {
    private Integer saldo;
    private Billete[] listaBilletes; // orden: [500, 200, 100, 50, 20, 10, 5]

    public Monedero() {
        // TODO: inicializar listaBilletes con los 7 tipos
        // Ejemplo de cantidad inicial: todos con 10 billetes disponibles
    }

    // Dado un importe, devuelve cuántos billetes de cada tipo usar
    // Algoritmo greedy: empieza por el billete más grande
    public Integer[] calcularBilletes(Integer dineroPedido) {
        Integer[] resultado = new Integer[7];
        // TODO: implementar lógica greedy
        return resultado;
    }

    public Integer getSaldo() {
        return saldo;
    }
}
