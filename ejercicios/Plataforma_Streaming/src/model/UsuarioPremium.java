package ejercicios.Plataforma_Streaming.src.model;

public class UsuarioPremium extends Usuario {
    private String modalidadPago;

    public UsuarioPremium(String nombreUsuario, String email, String fechaRegistro, String modalidadPago){
        super(nombreUsuario, email, fechaRegistro);
        this.modalidadPago = modalidadPago;
    }
    
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombreUsuario);
        System.out.println("Tipo: Premium");
        System.out.println("Modalidad de Pago: " + modalidadPago);
    }



}
