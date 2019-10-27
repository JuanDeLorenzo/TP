package prog2.TP;

public abstract class Activo {
    private final int costoPorMinuto;
    private final int puntosPorMinuto;
    private final Zona zona;
    private boolean estaAlquilado;

    public Activo(int costoPorMinuto, int puntosPorMinuto, Zona zona){
        this.costoPorMinuto = costoPorMinuto;
        this.zona = zona;
        this.estaAlquilado = false;
        this.puntosPorMinuto = puntosPorMinuto;
    }

    public int tarifarioPorMinuto(int minutos){
        return costoPorMinuto*minutos + zona.valorZona*minutos;
    }

    public int puntosOtorgar(int minutos){
        return puntosPorMinuto*minutos;
    }

    public static void calucularDescuento(){

    }

}
