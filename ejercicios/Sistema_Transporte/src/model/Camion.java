package ejercicios.Sistema_Transporte.src.model;

public class Camion extends Vehiculo {
    private int toneladas;

    public Camion(String matricula, String marca, int toneladas){
        super(matricula, marca);
        this.toneladas = toneladas;
    }

    @Override
    public double calcularMantenimiento(){
        int totalMantenimiento = 0;
        totalMantenimiento += toneladas * 150;
        return totalMantenimiento;
    }

    public void mostrarCarga(){
        System.out.println("Carga Máxima: " + toneladas);
    }

}
