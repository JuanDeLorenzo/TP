package prog2.TP;

import java.util.ArrayList;
import java.util.List;

public class ClientesRepositorio implements Repositorio<Cliente> {
    public static ArrayList<Cliente> repositorioClientes = new ArrayList<>();

    public ClientesRepositorio(){
        agregar(new Cliente(1137581006, "Juan", "juan"));
        agregar(new Cliente(1145879875, "Peto", "peto"));
        agregar(new Cliente(1154897875, "Gonza", "gonza"));
    }


    @Override
    public void agregar(Cliente instancia) {
        repositorioClientes.add(instancia);
    }

    @Override
    public void eliminar(Cliente instancia) {
        repositorioClientes.remove(instancia);
    }

    @Override
    public ArrayList<Cliente> listar() {
        return repositorioClientes;
    }
}
