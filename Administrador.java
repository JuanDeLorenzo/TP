package prog2.TP;

import java.util.ArrayList;

public class Administrador extends Usuario{
    ArrayList<Activo> activos;

    public Administrador(int telefono, String alias) {
        super(telefono,alias);
    }

    public void MultarUsuario(Usuario usuario){
        bloquearUsuario(usuario);
    }

    public static void comprarActivos(Activo activo, int cantidad){
    }


}

