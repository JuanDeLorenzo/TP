package prog2.TP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TablaDePuntaje {
    private Zona zona;
    private ArrayList<Cliente> tablaDePuntajes;
    private ArrayList<Cliente> topTres;

    public TablaDePuntaje(Zona zona, ArrayList<Cliente> usuarios) {
        this.zona = zona;
        ArrayList<Cliente> usuariosOrdenados = ordenarPuntaje(zona, usuarios);
        topTres = crearTopTres(usuariosOrdenados);
        tablaDePuntajes = crearTablaDePuntajes(usuariosOrdenados);
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

    public ArrayList<Cliente> ordenarPuntaje(Zona zona, ArrayList<Cliente> usuarios) {
        ArrayList<Cliente> usuariosOrdenados;
        usuarios.sort((Cliente a, Cliente b) -> b.getPuntos(zona).getPuntosTotales() - a.getPuntos(zona).getPuntosTotales());
        usuariosOrdenados = usuarios;
        return usuariosOrdenados;
    }

    public ArrayList<Cliente> crearTablaDePuntajes(ArrayList<Cliente> usuarios){
        ArrayList<Cliente> tablaDePuntajes = new ArrayList<>();
        if (usuarios.size() == 0){
            System.out.println("No hay usuarios en la zona seleccionada");
            return tablaDePuntajes;

        }else if (usuarios.size() < 9){
            for (int i = 0; i < usuarios.size(); i++) {
                tablaDePuntajes.add(usuarios.get(i));
            }

        }else{
            for (int i = 0; i < 9; i++) {
                tablaDePuntajes.add(usuarios.get(i));
            }
        }
        return tablaDePuntajes;
    }


    public void mostrarTablaDePuntaje() {
        if (tablaDePuntajes.size() == 0){
            System.out.println("No hay usuarios en la zona seleccionada");
            return;
        }
        for (int i = 0; i < tablaDePuntajes.size(); i++) {
            System.out.println(i + ") Usuario : " + tablaDePuntajes.get(i).getAlias() + "\n" + " Puntos : " + tablaDePuntajes.get(i).getPuntos(zona).getPuntosTotales());
        }
    }

    public Zona getZona() {
        return zona;
    }

    public ArrayList<Cliente> getTopTres() {
        return topTres;
    }
}

