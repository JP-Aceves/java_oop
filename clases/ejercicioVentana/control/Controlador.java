package clases.ejercicioVentana.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clases.ejercicioVentana.vista.MiVentana;

public class Controlador implements ActionListener{

    MiVentana miVentana;

    public Controlador(MiVentana miVentana) {
        this.miVentana = miVentana;
    }

    public void actionPerformed (ActionEvent e){
        switch (e.getActionCommand()) {
            case "ADMIN":
                System.out.println("Acceso a Panel Administrador");
                break;
            case "JUEGOS":
                System.out.println("Acceso a Juegos");
                break;
            case "ESTADISTICAS":
                System.out.println("Acceso a Estadisticas");
                break;
            default:
                break;
        }
    }

    
}
