public enum HorasEntrega {
    
    URGENTE(24),
    NORMAL(48),
    ESTANDAR(72);

    private final int horas;

    HorasEntrega(int horas) {
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }
}
