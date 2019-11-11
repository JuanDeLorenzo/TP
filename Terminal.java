package prog2.TP;

import java.util.ArrayList;

public class Terminal {
    private ArrayList<Activo> activos;
    private Zona zona;
    private String nombre;

    public Terminal(Zona zona, String nombre) {
        this.zona = zona;
        this.nombre = nombre;
    }

    public void agregarActivo(Activo activo){
        activos.add(activo);
    }

    public ArrayList<Activo> getActivos() {
        return activos;
    }

    public Zona getZona() {
        return zona;
    }

    public String getNombre() {
        return nombre;
    }
}
