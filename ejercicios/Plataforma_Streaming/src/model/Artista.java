package ejercicios.Plataforma_Streaming.src.model;

import java.util.ArrayList;

public class Artista {
    private String nombreArtistico;
    private String paisOrigen;
    private ArrayList<Cancion>canciones = new ArrayList<>();

    public Artista(String nombreArtistico, String paisOrigen){
       this.nombreArtistico = nombreArtistico;
       this.paisOrigen = paisOrigen; 
    }

    public void addCancion(Cancion c){
        canciones.add(c);
    }

    public void mostrarCanciones(){
        for(Cancion x : canciones){
            System.out.println( "Título de la Cancion: " + x.getTituloContenido());
            System.out.println( "Duración de la Cancion: " + x.getDuracion());
            System.out.println( "Fecha de la Cancion: " + x.getFecha());
            System.out.println( "Genero de la Cancion: " + x.getGenero());
            System.out.println( "Reproducciones de la Cancion: " + x.getNumeroReproducciones());
        }
    }

    @Override
    public String toString() {
        return nombreArtistico + " (" + paisOrigen + ")";
  }     

}
