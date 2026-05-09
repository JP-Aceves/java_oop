// ─── MODELO ────────────────────────────────────────────────────────────────
// Clase de datos pura. Sin Swing, sin gestores. Solo guarda datos.
// Equivale a Estadistica en tu proyecto.

public class Puntuacion {

    private String nombre;
    private String juego;
    private int puntos;

    public Puntuacion(String nombre, String juego, int puntos) {
        this.nombre = nombre;
        this.juego  = juego;
        this.puntos = puntos;
    }

    public String getNombre() { return nombre; }
    public String getJuego()  { return juego;  }
    public int    getPuntos() { return puntos; }
}
