package prog2.TP;

public class Main {
    public static void main(String[] args) {
        MenuDeInicio nuevoMenu = new MenuDeInicio();
        Administrador elprimero = new Administrador(1137581006, "Juan","1234");
        MenuDeInicio.administradoresRepositorio.agregar(elprimero);
        nuevoMenu.inicioDeSesion();

    }
}
