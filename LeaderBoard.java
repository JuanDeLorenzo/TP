package prog2.TP;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
    public HashMap<String, Integer> top10 (ArrayList<Usuario> usuarios){   // se usaria despues de ordenarPuntaje.
        HashMap<Usuario, Integer> top10 = new HashMap<>();
        for(int i = 0; i < 10; i++){
            top10.put(usuarios.get(i).getAlias(), tabla.get(usuarios.get(i)));
        }
        return top10;
    }
    
    public void borrarDespuesde1mes(ArrayList<Usuario> usuarios){
        Timer timer = new Timer();



            TimerTask timerTask  = new TimerTask() {
                @Override
                public void run() {
                    int dayOfMonth = LocalDate.now().getDayOfMonth();
                    if (dayOfMonth == 1) {

                        tabla.clear();
                        for (int i = 0; i < 9; i++) {
                            tabla(usuarios.get(i).getAlias(), 0);
                        }
                    }
                }
                };
            LocalDateTime of = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(7, 0));
            Date from = Date.from(of.atZone(ZoneId.systemDefault()).toInstant());

            timer.scheduleAtFixedRate(timerTask, from, TimeUnit.DAYS.toMillis(1));
            }
}
