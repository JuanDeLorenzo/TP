package prog2.TP;


public class Terminal {
    private Zona zona;
    private String nombre;

    public Terminal(Zona zona, String nombre) {
        this.zona = zona;
        this.nombre = nombre;
    }

    public Zona getZona() {
        return zona;
    }

    public String getNombre() {
        return nombre;
    }
}
