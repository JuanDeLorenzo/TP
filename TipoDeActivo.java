package prog2.TP;

public class TipoDeActivo {
    private final String tipoDeActivo;
    private final int puntosPorMinuto;
    private final int costoPorMinuto;

    public TipoDeActivo(String tipoDeActivo, int puntosPorMinuto, int costoPorMinuto) {
        this.tipoDeActivo = tipoDeActivo;
        this.puntosPorMinuto = puntosPorMinuto;
        this.costoPorMinuto = costoPorMinuto;
    }

    public String getTipoDeActivo() {
        return tipoDeActivo;
    }

    public int getPuntosPorMinuto() {
        return puntosPorMinuto;
    }

    public int getCostoPorMinuto() {
        return costoPorMinuto;
    }
}
