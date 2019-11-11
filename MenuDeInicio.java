package prog2.TP;


import java.util.ArrayList;

public class MenuDeInicio {
    public static InicioDeSesionAdministrador inicioDeSesionAdministrador = new InicioDeSesionAdministrador();
    public static InicioDeSesionCliente inicioDeSesionCliente = new InicioDeSesionCliente();
    public static ActivosRepositorio activosRepositorio = new ActivosRepositorio();
    public static ZonasRepositorio zonasRepositorio = new ZonasRepositorio();
    public static ClientesRepositorio clientesRepositorio = new ClientesRepositorio();
    public static AdministradoresRepositorio administradoresRepositorio = new AdministradoresRepositorio();
    public static ArrayList<TablaDePuntaje> tablasDePuntaje = new ArrayList<>();

    public static void inicioDeSesion(){

        String respuesta = Scanner.getString("Iniciar sesion como administrador o cliente. Si desea salir, ingrese salir : ");

        while(!respuesta.equals("administrador") && !respuesta.equals("cliente") && !respuesta.equals("salir")){
            System.out.println("Elija una opcion valida");
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
