package prog2.TP;

import java.util.ArrayList;
import java.util.List;

public class ZonasRepositorio implements Repositorio<Zona> {
    public static List<Zona> repositorioZonas = new ArrayList<>();

    public  ZonasRepositorio(){
        agregar(new Zona("Pilar"));
        agregar(new Zona("Palermo"));
        agregar(new Zona("Matanza"));
        agregar(new Zona("Moreno"));
    }

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

    public Zona getZona(Zona zona){
        for (Zona zona2 :repositorioZonas) {
            if (zona.equals(zona2)){
                return zona2;
            }
        }
        throw new RuntimeException("No existe esa zona en el sistema");
    }

    public ArrayList<Terminal> listarTerminales(){
        ArrayList<Terminal> listaTerminales = new ArrayList<>();
        for (Zona zona: repositorioZonas) {
            for (int i = 0; i < zona.getTerminales().size(); i++) {
                listaTerminales.add(zona.getTerminales().get(i));
            }
        }
        return listaTerminales;
    }

    public ArrayList<Terminal> listarTerminales(Zona zona){
        ArrayList<Terminal> listaTerminales = new ArrayList<>();
        for (Zona zona2: repositorioZonas) {
            if (zona2.equals(zona)){
                for (int i = 0; i < zona.getTerminales().size(); i++) {
                    listaTerminales.add(zona.getTerminales().get(i));
                }
            }
        }
        return listaTerminales;
    }
}
