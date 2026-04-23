import java.util.Scanner;

public class Saludo {
    public static int validarVeces(String veces) throws NumberFormatException{
        int v = Integer.parseInt(veces);
        return v;
    }

    public static void main(String[] args) {
        Scanner sc;
        int veces;
        String nombre;
        sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        nombre = sc.next();
        System.out.println("Veces: ");
        try {
            veces = Saludo.validarVeces(sc.next());
        } catch (NumberFormatException e) {
            System.err.println("Número de veces incorrecto. Saludo tres veces por defecto");
            veces = 3;
        }
        sc.close();
        for (int i = 0; i < veces; i++) {
            System.out.println("Hola " + nombre);
        }
        System.out.println("Seguimos");
    }
}