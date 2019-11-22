package prog2.TP;


public class Factura {
    private String tipoDeFactura;
    private int costoDelViaje;
    private int puntosObtenidos;
    private Activo activoUtilizado;
    private Terminal terminalDeSalida;
    private Terminal terminalDeEntrega;
    private Descuento descuentoUtilizado;
    private int duracionDelViaje;
    private boolean seUtilizoCuponDelMes;


    public Factura(int costoDelViaje, int puntosObtenidos, Activo activoUtilizado, Terminal terminalDeSalida, Terminal terminalDeEntrega, Descuento descuentoUtilizado, int duracionDelViaje, boolean seUtilizoCuponDelMes) { //En caso de un viaje.
        tipoDeFactura = "Viaje";
        this.costoDelViaje = costoDelViaje;
        this.puntosObtenidos = puntosObtenidos;
        this.activoUtilizado = activoUtilizado;
        this.terminalDeSalida = terminalDeSalida;
        this.terminalDeEntrega = terminalDeEntrega;
        this.descuentoUtilizado = descuentoUtilizado;
        this.duracionDelViaje = duracionDelViaje;
        this.seUtilizoCuponDelMes = seUtilizoCuponDelMes;
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
                    "Activo utilizado : " + activoUtilizado.getTipoDeActivo().getNombreDelActivo() + "\n" +
                    "Terminal de salida : " + terminalDeSalida.getNombre() + "\n" +
                    "Terminal de entrega : " + terminalDeEntrega.getNombre() + "\n" +
                    "Porcentaje de descuento : " + descuentoUtilizado.getPorcentajeDeDescuento() + "\n" +
                    "Cupon del mes: " + cuponDelMes() + "\n" +
                    "Duracion del viaje en minutos : "+ duracionDelViaje);
        }else{
            System.out.println ("Tipo de factura : " + tipoDeFactura + "\n" +
                    "Precio de la multa : " + costoDelViaje);
        }
    }

    public String cuponDelMes(){
        if (seUtilizoCuponDelMes){
            return "Se utilizo un cupon del mes";
        }else{
            return "No se utilizo cupon del mes";
        }
    }
}
