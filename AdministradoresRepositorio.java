package prog2.TP;

import java.util.ArrayList;
import java.util.List;

public class AdministradoresRepositorio implements Repositorio<Administrador> {
    private final List<Administrador> repositorioAdministradores = new ArrayList<>();

    public AdministradoresRepositorio(){
        agregar(new Administrador(1137581006, "Juan", "juan"));
        agregar(new Administrador(1145879875, "Peto", "peto"));
        agregar(new Administrador(1154897875, "Gonza", "gonza"));
    }

    @Override
    public void agregar(Administrador instancia) {
        repositorioAdministradores.add(instancia);
    }

    @Override
    public void eliminar(Administrador instancia) {
        repositorioAdministradores.remove(instancia);
    }

    @Override
    public List<Administrador> listar() {
        return repositorioAdministradores;
    }
}
