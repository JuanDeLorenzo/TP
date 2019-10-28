package prog2.TP;

import java.util.ArrayList;

public abstract class Usuario {
    private final int telefono;
    private ArrayList<Puntos> puntos;
    private boolean estaBloqueado;
    private String Alias;

    public Usuario(int telefono, String Alias) {
        this.telefono = telefono;
        this.estaBloqueado = false;
        this.Alias = Alias;
    }

    public static void bloquearUsuario(Usuario usuario){
        usuario.estaBloqueado = true;
    }

    public static void desbloquearUsuario(Usuario usuario){
        usuario.estaBloqueado = false;
    }

    public int getPuntos(Zona zona){
        int puntosZona = 0;
        for (int i = 0; i < puntos.size() ; i++) {
            if(puntos.get(i).getZona() == zona){
                puntosZona = puntos.get(i).getPuntosTotales();
            }
        }
        return puntosZona;
    }

    public String getAlias() {
        return Alias;
    }

    public void agregarZonaDePuntos(Zona zona){
        puntos.add(new Puntos(zona));
    }



}
