package prog2.TP;

import java.util.ArrayList;

public class Activo {
    private final TipoDeActivo tipoDeActivo;
    private final Zona zona;
    private boolean estaAlquilado;
    private ArrayList<Descuento> descuentos;
    private Viaje viaje;
    private final int id;
    private int codigoIncremental = 1;
    private Terminal terminalActual;
    private LoteDeCompra loteDeCompra;


    public Activo(TipoDeActivo tipoDeActivo, Zona zona){
        this.tipoDeActivo = tipoDeActivo;
        this.zona = zona;
        this.estaAlquilado = false;
        descuentos = new ArrayList<>();
        id = codigoIncremental;
        codigoIncremental++;

    }

    public ArrayList<Descuento> getDescuentos() {
        return descuentos;
    }

    public void agregarDescuento(Descuento descuento){
        descuentos.add(descuento);
    }

    public TipoDeActivo getTipoDeActivo() {
        return tipoDeActivo;
    }

    public Zona getZona() {
        return zona;
    }

    public Terminal getTerminalActual() {
        return terminalActual;
    }

    public void setTerminalActual(Terminal terminalDeActual) {
        this.terminalActual = terminalDeActual;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public void cambiarEstadoAAlquilado() {
        this.estaAlquilado = true;
    }

    public void cambiarEstadoANoAlquilado() {
        this.estaAlquilado = false;
    }

    public boolean isEstaAlquilado() {
        return estaAlquilado;
    }

    public LoteDeCompra getLoteDeCompra() {
        return loteDeCompra;
    }

    public void setLoteDeCompra(LoteDeCompra loteDeCompra) {
        this.loteDeCompra = loteDeCompra;
    }

    public String toString(){
        return tipoDeActivo.getNombreDelActivo()+ " " + id;
    }
}
