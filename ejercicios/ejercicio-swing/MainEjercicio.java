import javax.swing.SwingUtilities;

// ─── BLOQUE 1.10 ─ EDT ────────────────────────────────────────────────────
// Todo lo visual debe crearse dentro de invokeLater.
// Si crearas la ventana fuera, Swing podría tener problemas de concurrencia.

public class MainEjercicio {

    public static void main(String[] args) {

        // invokeLater encola la creación de la ventana en el Event Dispatch Thread.
        // El código dentro de la lambda se ejecuta cuando Swing esté listo.
        SwingUtilities.invokeLater(() -> {
            VentanaLogin ventana = new VentanaLogin();
            ventana.setVisible(true); // sin esto la ventana no aparece
        });
    }
}
