public enum Importancia {
    BAJA(1), MEDIA(2), ALTA(3);

    private final int nivel;

    Importancia(int nivel) { this.nivel = nivel; }

    public int getNivel() { return nivel; }
}
