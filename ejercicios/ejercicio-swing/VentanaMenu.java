import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// ─── BLOQUE 1.1 ─ JFrame ──────────────────────────────────────────────────
public class VentanaMenu extends JFrame {

    // ─── REFERENCIA AL PADRE ──────────────────────────────────────────────
    // Guardamos la referencia a VentanaLogin para poder volver a ella
    // al cerrar sesión. Equivale a ventanaPadre en tu VentanaJuego.
    private JFrame ventanaLogin;

    // Lista compartida de puntuaciones — en tu proyecto esto lo gestiona
    // GestorEstadisticas. Aquí lo simplificamos con un ArrayList directo.
    private ArrayList<Puntuacion> listaPuntuaciones;

    public VentanaMenu(JFrame ventanaLogin) {
        this.ventanaLogin      = ventanaLogin;
        this.listaPuntuaciones = new ArrayList<>();
        inicializarComponentes();
        configurarAcciones();
    }

    private void inicializarComponentes() {
        setTitle("MiniRegistro — Menú");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // ─── BLOQUE 3 ─ BorderLayout ───────────────────────────────────────
        setLayout(new BorderLayout(10, 10));

        // ─── BLOQUE 2.1 ─ JLabel de bienvenida ────────────────────────────
        JLabel lblBienvenida = new JLabel("Bienvenido, admin", SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 14));
        lblBienvenida.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        // ─── BLOQUE 3 ─ Panel de botones con GridLayout ───────────────────
        // 3 filas, 1 columna: cada botón ocupa toda la fila.
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 0, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        JButton btnAnadir   = new JButton("Añadir puntuación");
        JButton btnVerRanking = new JButton("Ver ranking");
        JButton btnSalir    = new JButton("Cerrar sesión");

        panelBotones.add(btnAnadir);
        panelBotones.add(btnVerRanking);
        panelBotones.add(btnSalir);

        add(lblBienvenida, BorderLayout.NORTH);
        add(panelBotones,  BorderLayout.CENTER);

        // ─── BLOQUE 4.1 ─ Listeners ───────────────────────────────────────
        // Se guardan referencias a los botones para poder añadir listeners.
        // Alternativa: declararlos como atributos de la clase como en VentanaLogin.
        btnAnadir.addActionListener(e -> accionAnadir());
        btnVerRanking.addActionListener(e -> accionVerRanking());
        btnSalir.addActionListener(e -> accionSalir());
    }

    private void configurarAcciones() {
        // En este caso los listeners ya están en inicializarComponentes()
        // porque los botones son locales. En ventanas más grandes
        // conviene separarlos como en VentanaLogin.
    }

    private void accionAnadir() {
        // ─── BLOQUE 1.2 / 1.3 ─ JDialog modal ────────────────────────────
        // Creamos el diálogo pasando this como padre.
        // El código se PAUSA en setVisible(true) hasta que el diálogo se cierre.
        // Eso es lo que permite leer el resultado justo después.
        VentanaAgregar dialogo = new VentanaAgregar(this);
        dialogo.setVisible(true); // ← PAUSA aquí hasta que el diálogo se cierre

        // Este código solo se ejecuta DESPUÉS de que el diálogo se haya cerrado.
        Puntuacion nueva = dialogo.getPuntuacion();
        if (nueva != null) {
            listaPuntuaciones.add(nueva);
            // ─── BLOQUE 7 ─ JOptionPane mensaje ───────────────────────────
            JOptionPane.showMessageDialog(this,
                "Puntuación de " + nueva.getNombre() + " añadida correctamente.");
        }
    }

    private void accionVerRanking() {
        // ─── BLOQUE 6 ─ Abrir nueva ventana ───────────────────────────────
        // Pasamos la lista para que VentanaRanking pueda mostrarla.
        // En tu proyecto, VentanaEstadisticas recibe el username y llama
        // al gestor para obtener los datos. Aquí lo simplificamos.
        VentanaRanking ranking = new VentanaRanking(listaPuntuaciones);
        ranking.setVisible(true);
        // No cerramos esta ventana: el ranking es una ventana adicional,
        // no una transición. Ambas pueden estar abiertas a la vez.
    }

    private void accionSalir() {
        // ─── BLOQUE 6 ─ Navegación de vuelta ──────────────────────────────
        ventanaLogin.setVisible(true); // muestra el login que estaba oculto
        dispose();                     // destruye esta ventana
    }
}
