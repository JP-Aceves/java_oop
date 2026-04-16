package ejercicios.Sistema_Transporte;

import java.util.ArrayList;

import ejercicios.Sistema_Transporte.src.model.Camion;
import ejercicios.Sistema_Transporte.src.model.Moto;
import ejercicios.Sistema_Transporte.src.model.Vehiculo;

public class Main {
    public static void main(String[] args) {

        // Lista de tipo padre — puede guardar cualquier subclase de Vehiculo
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        // Se declaran como Vehiculo aunque sean Camion/Moto — tipo estático vs dinámico
        Vehiculo c1 = new Camion("JOSE12", "Jeep", 150);
        Vehiculo c2 = new Camion("KEN21", "Mercedes", 100);
        Vehiculo m1 = new Moto("ALEX45", "Buggati", 300);

        // Se añaden a la lista sin importar el tipo concreto
        vehiculos.add(c1);
        vehiculos.add(c2);
        vehiculos.add(m1);

        for(Vehiculo v : vehiculos){
            v.mostrarInfo(); // polimorfismo: Java llama al calcularMantenimiento() del tipo real en runtime
            if (v instanceof Camion) { // comprobamos si el objeto real es un Camion
                Camion c = (Camion) v; // cast para acceder a métodos que solo existen en Camion
                c.mostrarCarga();
            }
        }
    }
}
