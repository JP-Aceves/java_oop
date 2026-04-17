package ejercicios.Plataforma_Streaming.src.controller;

import java.util.ArrayList;

import ejercicios.Plataforma_Streaming.src.model.Artista;
import ejercicios.Plataforma_Streaming.src.model.Cancion;
import ejercicios.Plataforma_Streaming.src.model.ContenidoAudio;
import ejercicios.Plataforma_Streaming.src.model.Playlist;
import ejercicios.Plataforma_Streaming.src.model.Podcast;
import ejercicios.Plataforma_Streaming.src.model.Usuario;

public class Plataforma {
private String nombre;
private ArrayList<Artista> artistas = new ArrayList<>();
private ArrayList<Usuario> usuarios = new ArrayList<>();

public Plataforma(String nombre){
    this.nombre = nombre;
}

public void añadirArtista(Artista a){
    artistas.add(a);
}
public void añadirUsuario(Usuario u){
    usuarios.add(u);
}

public void mostrarInfoUsuario(Usuario u){
    u.mostrarInformacion();
}

public void mostrarContenidoPlaylist(Playlist p){
    p.mostrarContenido();
}
public void mostrarCancionesArtista(Artista a){
    a.mostrarCanciones();
}
public void identificarTipoContenido(ContenidoAudio c){
    if (c instanceof Cancion) {
        System.out.println("Es una Cancion");
    } else if (c instanceof Podcast) {
        System.out.println("Es un Podcast");
    }
}

public ArrayList<Artista> getArtistas(){
    return artistas;
}




}
