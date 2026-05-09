import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ─── BLOQUE 1.1 ─ JFrame ──────────────────────────────────────────────────
// extends JFrame convierte esta clase en una ventana del sistema operativo.
// Hereda: barra de título, botones minimizar/maximizar/cerrar, área de contenido.
// Sin extends JFrame esto sería una clase normal sin ventana.

public class VentanaLogin extends JFrame {

    // ─── BLOQUE 2 ─ Atributos: los componentes visuales ──────────────────
    // Se declaran como atributos para poder acceder a ellos desde cualquier
    // método de la clase. Si los declarases dentro de inicializarComponentes()
    // serían variables locales y accionLogin() no podría leerlos.

    private JTextField     txtUsername;   // campo de texto editable
    private JPasswordField txtPassword;   // como JTextField pero oculta caracteres
    private JButton        btnEntrar;     // botón clickable
    private JButton        btnCancelar;   // segundo botón
    private JLabel         lblError;      // texto de error (inicialmente vacío)

    // ─── BLOQUE 1 ─ Constructor ───────────────────────────────────────────
    public VentanaLogin() {
        inicializarComponentes();
        configurarAcciones();
    }

    // ─────────────────────────────────────────────────────────────────────
    // INICIALIZAR COMPONENTES — crea y coloca los componentes
    // Aquí NO hay lógica de negocio. Solo aspecto visual y posición.
    // ─────────────────────────────────────────────────────────────────────
    private void inicializarComponentes() {

        // ─── BLOQUE 1 ─ Configuración básica del JFrame ──────────────────
        setTitle("MiniRegistro — Login");

        // Tamaño inicial en píxeles
        setSize(380, 220);

        // EXIT_ON_CLOSE: al pulsar la X del sistema cierra toda la aplicación.
        // Alternativas: DISPOSE_ON_CLOSE (solo cierra esta ventana),
        //               DO_NOTHING_ON_CLOSE (tú gestionas el cierre con WindowListener)
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // null como argumento centra la ventana en la pantalla
        setLocationRelativeTo(null);

        // No se puede cambiar el tamaño arrastrando los bordes
        setResizable(false);

        // ─── BLOQUE 3 ─ BorderLayout en el JFrame ────────────────────────
        // BorderLayout divide el contenedor en 5 zonas: NORTH, SOUTH, EAST, WEST, CENTER.
        // Es el layout por defecto del JFrame pero lo ponemos explícito por claridad.
        setLayout(new BorderLayout(10, 10));

        // ─── BLOQUE 3 ─ Panel central con GridLayout ─────────────────────
        // GridLayout(filas, columnas, separacion_horizontal, separacion_vertical)
        // Todos los huecos tienen el mismo tamaño. Perfecto para pares etiqueta-campo.
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 8, 8));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(15, 20, 5, 20));

        // Fila 1: etiqueta + campo usuario
        panelFormulario.add(new JLabel("Usuario:"));
        txtUsername = new JTextField();
        panelFormulario.add(txtUsername);

        // Fila 2: etiqueta + campo contraseña
        panelFormulario.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField();
        panelFormulario.add(txtPassword);

        // Fila 3: dos botones
        btnEntrar   = new JButton("Entrar");
        btnCancelar = new JButton("Cancelar");
        panelFormulario.add(btnEntrar);
        panelFormulario.add(btnCancelar);

        // ─── BLOQUE 2.1 ─ JLabel para mensajes de error ──────────────────
        lblError = new JLabel(" "); // espacio para que ocupe altura desde el inicio
        lblError.setHorizontalAlignment(SwingConstants.CENTER);

        // ─── BLOQUE 5.6 ─ setForeground cambia el color del texto ────────
        lblError.setForeground(Color.RED);
        lblError.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));

        // ─── BLOQUE 3 ─ Añadir paneles al BorderLayout ───────────────────
        // CENTER: ocupa todo el espacio sobrante (el formulario)
        // SOUTH: franja fija abajo (el label de error)
        add(panelFormulario, BorderLayout.CENTER);
        add(lblError,        BorderLayout.SOUTH);
    }

    // ─────────────────────────────────────────────────────────────────────
    // CONFIGURAR ACCIONES — registra los listeners en los componentes
    // Aquí NO hay lógica de negocio. Solo "cuando pase X, llama a Y".
    // ─────────────────────────────────────────────────────────────────────
    private void configurarAcciones() {

        // ─── BLOQUE 4.1 ─ ActionListener con lambda ───────────────────────
        // e -> accionLogin() es equivalente a:
        //   new ActionListener() { public void actionPerformed(ActionEvent e) { accionLogin(); } }
        // La lambda es más corta. El objeto 'e' es el ActionEvent (casi nunca lo necesitas).
        btnEntrar.addActionListener(e -> accionLogin());

        btnCancelar.addActionListener(e -> accionCancelar());

        // ─── BLOQUE 4.1 ─ ActionListener en campo de texto ───────────────
        // En un JTextField/JPasswordField, ActionListener se dispara al pulsar Enter.
        // Así el usuario puede entrar sin hacer clic en el botón.
        txtPassword.addActionListener(e -> accionLogin());

        // ─── BLOQUE 4.2 ─ KeyListener ────────────────────────────────────
        // KeyAdapter es una clase abstracta que implementa KeyListener con métodos vacíos.
        // Solo sobreescribes el método que necesitas: keyPressed, keyReleased o keyTyped.
        txtUsername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Cada vez que el usuario escribe una tecla, limpiamos el error.
                // Así el mensaje de error desaparece en cuanto empieza a corregir.
                lblError.setText(" ");
            }
        });

        // ─── BLOQUE 4.3 ─ WindowListener ─────────────────────────────────
        // WindowAdapter es como KeyAdapter: implementa WindowListener con métodos vacíos.
        // windowClosing se llama cuando el usuario pulsa la X del sistema.
        // Como pusimos DO_NOTHING_ON_CLOSE arriba, la X no hace nada sola.
        // Aquí decidimos nosotros qué pasa: preguntar antes de cerrar.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // ─── BLOQUE 7 ─ JOptionPane confirmación ─────────────────
                int respuesta = JOptionPane.showConfirmDialog(
                    VentanaLogin.this,          // ventana padre del popup
                    "¿Seguro que quieres salir?",
                    "Salir",
                    JOptionPane.YES_NO_OPTION
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                // Si elige NO, no pasa nada y la ventana sigue abierta.
            }
        });
    }

    // ─────────────────────────────────────────────────────────────────────
    // MÉTODOS DE ACCIÓN — aquí sí hay lógica
    // ─────────────────────────────────────────────────────────────────────

    private void accionLogin() {

        // ─── BLOQUE 5.1 ─ Leer JTextField ────────────────────────────────
        // trim() elimina espacios al principio y al final.
        // Sin trim(), "admin " (con espacio) no coincidiría con "admin".
        String username = txtUsername.getText().trim();

        // ─── BLOQUE 5.2 ─ Leer JPasswordField ────────────────────────────
        // getPassword() devuelve char[], no String.
        // getText() existe pero está deprecated (obsoleto) porque deja la contraseña
        // en memoria como String inmutable. char[] se puede borrar manualmente.
        String password = new String(txtPassword.getPassword());

        // Validación simple — en tu proyecto esto lo hace GestorUsuarios
        if (username.equals("admin") && password.equals("1234")) {
            // ─── BLOQUE 6 ─ Navegación ────────────────────────────────────
            // 1. Crear y mostrar la nueva ventana
            // 2. dispose() cierra Y destruye esta ventana (libera memoria)
            //    Si usaras setVisible(false), la ventana seguiría en memoria.
            VentanaMenu menu = new VentanaMenu(this);
            menu.setVisible(true);

            // Ocultamos el login en vez de destruirlo porque VentanaMenu
            // necesita la referencia para volver aquí al cerrar sesión.
            setVisible(false);

        } else {
            // ─── BLOQUE 5.3 ─ Escribir en JLabel ─────────────────────────
            lblError.setText("Usuario o contraseña incorrectos");

            // ─── BLOQUE 5.9 ─ requestFocus ────────────────────────────────
            // Pone el cursor en el campo de contraseña para que el usuario
            // pueda escribir inmediatamente sin hacer clic.
            txtPassword.setText("");
            txtPassword.requestFocus();
        }
    }

    private void accionCancelar() {
        // ─── BLOQUE 5.1 ─ Limpiar campos ─────────────────────────────────
        txtUsername.setText("");
        txtPassword.setText("");
        lblError.setText(" ");
        txtUsername.requestFocus();
    }
}
