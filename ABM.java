package prog2.TP;

public class ABM {

    //ABM Usuarios

    public static void altaUsuario(Usuario usuario){
        UsuariosRepositorio.repositorioUsuarios.add(usuario);
    }

    public static void bajaUsuario(Usuario usuario){
        UsuariosRepositorio.repositorioUsuarios.remove(usuario);
    }

    public static void modificarUsuario(){
    }

    //ABM Activos

    public static void altaActivo(Activo activo){
        ActivosRepositorio.repositorioActivos.add(activo);
    }

    public static void bajaActivo(Activo activo){
        ActivosRepositorio.repositorioActivos.remove(activo);
    }

    public static void modificarActivo(){
    }

    //ABM Zonas

    public static void altaZona(Zona zona){
        ZonasRepositorio.repositorioZonas.add(zona);
    }

    public static void bajaZona(Zona zona){
        ZonasRepositorio.repositorioZonas.remove(zona);
    }

    public static void modificarZona(){
    }

}
