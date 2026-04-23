package clases.ejercicioCajero.src.model;

import java.util.ArrayList;

public class Monedero {
    private int saldo;
    private ArrayList<Billete> listabilletes = new ArrayList<>();

    public Monedero() {
        listabilletes.add(new Billete(500, 2));
        listabilletes.add(new Billete(200, 2));
        listabilletes.add(new Billete(100, 2));
        listabilletes.add(new Billete(50, 2));
        listabilletes.add(new Billete(20, 2));
        listabilletes.add(new Billete(10, 2));
        listabilletes.add(new Billete(5, 2));

        saldo = 500*2 + 200*2 + 100*2 + 50*2 + 20*2 + 10*2 + 5*2; // 1770

    }

    public int getSaldo() {
        return saldo;
    }

    public int[] calcularBilletes() {
        int[] cantidades = new int[listabilletes.size()]; // CREA UN ARRAY DEL MISMO TAMAÑO QUE LA LISTA DE BILLETES

        for (int i = 0; i < listabilletes.size(); i++) { // RECORRE LA LISTA DE BILLETES
            cantidades[i] = listabilletes.get(i).getCantidad(); // GUARDA EN EL ARRAY LA CANTIDAD DE BILLETES DE CADA TIPO DESDE LA POSICION 0 ($500 HAY 5 BILLETES), EL GET(I) ES COMO EL INDICE EN ARRAY
        }

        return cantidades; // TE DEVUELVE LA LISTA DE CANTIDADES DE BILLETES QUE HAY DE CADA TIPO 
    }
    

    public boolean sacarDinero(int dineroPedido) { // DINERO PEDIDO ES EL DINERO QUE DESEAS SACAR
            if (dineroPedido <= 0 || dineroPedido > saldo || dineroPedido % 5 != 0) {
                return false;
            }
        
            int restante = dineroPedido; // VARIABLE QUE IRA BAJANDO MEDIANTE VAMOS ASIGNANDO BILLETES (ES LA CANTIDAD QUE PEDISTE RETIRAR)
            int[] billetesAUsar = new int[listabilletes.size()]; // ARRAY TEMPORAL QUE GUARDARA QUE BILLETES VAMOS USANDO (ES DEL MISMO TAMAÑO QUE LA LISTA DE BILLETES)
            int i = 0; // DECLARO EL i ANTES PORQUE EL FOR EACH NO TIENE INDICE
        
            for (Billete b : listabilletes) {
                int necesarios = Math.min(restante / b.getValor(), b.getCantidad()); // VEO LOS NECESARIOS CON EL MATH MIN QUE ME DICE EL MINIMO ENTRE DOS VALORES, ESTOS VALORES: 
                // restante / b.getValor() ES (cuántos billetes de este tipo necesitaríamos idealmente. Si restante=80 y billete=50, necesitamos 1)
                // b.getCantidad() ES (cuántos hay disponibles de este billete)
                billetesAUsar[i] = necesarios; // SI POR EJEMPLO NO SE USA EL BILLETE DE 500 PORQUE (0,2), SE GUARDA EL CERO EN EL ARRAY
                restante -= necesarios * b.getValor(); // EN EL CASO DE NO USO, EL NECESARIOS (0 * b.getValor() QUE SERIA POR EJEMPLO 500) PERO SI SI HAY USO SE RESTA Y EL RESTANTE DE VALER 80 VALE 60 SI SE RETIRARON 20
                i++; // SUMAMOR AL INDICE Y VAMOS A LA SIG VUELTA
            }
        
            if (restante != 0) return false;
        
            // EMPEZAMOS OTRO BUCLE 
            i = 0;
            for (Billete b : listabilletes) {
                if (billetesAUsar[i] > 0){
                    b.usar(billetesAUsar[i]);
                }
                i++;
            }
        
            saldo -= dineroPedido;
            return true;
        }
    }




    