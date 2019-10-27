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

    public Puntos getPuntos(Zona zona) {
        return puntos;
    }
}
