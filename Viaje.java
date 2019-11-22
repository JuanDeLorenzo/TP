package prog2.TP;

import java.util.ArrayList;

public class Viaje {
    private Tiempo tiempoDeEntrega;
    private int duracionDelViaje;
    private Terminal terminalDeSalida;
    private Terminal terminalDeEntrega;
    private Activo activoUsado;
    private Puntos puntosOtorgar;
    private Zona zona;
    private int costoDelViaje;
    private Tiempo tiempoDeEntregaEstimado;
    private Descuento descuentoUtilizado;
    private boolean seUtilizoCuponDelMes;


    public Viaje(Activo activoUsado, Tiempo tiempoDeEntregaEstimado) {
        this.activoUsado = activoUsado;
        this.terminalDeSalida = activoUsado.getTerminalActual();
        this.zona = activoUsado.getZona();
        this.tiempoDeEntregaEstimado = tiempoDeEntregaEstimado;
        activoUsado.cambiarEstadoAAlquilado();
    }

        public void finDelViaje(Terminal terminalDeEntrega, int puntos, int duracionDelViaje, Tiempo tiempoDeEntrega){
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
        activoUsado.setTerminalActual(terminalDeEntrega);
        activoUsado.cambiarEstadoANoAlquilado();
    }

    public void terminalEntrega(Terminal terminalDeEntrega){
        if(terminalDeEntrega.getZona() != zona ){
            throw new RuntimeException("La terminal no coincide con la zona del activo");
        }
        activoUsado.setTerminalActual(terminalDeEntrega);
        this.terminalDeEntrega = terminalDeEntrega;
    }

    public int puntosDeViaje(){
        int puntos = duracionDelViaje * activoUsado.getTipoDeActivo().getPuntosPorMinuto();
        if (tiempoDeEntrega.compararTiempo(tiempoDeEntregaEstimado)){
            return (int) (puntos * 1.2);
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




    public Tiempo getTiempoDeEntrega() {
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

    public void siSeUtilizoCuponDelMes() {
        seUtilizoCuponDelMes = true;
    }

    public void noSeUtilizoCuponDelMes(){
        seUtilizoCuponDelMes = false;
    }

    public boolean isSeUtilizoCuponDelMes() {
        return seUtilizoCuponDelMes;
    }
}
