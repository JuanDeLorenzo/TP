package prog2.TP;

import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        ActivosRepositorio activo = new ActivosRepositorio();
        for (Activo activo2 : activo.listarActivosDiferentes()) {
            System.out.println(activo2.getTipoDeActivo().getNombreDelActivo());
        }
    }
}
