package prog2.TP;

import java.util.ArrayList;
import java.util.List;

public class ActivosRepositorio implements Repositorio<Activo> {
    public static final List<Activo> repositorioActivos = new ArrayList<>();

    @Override
    public void agregar(Activo instancia) {
        repositorioActivos.add(instancia);
    }

    @Override
    public void eliminar(Activo instancia) {
        repositorioActivos.remove(instancia);
    }

    @Override
    public List<Activo> listar() {
        return repositorioActivos;
    }
}
