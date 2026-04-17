package ejercicios.Plataforma_Streaming.src.model;

public class UsuarioGratuito extends Usuario {
    private int limiteReproducciones;

    public UsuarioGratuito(String nombreUsuario, String email, String fechaRegistro, int limiteReproducciones){
        super(nombreUsuario, email, fechaRegistro);
        this.limiteReproducciones = limiteReproducciones;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombreUsuario);
        System.out.println("Tipo: Gratuito");
        System.out.println("Límite reproducciones: " + limiteReproducciones);
    }

}
