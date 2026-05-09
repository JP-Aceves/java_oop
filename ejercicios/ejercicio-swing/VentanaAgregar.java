import javax.swing.*;
import java.awt.*;

// ─── BLOQUE 1.2 ─ JDialog ─────────────────────────────────────────────────
// JDialog en vez de JFrame porque es una ventana secundaria que depende
// de una ventana padre (VentanaMenu).
//
// La diferencia clave con JFrame:
//   JFrame = ventana independiente, puede vivir sola
//   JDialog = ventana secundaria, necesita un padre
//
// Equivale a VentanaSeleccionJuego en tu proyecto.

public class VentanaAgregar extends JDialog {

    private JTextField txtNombre;
    private JTextField txtPuntos;
    private JComboBox<String> cmbJuego; // desplegable de opciones
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JLabel lblError;

    // El resultado que VentanaMenu leerá después de que se cierre el diálogo.
    // null significa que el usuario canceló.
    private Puntuacion resultado = null;

    // ─── BLOQUE 1.3 ─ Constructor del JDialog ─────────────────────────────
    // super(padre, titulo, modal)
    // modal = true → el código del padre se pausa hasta que este diálogo se cierre.
    // modal = false → el padre sigue activo mientras el diálogo está abierto.
    // Prueba a cambiar true por false y verás que puedes hacer clic en VentanaMenu
    // mientras el diálogo está abierto.
    public VentanaAgregar(JFrame padre) {
        super(padre, "Añadir puntuación", true); // true = modal
        inicializarComponentes();
        configurarAcciones();
    }

    private void inicializarComponentes() {
        setSize(320, 230);
        setLocationRelativeTo(getParent()); // centrado sobre el padre, no sobre la pantalla
        setResizable(false);

        // ─── BLOQUE 3 ─ GridLayout para el formulario ─────────────────────
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 8, 8));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Juego:"));

        // ─── BLOQUE 2 ─ JComboBox ─────────────────────────────────────────
        // Desplegable con opciones predefinidas.
        // En tu proyecto los juegos vienen de GestorJuegos.getJuegosDisponibles().
        cmbJuego = new JComboBox<>(new String[]{"Pasapalabra", "TresEnRaya"});
        panelFormulario.add(cmbJuego);

        panelFormulario.add(new JLabel("Puntos:"));
        txtPuntos = new JTextField();
        panelFormulario.add(txtPuntos);

        // Fila de botones dentro del GridLayout
        btnAceptar  = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        panelFormulario.add(btnAceptar);
        panelFormulario.add(btnCancelar);

        // ─── BLOQUE 2.1 ─ Label de error ──────────────────────────────────
        lblError = new JLabel(" ");
        lblError.setForeground(Color.RED);
        lblError.setHorizontalAlignment(SwingConstants.CENTER);

        // ─── BLOQUE 3 ─ BorderLayout del diálogo ──────────────────────────
        setLayout(new BorderLayout());
        add(panelFormulario, BorderLayout.CENTER);
        add(lblError,        BorderLayout.SOUTH);
    }

    private void configurarAcciones() {
        // ─── BLOQUE 4.1 ─ ActionListener ──────────────────────────────────
        btnAceptar.addActionListener(e  -> accionAceptar());
        btnCancelar.addActionListener(e -> accionCancelar());

        // Enter en cualquier campo de texto confirma el formulario
        txtNombre.addActionListener(e -> accionAceptar());
        txtPuntos.addActionListener(e -> accionAceptar());
    }

    private void accionAceptar() {
        // ─── BLOQUE 5.1 ─ Leer campos ─────────────────────────────────────
        String nombre = txtNombre.getText().trim();
        String puntosStr = txtPuntos.getText().trim();

        // Validación
        if (nombre.isEmpty()) {
            lblError.setText("El nombre no puede estar vacío");
            txtNombre.requestFocus();
            return;
        }

        int puntos;
        try {
            puntos = Integer.parseInt(puntosStr);
        } catch (NumberFormatException ex) {
            lblError.setText("Los puntos deben ser un número");
            txtPuntos.setText("");
            txtPuntos.requestFocus();
            return;
        }

        // ─── BLOQUE 2 ─ Leer JComboBox ────────────────────────────────────
        String juego = (String) cmbJuego.getSelectedItem();

        // Guardamos el resultado para que VentanaMenu lo pueda leer
        // después de que el diálogo se cierre.
        resultado = new Puntuacion(nombre, juego, puntos);

        // ─── BLOQUE 1.9 ─ dispose() cierra el diálogo ─────────────────────
        // Al hacer dispose(), el código en VentanaMenu que estaba pausado
        // en setVisible(true) continúa ejecutándose.
        dispose();
    }

    private void accionCancelar() {
        resultado = null; // null indica que el usuario canceló
        dispose();
    }

    // Getter que VentanaMenu llama después de que el diálogo se cierre
    public Puntuacion getPuntuacion() {
        return resultado;
    }
}
