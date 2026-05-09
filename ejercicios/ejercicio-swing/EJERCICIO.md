# Ejercicio Completo de Swing — MiniRegistro de Puntuaciones

Mini-app con 4 ventanas que toca TODOS los conceptos del estudio.
Temáticamente igual que tu proyecto: login, menú, añadir datos, ver tabla.

---

## Qué ventana cubre qué bloque

| Ventana | Bloques que cubre |
|---|---|
| `VentanaLogin` | 1 (JFrame), 2 (componentes básicos), 3 (GridLayout+BorderLayout), 4 (ActionListener+KeyListener+WindowListener), 5 (leer campos), 6 (navegación), 7 (JOptionPane) |
| `VentanaMenu` | 1, 2, 3 (BorderLayout), 4 (ActionListener), 6 (navegación) |
| `VentanaAgregar` | 1 (JDialog modal), 2, 3 (GridLayout), 4, 5 (leer/escribir), 6 (modal) |
| `VentanaRanking` | 2 (JTable+JScrollPane+DefaultTableModel), 3, 4, 5 (leer tabla), 7 |

---

## Cómo ejecutarlo

1. Copia los 5 archivos en un proyecto Java nuevo
2. Ejecuta `MainEjercicio.java`
3. Usuario: `admin` — Contraseña: `1234`

---

## Qué hacer después de que funcione

Modifica estas cosas una por una para entender cada pieza:

1. Cambia `GridLayout(3, 2)` por `FlowLayout` en VentanaLogin → ¿qué pasa?
2. Quita el `modal = true` del JDialog → ¿puedes hacer clic en el menú mientras el diálogo está abierto?
3. Cambia `dispose()` por `setVisible(false)` en VentanaLogin → ¿qué diferencia hay?
4. Quita `new JScrollPane(tabla)` y pon `tabla` directamente → ¿dónde van las cabeceras?
5. Añade un tercer usuario válido en VentanaLogin
6. Haz que el botón "Añadir" esté deshabilitado hasta que se escriba algo en el campo nombre
