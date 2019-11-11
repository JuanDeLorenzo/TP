package prog2.TP;

import java.util.ArrayList;
import java.util.List;

public class AdministradoresRepositorio implements Repositorio<Administrador> {
    private final List<Administrador> repositorioAdministradores = new ArrayList<>();

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
