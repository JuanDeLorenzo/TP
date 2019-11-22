package prog2.TP;

import java.util.ArrayList;

public class LoteDeCompra {
    private ArrayList<Activo> loteDeCompra = new ArrayList<>();
    private int codigoIncremental = 1;
    private int id;
    private Terminal terminal;

    public LoteDeCompra(TipoDeActivo tipoDeActivo, Zona zona, Terminal terminal, int cantidad){
        this.terminal = terminal;
        for (int i = 0; i < cantidad ; i++) {
            loteDeCompra.add(new Activo(tipoDeActivo, zona));
        }
        for (Activo activo : loteDeCompra) {
            activo.setTerminalActual(terminal);
        }

        id = codigoIncremental;
        codigoIncremental++;
    }

    public ArrayList<Activo> getLoteDeCompra() {
        return loteDeCompra;
    }

    public int getId() {
        return id;
    }


}
