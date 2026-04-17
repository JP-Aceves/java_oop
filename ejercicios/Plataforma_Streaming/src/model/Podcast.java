package ejercicios.Plataforma_Streaming.src.model;

public class Podcast extends ContenidoAudio {
    private String nombrePodcast;
    private int numeroEpisodio;

    public Podcast(String titulo, double duracion, String fecha){
        super(titulo, duracion, fecha);
        this.nombrePodcast = nombrePodcast;
        this.numeroEpisodio = numeroEpisodio;
    }

    public void mostrarTipo(){
        System.out.println("Este contenido es un Podcast: " + titulo);
    }

    public String getNombrePodcast(){
        return nombrePodcast;
    }
    public int getNumeroEpisodio(){
        return numeroEpisodio;
    }
}
