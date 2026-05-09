import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

// ─── BLOQUE 1.1 ─ JFrame ──────────────────────────────────────────────────
// Esta ventana puede estar abierta a la vez que VentanaMenu.
// No es modal ni tiene ventana padre obligatoria.
// Equivale a VentanaEstadisticas en tu proyecto.

public class VentanaRanking extends JFrame {

    // ─── BLOQUE 2.7 ─ JTable ──────────────────────────────────────────────
    // JTable muestra datos en filas y columnas.
    // No se llena directamente: necesita un modelo (DefaultTableModel).
    private JTable tabla;

    // ─── BLOQUE 2.11 ─ DefaultTableModel ──────────────────────────────────
    // Es el "motor de datos" de la tabla. La tabla lo consulta para saber
    // cuántas filas hay, qué valor tiene cada celda, etc.
    private DefaultTableModel modelo;

    private JButton btnCerrar;
    private JLabel  lblTotal;

    public VentanaRanking(ArrayList<Puntuacion> lista) {
        inicializarComponentes();
        configurarAcciones();
        cargarDatos(lista); // carga los datos DESPUÉS de crear los componentes
    }

    private void inicializarComponentes() {
        setTitle("Ranking de puntuaciones");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // ─── BLOQUE 3 ─ BorderLayout ───────────────────────────────────────
        setLayout(new BorderLayout(10, 10));

        // ─── BLOQUE 2.11 ─ Crear el DefaultTableModel ─────────────────────
        // Primer argumento: array de nombres de columnas
        // Segundo argumento: número inicial de filas (0 = vacía)
        String[] columnas = {"Nombre", "Juego", "Puntos"};
        modelo = new DefaultTableModel(columnas, 0) {
            // Sobrescribimos isCellEditable para que la tabla sea solo lectura.
            // Sin esto el usuario puede editar las celdas directamente.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // ─── BLOQUE 2.7 ─ Crear la JTable con el modelo ───────────────────
        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // solo una fila a la vez

        // Estilo visual opcional
        tabla.setRowHeight(25);
        tabla.getTableHeader().setReorderingAllowed(false); // no se pueden reordenar columnas

        // ─── BLOQUE 2.9 ─ JScrollPane ─────────────────────────────────────
        // CRÍTICO: JTable sin JScrollPane no muestra las cabeceras de columna.
        // Las cabeceras (Nombre, Juego, Puntos) solo aparecen dentro de un JScrollPane.
        // Prueba a sustituir esto por add(tabla, BorderLayout.CENTER) y verás que
        // desaparecen las cabeceras.
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Panel inferior con label de total y botón
        JPanel panelSur = new JPanel(new BorderLayout());
        lblTotal  = new JLabel("Total: 0 puntuaciones");
        btnCerrar = new JButton("Cerrar");
        panelSur.add(lblTotal,  BorderLayout.WEST);
        panelSur.add(btnCerrar, BorderLayout.EAST);
        panelSur.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        add(scrollPane, BorderLayout.CENTER);
        add(panelSur,   BorderLayout.SOUTH);
    }

    private void configurarAcciones() {
        btnCerrar.addActionListener(e -> dispose());

        // ─── BLOQUE 4.5 ─ ListSelectionListener ───────────────────────────
        // Se dispara cuando el usuario selecciona o cambia la fila seleccionada.
        // e.getValueIsAdjusting() filtra eventos intermedios (mientras arrastra).
        tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = tabla.getSelectedRow();
                if (fila >= 0) {
                    // ─── BLOQUE 5.8 ─ Leer valor de celda de JTable ───────
                    // getValueAt(fila, columna) — columnas empiezan en 0
                    String nombre = (String) tabla.getValueAt(fila, 0);
                    setTitle("Ranking — seleccionado: " + nombre);
                }
            }
        });
    }

    // ─────────────────────────────────────────────────────────────────────
    // Carga los datos en el modelo de la tabla.
    // Equivale a mostrarTabla() en tu VentanaEstadisticas.
    // ─────────────────────────────────────────────────────────────────────
    private void cargarDatos(ArrayList<Puntuacion> lista) {

        // ─── BLOQUE 2.11 ─ Limpiar el modelo antes de recargar ────────────
        // setRowCount(0) elimina todas las filas existentes.
        // Útil si luego quisieras actualizar la tabla sin recrearla.
        modelo.setRowCount(0);

        // Ordenar por puntos de mayor a menor (sin Collections.sort para simplicidad)
        lista.sort((a, b) -> b.getPuntos() - a.getPuntos());

        // ─── BLOQUE 2.11 ─ Añadir filas al modelo ─────────────────────────
        // addRow recibe un Object[]. Cada elemento es una celda.
        // El orden debe coincidir con el orden de columnas definido arriba.
        for (Puntuacion p : lista) {
            Object[] fila = {
                p.getNombre(),
                p.getJuego(),
                p.getPuntos()
            };
            modelo.addRow(fila);
        }

        // Actualizar el label del total
        // ─── BLOQUE 5.3 ─ setText en JLabel ───────────────────────────────
        lblTotal.setText("Total: " + lista.size() + " puntuaciones");

        // Si no hay datos, mostrar mensaje
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "No hay puntuaciones registradas todavía.",
                "Ranking vacío",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
