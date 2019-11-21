package prog2.TP;

public class TipoDeActivo {
    private final String nombreDelActivo;
    private final int puntosPorMinuto;
    private final int costoPorMinuto;

    public TipoDeActivo(String nombreDelActivo, int puntosPorMinuto, int costoPorMinuto) {
        this.nombreDelActivo = nombreDelActivo;
        this.puntosPorMinuto = puntosPorMinuto;
        this.costoPorMinuto = costoPorMinuto;
    }

    public String getNombreDelActivo() {
        return nombreDelActivo;
    }

    public int getPuntosPorMinuto() {
        return puntosPorMinuto;
    }

    public int getCostoPorMinuto() {
        return costoPorMinuto;
    }
}
