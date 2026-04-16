package ejercicios.Sistema_Transporte.src.model;

public class Moto extends Vehiculo{

    private int cilindrada;

    public Moto(String matricula, String marca, int cilindrada){
        super(matricula, marca);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularMantenimiento(){
        int totalMantenimiento = 0;
        totalMantenimiento += cilindrada * 0.5;
        return totalMantenimiento;
    }
}
