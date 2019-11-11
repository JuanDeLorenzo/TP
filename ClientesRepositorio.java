package prog2.TP;

import java.util.ArrayList;
import java.util.List;

public class ClientesRepositorio implements Repositorio<Cliente> {
    public static ArrayList<Cliente> repositorioClientes = new ArrayList<>();


    @Override
    public void agregar(Cliente instancia) {
        repositorioClientes.add(instancia);
    }

    @Override
    public void eliminar(Cliente instancia) {
        repositorioClientes.remove(instancia);
    }

    @Override
    public List<Cliente> listar() {
        return repositorioClientes;
    }
}
