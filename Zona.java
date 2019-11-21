package prog2.TP;

import java.util.ArrayList;

public class Zona {
    private final String nombreZona;
    private ArrayList<Terminal> terminales;

    public Zona(String nombreZona){
        this.nombreZona = nombreZona;
        terminales = new ArrayList<>();
    }

    public void agregarTerminal(Terminal terminal){ //eliminar terminal, excepcion si ya esta repetida.
        terminales.add(terminal);
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public ArrayList<Terminal> getTerminales() {
        return terminales;
    }

}
