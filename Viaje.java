package prog2.TP;

import java.util.ArrayList;
import java.util.Date;

public class Viaje {
    private Date tiempoDeSalida;
    private Date tiempoDeEntrega;
    private Terminal terminalDeSalida;
    private Terminal terminalDeEntrega;
    private Activo activoUsado;
    private Puntos puntosOtorgar;
    private Zona zona;
    private int costoDelViaje;
    private Date tiempoDeEntregaPorElUsuario;
    private Descuento descuentoUtilizado;


    public Viaje(Activo activoUsado, Date tiempoDeEntregaPorElUsuario) {
        this.tiempoDeSalida = new Date();
        this.activoUsado = activoUsado;
        this.terminalDeSalida = activoUsado.getTerminalDeActual();
        this.zona = activoUsado.getZona();
        this.tiempoDeEntregaPorElUsuario = tiempoDeEntregaPorElUsuario;
        activoUsado.cambiarEstadoAAlquilado();
    }

    public void finDelViaje(Terminal terminalDeEntrega, int puntos){
        terminalEntrega(terminalDeEntrega);
        Date tiempoDeEntrega = new Date();
        setTiempoDeEntrega(tiempoDeEntrega);
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
        int puntos = tiempoDeSalida.getMinutes() * activoUsado.getTipoDeActivo().getPuntosPorMinuto();
        if (tiempoDeEntrega.compareTo(this.tiempoDeEntregaPorElUsuario) <= 0){
            return (int) (puntos * 0.2);
        }
        return puntos;
    }


    public int calcularCostoDeViaje(int puntos){
        Descuento descuento = descuentoOptimo(puntos);
        descuentoUtilizado = descuento;
        return costoDelViaje * (1-descuento.getPorcentajeDeDescuento()/100);
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



    public Date getTiempoDeSalida() {
        return tiempoDeSalida;
    }

    public Date getTiempoDeEntrega() {
        return tiempoDeEntrega;
    }

    public void setTiempoDeEntrega(Date tiempoDeEntrega) {
        this.tiempoDeEntrega = tiempoDeEntrega;
    }

    public void setTerminalDeEntrega(Terminal terminalDeEntrega) {
        this.terminalDeEntrega = terminalDeEntrega;
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
}
