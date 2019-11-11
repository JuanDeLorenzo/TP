package prog2.TP;

import java.util.ArrayList;
import java.util.List;

public class ActivosRepositorio implements Repositorio<Activo> {
    public static List<Activo> repositorioActivos = new ArrayList<>();

    public ActivosRepositorio(){
        final Zona zona = new Zona("Pilar");
        final TipoDeActivo tipoDeActivo = new TipoDeActivo("Bici",5,10);
        agregar(new Activo(tipoDeActivo, zona));

        final Zona zona1 = new Zona("Moreno");
        final TipoDeActivo tipoDeActivo1 = new TipoDeActivo("Moto",10,20);
        agregar(new Activo(tipoDeActivo1, zona1));

        final Zona zona3 = new Zona("Matanza");
        final TipoDeActivo tipoDeActivo3 = new TipoDeActivo("Auto",20,40);
        agregar(new Activo(tipoDeActivo3, zona3));

        final Zona zona4 = new Zona("Palermo");
        final TipoDeActivo tipoDeActivo4 = new TipoDeActivo("Scooter",8,15);
        agregar(new Activo(tipoDeActivo4, zona4));
    }

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

    public ArrayList<TipoDeActivo> listarTipoDeActivos(){ //
        ArrayList<TipoDeActivo> listaDeTipoDeActivos = new ArrayList<>();
        for (Activo activo: repositorioActivos) {
            for (TipoDeActivo tipoDeActivo:listaDeTipoDeActivos) {
                if (!activo.getTipoDeActivo().equals(tipoDeActivo)){
                    listaDeTipoDeActivos.add(activo.getTipoDeActivo());
                }
            }
        }
        return listaDeTipoDeActivos;
    }
}
