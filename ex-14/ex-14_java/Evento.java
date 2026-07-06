public class Evento {
    public static final int Escape = 256;
    public static final int R = 82;

    private boolean fechado;
    private Integer codigoTecla;

    public Evento() {
        this.fechado = false;
        this.codigoTecla = null;
    }

    public boolean isClosed() {
        return fechado;
    }

    public Integer getKeyPressed() {
        return codigoTecla;
    }
}
