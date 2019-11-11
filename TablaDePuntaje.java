package prog2.TP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TablaDePuntaje {
    private Zona zona;
    private HashMap<String, Integer> tabla;
    private ArrayList<Cliente> topTres;

    public TablaDePuntaje(Zona zona, ArrayList<Cliente> usuarios) {
        this.zona = zona;
        ordenarPuntaje(zona, usuarios);
        topTres = crearTopTres(usuarios);
        tabla = crearHashMapTopDiez(usuarios, zona);

    }

    public void entregarCuponDeDescuento(){
        for (Cliente usuario : topTres) {
            usuario.darCuponDelMes();
        }
    }

    public ArrayList<Cliente> crearTopTres(ArrayList<Cliente> usuarios){
        ArrayList<Cliente> topTres = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            topTres.add(usuarios.get(i));
        }
        return topTres;
    }

    public void ordenarPuntaje(Zona zona, ArrayList<Cliente> usuarios) {
        usuarios.sort((Cliente a, Cliente b) -> b.getPuntos(zona).getPuntosTotales() - a.getPuntos(zona).getPuntosTotales());
    }

    public HashMap<String, Integer> crearHashMapTopDiez(ArrayList<Cliente> usuarios, Zona zona) {
        HashMap<String, Integer> tabla = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            tabla.put(usuarios.get(i).getAlias(), usuarios.get(i).getPuntos(zona).getPuntosTotales());
        }
        return tabla;
    }

    public void printLeaderBoard() {
        AtomicInteger contador = new AtomicInteger(1);
        tabla.forEach((Alias,Puntos) -> System.out.println(contador.getAndIncrement() + ") Usuario: " + Alias + ", Puntos: " + Puntos));
    }

    public Zona getZona() {
        return zona;
    }

    public HashMap<String, Integer> getTabla() {
        return tabla;
    }

    public ArrayList<Cliente> getTopTres() {
        return topTres;
    }
}

