package ejercicios.Plataforma_Streaming.src.model;

import java.util.ArrayList;

public abstract class Usuario {
    protected String nombreUsuario;
    protected String email;
    protected String fechaRegistro;
    protected ArrayList<Playlist> playlists = new ArrayList<>();

    public Usuario(String nombreUsuario, String email, String fechaRegistro){
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre(){
        return nombreUsuario;
    }
    public String getEmail(){
        return email;
    }
    public String getFechaRegistro(){
        return fechaRegistro;
    }

    public abstract void mostrarInformacion();





}
