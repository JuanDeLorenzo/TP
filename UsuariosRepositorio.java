package prog2.TP;

import java.util.ArrayList;
import java.util.List;

public class UsuariosRepositorio implements Repositorio<Usuario> {
    public static final List<Usuario> repositorioUsuarios = new ArrayList<>();

    @Override
    public void agregar(Usuario instancia) {
        repositorioUsuarios.add(instancia);
    }

    @Override
    public void eliminar(Usuario instancia) {
        repositorioUsuarios.remove(instancia);
    }

    @Override
    public List<Usuario> listar() {
        return repositorioUsuarios;
    }
}
