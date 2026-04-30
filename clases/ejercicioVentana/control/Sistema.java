package clases.ejercicioVentana.control;

import clases.ejercicioVentana.vista.MiVentana;

public class Sistema {
    public static void main(String[] args) {
        MiVentana mainFrame = new MiVentana();
        Controlador mc = new Controlador(mainFrame);
        mainFrame.controlador = mc;
        mainFrame.crearVista();
    }
}
