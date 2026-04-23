package clases.ejercicioCajero.src.model;
import javax.swing.JOptionPane;

public class Sistema {

    static final int[] DENOMINACIONES = {500, 200, 100, 50, 20, 10, 5};

    public static void main(String[] args) {
        Cajero cajero = new Cajero();
        String[] opciones = {"Ver saldo", "Sacar dinero", "Ver billetes", "Salir"};

        while (true) {
            int opcion = JOptionPane.showOptionDialog(
                null,
                "Saldo actual: " + cajero.getSaldo() + "€\n¿Qué deseas hacer?",
                "Cajero Automático",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            // X o cerrar ventana
            if (opcion == -1 || opcion == 3) break;

            switch (opcion) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saldo actual: " + cajero.getSaldo() + "€");
                    break;

                case 1:
                    String input = JOptionPane.showInputDialog("¿Cuánto dinero deseas sacar? (múltiplo de 5)");

                    if (input == null || input.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada.");
                        break;
                    }

                    try {
                        int dineroASacar = Integer.parseInt(input.trim());
                        boolean exito = cajero.sacarDinero(dineroASacar);

                        if (exito) {
                            JOptionPane.showMessageDialog(
                                null,
                                "Operación realizada.\nSaldo restante: " + cajero.getSaldo() + "€"
                            );
                        } else {
                            JOptionPane.showMessageDialog(
                                null,
                                "No se pudo realizar la operación.\nVerifica que el importe sea válido (múltiplo de 5, no supere el saldo)."
                            );
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido.");
                    }
                    break;

                case 2:
                    int[] cantidades = cajero.getBilletes();
                    StringBuilder info = new StringBuilder("Billetes disponibles:\n");
                    for (int i = 0; i < DENOMINACIONES.length; i++) {
                        info.append("  ").append(DENOMINACIONES[i]).append("€ → ").append(cantidades[i]).append(" billetes\n");
                    }
                    JOptionPane.showMessageDialog(null, info.toString());
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, "Hasta pronto.");
    }
}
