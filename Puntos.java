package prog2.TP;

public class Puntos {
    Zona zona;
    int puntosUsados;
    int puntosTotales;

    public Puntos(Zona zona){
        this.zona = zona;
        this.puntosUsados = 0;
        this.puntosTotales = 0;
    }

    public Zona getZona() {
        return zona;
    }

    public int getPuntosUsados() {
        return puntosUsados;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }
}
