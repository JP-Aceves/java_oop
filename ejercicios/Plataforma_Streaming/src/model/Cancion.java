package ejercicios.Plataforma_Streaming.src.model;

public class Cancion extends ContenidoAudio{
    private String genero;
    private int numeroReproducciones;
    private Artista artista;

    public Cancion(String titulo, double duracion, String fecha, String genero, int numeroReproducciones){
        super(titulo, duracion, fecha);
        this.genero = genero;
        this.numeroReproducciones = numeroReproducciones;
    }

    public void mostrarTipo(){
        System.out.println("Este contenido es una Canción: " + titulo);
    }

    public Artista getArtista(){
        return artista;
    }
    public String getGenero(){
        return genero;
    }
    public int getNumeroReproducciones(){
        return numeroReproducciones;
    }


    

}
