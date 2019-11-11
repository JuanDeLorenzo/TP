package prog2.TP;

import java.util.ArrayList;

public class Descuento {
    private int puntosRequeridos;
    private int porcentajeDeDescuento;

    public Descuento(int puntosRequeridos, int porcentajeDeDescuento) {
        this.puntosRequeridos = puntosRequeridos;
        this.porcentajeDeDescuento = porcentajeDeDescuento;
    }

    public int getPuntosRequeridos() {
        return puntosRequeridos;
    }

    public int getPorcentajeDeDescuento() {
        return porcentajeDeDescuento;
    }


}
