package prog2.TP;

import java.util.ArrayList;
import java.util.List;

public class ZonasRepositorio implements Repositorio<Zona> {
    public static final List<Zona> repositorioZonas = new ArrayList<>();

    @Override
    public void agregar(Zona instancia) {
        repositorioZonas.add(instancia);
    }

    @Override
    public void eliminar(Zona instancia) {
        repositorioZonas.remove(instancia);
    }

    @Override
    public List<Zona> listar() {
        return repositorioZonas;
    }

    public ArrayList<Terminal> listarTerminales(){
        ArrayList<Terminal> listaTerminales = new ArrayList<>();
        for (Zona zona: repositorioZonas) {
            for (Terminal terminal : listaTerminales) {
                for (int i = 0; i < zona.getTerminales().size(); i++) {
                    if (!zona.getTerminales().get(i).equals(terminal)){
                        listaTerminales.add(zona.getTerminales().get(i));
                    }
                }

            }
        }
        return listaTerminales;
    }
}
