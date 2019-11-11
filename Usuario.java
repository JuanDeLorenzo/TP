package prog2.TP;

import java.util.ArrayList;
import java.util.Date;

public abstract class Usuario {
    private final int numeroDeTelefono;
    private ArrayList<Puntos> puntosDelUsuario;
    private boolean estaBloqueado;
    private String Alias;
    private Activo activoAlquilado;
    private ArrayList<Factura> facturas;
    private boolean cuponDelMes;
    private final String constrasena;

    public Usuario(int numeroDeTelefono, String Alias, String constrasena) {
        this.numeroDeTelefono= numeroDeTelefono;
        this.estaBloqueado = false;
        this.Alias = Alias;
        cuponDelMes = false;
        facturas = new ArrayList<>();
        puntosDelUsuario = new ArrayList<>();
        this.constrasena = constrasena;
    }

    public void agregarFactura(Factura factura){
        facturas.add(factura);
    }

    public Puntos getPuntos(Zona zona){
        for (Puntos puntosZona:puntosDelUsuario) {
            if (puntosZona.getZona() == zona){
                return puntosZona;
            }
        }
        agregarZonaDePuntos(zona);
        return getPuntos(zona);
    }

    public String getAlias() {
        return Alias;
    }

    public void agregarZonaDePuntos(Zona zona){
        puntosDelUsuario.add(new Puntos(zona));
    }

    public void iniciarViaje(Activo activo, Date horaDeEntregaEstimada){
        if (activo.isEstaAlquilado() == true){
            throw new RuntimeException("El activo esta alquilado");
        }
        if (isEstaBloqueado() == true){
            throw new RuntimeException("El usuario esta bloqueado");
        }
        activo.setViaje(new Viaje(activo, horaDeEntregaEstimada));
    }

    public void alquilarActivo(Activo activo, Date horaDeEntregaEstimada){
        activoAlquilado = activo;
        iniciarViaje(activo, horaDeEntregaEstimada);
    }

    public void entregaActivo(Terminal terminalDeEntrega){
        activoAlquilado.getViaje().finDelViaje(terminalDeEntrega, getPuntos(activoAlquilado.getZona()).getPuntosParaDescuento());
        getPuntos(activoAlquilado.getZona()).sumarPuntos(activoAlquilado.getViaje().getPuntosOtorgar());
        aplicarCuponDelMes();
        Factura factura = new Factura(activoAlquilado.getViaje().getCostoDelViaje(), activoAlquilado.getViaje().getPuntosOtorgar().getPuntosTotales(), activoAlquilado, activoAlquilado.getViaje().getTerminalDeSalida(), activoAlquilado.getViaje().getTerminalDeEntrega(), activoAlquilado.getViaje().getDescuentoUtilizado(),activoAlquilado.getViaje().getTiempoDeSalida());
        activoAlquilado = null;
        agregarFactura(factura);
    }

    public void aplicarCuponDelMes(){
        if(cuponDelMes == true){
            activoAlquilado.getViaje().setCostoDelViaje((int)(activoAlquilado.getViaje().getCostoDelViaje() * 0.5));
        }
    }


    public void darCuponDelMes() {
        cuponDelMes = true;
    }

    public void sacarCuponDelMes(){
        cuponDelMes = false;
    }

    public ArrayList<Puntos> getPuntosDelUsuario() {
        return puntosDelUsuario;
    }

    public boolean isEstaBloqueado() {
        return estaBloqueado;
    }

    public int getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void bloquear() {
        estaBloqueado = true;
    }

    public void desbloquear(){
        estaBloqueado = false;
    }

    public Activo getActivoAlquilado() {
        return activoAlquilado;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public boolean isCuponDelMes() {
        return cuponDelMes;
    }

    public String getConstrasena() {
        return constrasena;
    }
}

