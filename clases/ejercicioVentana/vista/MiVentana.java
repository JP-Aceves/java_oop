package clases.ejercicioVentana.vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clases.ejercicioVentana.control.Controlador;

public class MiVentana extends JFrame{
    public Controlador controlador;
    public JButton miBoton;
    public JButton miOtroBoton;
    public JButton miOtroBoton2;

    public void crearVista(){
        miBoton = new JButton("Panel Administrador");
        miOtroBoton = new JButton("Ver Juegos");
        miOtroBoton2 = new JButton("Ver Estadisticas");

        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(miBoton);
        this.getContentPane().add(miOtroBoton);
        this.getContentPane().add(miOtroBoton2);
        this.getContentPane().add(miOtroBoton2);
    

        miBoton.setActionCommand("ADMIN");
        miBoton.addActionListener(controlador);
        miOtroBoton.setActionCommand("JUEGOS");
        miOtroBoton.addActionListener(controlador);
        miOtroBoton2.setActionCommand("ESTADISTICAS");
        miOtroBoton2.addActionListener(controlador);


        this.setSize(500, 300);           // ancho x alto                                                                                                                
        this.setLocation(200, 100);       // posición en pantalla (x, y)                                                                                                 
        this.setResizable(false);         // que no se pueda redimensionar         
        this.setTitle("Menu Principal");                                                                                      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar app al cerrar ventana     


        this.setVisible(true);


    }
}
