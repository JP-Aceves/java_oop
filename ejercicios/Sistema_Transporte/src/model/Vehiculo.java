package ejercicios.Sistema_Transporte.src.model;

public abstract class Vehiculo {
    protected String matricula;
    protected String marca;

    public Vehiculo(String matricula, String marca){
        this.matricula = matricula;
        this.marca = marca;
    }

    public abstract double calcularMantenimiento();

    public void mostrarInfo(){
        System.out.println("La matricula: " + matricula + " | " +  " La marca: " + marca + " | " + " Coste de Mantenimiento: " + calcularMantenimiento());
    }

}
