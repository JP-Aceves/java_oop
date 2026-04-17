package ejercicios.Plataforma_Streaming.src.model;

import java.util.ArrayList;

public class Playlist {
    private String nombrePlaylist;
    private ArrayList<ContenidoAudio> contenidos = new ArrayList<>();

    public Playlist(String nombrePlaylist){
        this.nombrePlaylist = nombrePlaylist;
    }

    public void agregarContenido(ContenidoAudio c){
        contenidos.add(c);
    }

    public void mostrarContenido(){
        for(ContenidoAudio a : contenidos){
            if (a instanceof Cancion) {
                Cancion cancion = (Cancion) a;
                System.out.println("Título: " + a.getTituloContenido());
                System.out.println("Duración: " + a.getDuracion());
                System.out.println("Fecha: " + a.getFecha());
                System.out.println("Género: " + cancion.getGenero());
                System.out.println("Reproducciones: " + cancion.getNumeroReproducciones());
            } else if (a instanceof Podcast) {
                Podcast podcast = (Podcast) a;
                System.out.println("Título: " + a.getTituloContenido());
                System.out.println("Duración: " + a.getDuracion());
                System.out.println("Fecha: " + a.getFecha());
                System.out.println("Nombre del Podcast: " + podcast.getNombrePodcast());
                System.out.println("Cantidad de Episodios: " + podcast.getNumeroEpisodio());
            }
        }
    }



}
