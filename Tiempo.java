package prog2.TP;

public class Tiempo {
    private int horas;
    private int minutos;

    public Tiempo(int horas, int minutos) {
        this.horas = horas;
        this.minutos = minutos;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public boolean compararTiempo(Tiempo otroTiempo){
        if (horas == otroTiempo.getHoras() && minutos == otroTiempo.getMinutos()){
            return true;
        }else{
            return false;
        }

    }
}
