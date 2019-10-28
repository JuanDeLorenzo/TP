package prog2.TP;

import java.util.ArrayList;
import java.util.HashMap;

public class LeaderBoard {
    Zona zona;
    HashMap<String, Integer> tabla;

    public LeaderBoard(Zona zona, ArrayList<Usuario> usuarios){
        this.zona = zona;
        ordenarPuntaje(zona,usuarios);
        this.tabla = crearHashMap(usuarios, zona);

    }

    public void ordenarPuntaje(Zona zona, ArrayList<Usuario> usuarios){
        usuarios.sort((Usuario a, Usuario b)-> b.getPuntos(zona) - a.getPuntos(zona));
    }

    public HashMap<String, Integer> crearHashMap(ArrayList<Usuario> usuarios, Zona zona){
        HashMap<String, Integer> tabla = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            tabla.put(usuarios.get(i).getAlias(),usuarios.get(i).getPuntos(zona));
        }
        return tabla;
    }

    public void printLeaderBoard(){

    }
}
