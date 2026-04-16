public class Main {
    public static void main(String[] args) {
        // Sesión: Cajero Automático — 2026-04-16

        CajeroAutomatico cajero = new CajeroAutomatico();

        // Prueba 1: sacar 240€ (esperado: {0,1,0,0,2,0,0})
        cajero.sacar(240);

        // Prueba 2: sacar 130€
        cajero.sacar(130);
    }
}
