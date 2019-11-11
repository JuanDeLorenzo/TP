package prog2.TP;

import java.util.ArrayList;
import java.util.Date;

public class Viaje {
    private int tiempoDeEntrega;
    private int duracionDelViaje;
    private Terminal terminalDeSalida;
    private Terminal terminalDeEntrega;
    private Activo activoUsado;
    private Puntos puntosOtorgar;
    private Zona zona;
    private int costoDelViaje;
    private int tiempoDeEntregaEstimado;
    private Descuento descuentoUtilizado;


    public Viaje(Activo activoUsado, int tiempoDeEntregaEstimado) {
        this.activoUsado = activoUsado;
        this.terminalDeSalida = activoUsado.getTerminalDeActual();
        this.zona = activoUsado.getZona();
        this.tiempoDeEntregaEstimado = tiempoDeEntregaEstimado;
        activoUsado.cambiarEstadoAAlquilado();
    }

    public void finDelViaje(Terminal terminalDeEntrega, int puntos, int duracionDelViaje, int tiempoDeEntrega){
        terminalEntrega(terminalDeEntrega);
        this.duracionDelViaje = duracionDelViaje;
        this.tiempoDeEntrega = tiempoDeEntrega;
        int puntosDelViaje = puntosDeViaje();
        int costoDelViaje = calcularCostoDeViaje(puntos);
        Puntos puntosParaUsuario = new Puntos(zona);
        puntosParaUsuario.sumarPuntosTotales(puntosDelViaje);
        puntosParaUsuario.sumarPuntosParaDescuento(puntosDelViaje);
        puntosOtorgar = puntosParaUsuario;
        this.costoDelViaje = costoDelViaje;
        activoUsado.setTerminalDeActual(terminalDeEntrega);
    }

    public void terminalEntrega(Terminal terminalDeEntrega){
        if(terminalDeEntrega.getZona() != zona ){
            throw new RuntimeException("La terminal no coincide con la zona del activo");
        }
        activoUsado.setTerminalDeActual(terminalDeEntrega);
    }

    public int puntosDeViaje(){
        int puntos = duracionDelViaje * activoUsado.getTipoDeActivo().getPuntosPorMinuto();
        if (tiempoDeEntrega == tiempoDeEntregaEstimado){
            return (int) (puntos * 0.2);
        }
        return puntos;
    }


    public int calcularCostoDeViaje(int puntos){
        Descuento descuento = descuentoOptimo(puntos);
        descuentoUtilizado = descuento;
        return duracionDelViaje * activoUsado.getTipoDeActivo().getCostoPorMinuto() * (1-descuento.getPorcentajeDeDescuento()/100);
    }

    public Descuento descuentoOptimo(int puntos) {
        ArrayList<Descuento> nuevoDescuentos = new ArrayList<>();
        for (Descuento unDescuento: activoUsado.getDescuentos()) {
            if (unDescuento.getPuntosRequeridos() <= puntos){
                nuevoDescuentos.add(unDescuento);
            }

        }
        nuevoDescuentos.sort((Descuento a, Descuento b) -> b.getPuntosRequeridos() - a.getPuntosRequeridos());
        if (nuevoDescuentos.size() > 0){
            return nuevoDescuentos.get(0);
        }else {
            return new Descuento(0,0);
        }
    }




    public int getTiempoDeEntrega() {
        return tiempoDeEntrega;
    }

    public Zona getZona() {
        return zona;
    }

    public Puntos getPuntosOtorgar() {
        return puntosOtorgar;
    }

    public void setPuntosOtorgar(Puntos puntosOtorgar) {
        this.puntosOtorgar = puntosOtorgar;
    }

    public int getCostoDelViaje() {
        return costoDelViaje;
    }

    public void setCostoDelViaje(int costoDelViaje) {
        this.costoDelViaje = costoDelViaje;
    }

    public Terminal getTerminalDeSalida() {
        return terminalDeSalida;
    }

    public Terminal getTerminalDeEntrega() {
        return terminalDeEntrega;
    }

    public Descuento getDescuentoUtilizado() {
        return descuentoUtilizado;
    }

    public int getDuracionDelViaje() {
        return duracionDelViaje;
    }
}
