package prog2.TP;

import java.util.Date;

public class Factura {
    private String tipoDeFactura;
    private int costoDelViaje;
    private int puntosObtenidos;
    private Activo activoUtilizado;
    private Terminal terminalDeSalida;
    private Terminal terminalDeEntrega;
    private Descuento descuentoUtilizado;
    private int duracionDelViaje;


    public Factura(int costoDelViaje, int puntosObtenidos, Activo activoUtilizado, Terminal terminalDeSalida, Terminal terminalDeEntrega, Descuento descuentoUtilizado, int duracionDelViaje) { //En caso de un viaje.
        tipoDeFactura = "Viaje";
        this.costoDelViaje = costoDelViaje;
        this.puntosObtenidos = puntosObtenidos;
        this.activoUtilizado = activoUtilizado;
        this.terminalDeSalida = terminalDeSalida;
        this.terminalDeEntrega = terminalDeEntrega;
        this.descuentoUtilizado = descuentoUtilizado;
        this.duracionDelViaje = duracionDelViaje;
    }

    public Factura(int valorDeLaMulta){ //En caso de que sea una multa.
        tipoDeFactura = "Multa";
        costoDelViaje = valorDeLaMulta;
    }

    public int getCostoDelViaje() {
        return costoDelViaje;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public Activo getActivoUtilizado() {
        return activoUtilizado;
    }

    public Terminal getTerminalDeSalida() {
        return terminalDeSalida;
    }

    public Terminal getTerminalDeEntrega() {
        return terminalDeEntrega;
    }

    public int getDuracionDelViaje() {
        return duracionDelViaje;
    }

    public String getTipoDeFactura() {
        return tipoDeFactura;
    }

    public void mostrarFactura(){
        if (tipoDeFactura == "Viaje"){
            System.out.println ("Tipo de factura : " + tipoDeFactura + "\n" +
                    "Precio final : " + costoDelViaje + "\n" +
                    "Puntos obtenido : " + puntosObtenidos + "\n" +
                    "Activo utilizado : " + activoUtilizado.getTipoDeActivo().getTipoDeActivo() + "\n" +
                    "Terminal de salida : " + terminalDeSalida.getNombre() + "\n" +
                    "Terminal de entrega : " + terminalDeEntrega.getNombre() + "\n" +
                    "Porcentaje de descuento : " + descuentoUtilizado.getPorcentajeDeDescuento() + "\n" +
                    "Duracion del Viaje : "+ duracionDelViaje);
        }else{
            System.out.println ("Tipo de factura : " + tipoDeFactura + "\n" +
                    "Precio de la multa : " + costoDelViaje);
        }
    }
}
