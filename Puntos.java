package prog2.TP;

public class Puntos {
    Zona zona;
    int puntosParaDescuento;
    int puntosTotales;

    public Puntos(Zona zona){
        this.zona = zona;
        this.puntosParaDescuento = 0;
        this.puntosTotales = 0;
    }

    public void sumarPuntos(Puntos puntos) {
        this.puntosParaDescuento += puntos.getPuntosParaDescuento();
        this.puntosTotales += puntos.getPuntosTotales();
    }

    public void sumarPuntosParaDescuento(int puntosParaDescuento){
        this.puntosParaDescuento += puntosParaDescuento;
    }

    public void sumarPuntosTotales(int puntosTotales){
        this.puntosTotales += puntosTotales;
    }

    public Zona getZona() {
        return zona;
    }

    public int getPuntosParaDescuento() {
        return puntosParaDescuento;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public void setPuntosParaDescuento(int puntosParaDescuento) {
        this.puntosParaDescuento = puntosParaDescuento;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    public void resetearPuntos(){
        puntosTotales = 0;
        puntosParaDescuento = 0;
    }
}
