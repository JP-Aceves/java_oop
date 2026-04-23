package clases.ejercicioCajero.src.model;


public class Billete {
        private int valor;
        private int cantidad;
    
        public Billete(int valor, int cantidad) {
            this.valor = valor;
            this.cantidad = cantidad;
        }
    
        public int getValor() {
            return valor;
        }
    
        public int getCantidad() {
            return cantidad;
        }
    
        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    
        public void usar(int n) {
            this.cantidad -= n; //  ESTOY RESTANDO A LA CANTIDAD DE BILLETES EL NUMERO DE BILLETES SACADOS (SI HABIA 5 Y SAQUE 2 QUEDAN 3)
        }
    
        @Override
        public String toString() {
            return "Billete{" + valor + "€ x" + cantidad + "}";
        }
    }

