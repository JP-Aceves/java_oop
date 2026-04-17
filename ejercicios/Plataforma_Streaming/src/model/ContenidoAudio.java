package ejercicios.Plataforma_Streaming.src.model;

public abstract class ContenidoAudio {
    protected String titulo;
    protected double duracion;
    protected String fecha;

    public ContenidoAudio(String titulo, double duracion, String fecha){
        this.titulo = titulo;
        this.duracion = duracion;
        this.fecha = fecha;
    }

    public abstract void mostrarTipo();

    public String getTituloContenido(){
        return titulo;
    }
    public double getDuracion(){
        return duracion;
    }
    public String getFecha(){
        return fecha;
    }
}
