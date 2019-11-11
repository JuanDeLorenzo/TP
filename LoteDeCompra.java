package prog2.TP;

import java.util.ArrayList;

public class LoteDeCompra {
    private ArrayList<Activo> loteDeCompra;
    private int codigoIncremental = 1;
    private int id;
    private Terminal terminal;

    public LoteDeCompra(TipoDeActivo tipoDeActivo, Zona zona, Terminal terminal, int cantidad){
        for (int i = 0; i < cantidad ; i++) {
            loteDeCompra.add(new Activo(tipoDeActivo, zona){});
        }
        for (Activo activo: loteDeCompra) {
            activo.setTerminalDeActual(terminal);
            ActivosRepositorio.repositorioActivos.add(activo);
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
