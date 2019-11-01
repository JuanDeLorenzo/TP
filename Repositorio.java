package prog2.TP;

import java.util.List;

public interface Repositorio <T> {

    void agregar(T instancia);
    void eliminar(T instancia);
    List<T> listar();
}
