package prog2.TP;


import java.util.ArrayList;
import java.util.Scanner;

public class MenuDeInicio {
    private Scanner scanner = new Scanner(System.in);
    private InicioDeSesionAdministrador inicioDeSesionAdministrador = new InicioDeSesionAdministrador();
    private InicioDeSesionCliente inicioDeSesionCliente = new InicioDeSesionCliente();
    public static ActivosRepositorio activosRepositorio = new ActivosRepositorio();
    public static ZonasRepositorio zonasRepositorio = new ZonasRepositorio();
    public static ClientesRepositorio clientesRepositorio = new ClientesRepositorio();
    public static AdministradoresRepositorio administradoresRepositorio = new AdministradoresRepositorio();
    public static ArrayList<TablaDePuntaje> tablasDePuntaje;

    public void inicioDeSesion(){
        System.out.println("Iniciar como administrador o como cliente \n");
        System.out.println("Salir");
        String respuesta = scanner.nextLine();

        while(!respuesta.equals("administrador") && !respuesta.equals("cliente")){
            System.out.println("Elija una opcion valida \n");
            inicioDeSesion();

        }

        if (respuesta.equals("administrador")){
            inicioDeSesionAdministrador.inicioDeSesionAdmin();
        }

        if(respuesta.equals("cliente")){
            inicioDeSesionCliente.inicioDeSesionCliente();
        }

        if (respuesta.equals("salir")){
            System.exit(0);
        }

    }

}
