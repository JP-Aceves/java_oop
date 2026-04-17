public class Cajero {
    private Monedero monedero;

    public Cajero() {
        this.monedero = new Monedero();
    }

    public boolean sacarDinero(int dineroPedido) {
        return monedero.sacarDinero(dineroPedido);
    }

    public int getSaldo() {
        return monedero.getSaldo();
    }

    public int [] getBilletes(){
        return monedero.calcularBilletes();
    }



}

