package prog2.TP;

import java.util.Scanner;

public class InicioDeSesionCliente {
    private Scanner scanner = new Scanner(System.in);
    private MenuClienteInterfaz menuCliente = new MenuClienteInterfaz();
    public static Cliente clienteIniciado;

    public void inicioDeSesionCliente(){

        System.out.println("Queres iniciar sesion o registrarte");
        String respuesta = scanner.nextLine();
        if (respuesta.equals("iniciar sesion")){
            iniciarSesion();
        }
        if (respuesta.equals("registrarte")){
            registrarse();
        }
    }

    public void iniciarSesion(){
        System.out.println("Ingresar nombre de usuario : \n");
        String nombreDeUsuario = scanner.nextLine();

        System.out.println("Ingrese contrasena : ");
        String contrasena = scanner.nextLine();
        if (MenuDeInicio.clientesRepositorio.listar().size() == 0){
            System.out.println("No hay clientes en el sistema");
            return;
        }
        for (Cliente cliente: MenuDeInicio.clientesRepositorio.listar()) {
            if (nombreDeUsuario.equals(cliente.getAlias()) && contrasena.equals(cliente.getConstrasena())){
                System.out.println("Inicio de sesion exitoso");
                setClienteIniciado(cliente);
                menuCliente.menuCliente();
            }else{
                System.out.println("Los datos ingresados no son validos");
                iniciarSesion();
            }
        }
    }

    public void registrarse(){
        System.out.println("Ingresar numero de telefono : \n");
        int numeroDeTelefono = scanner.nextInt();
        if (MenuDeInicio.clientesRepositorio.listar().size() == 0){
            System.out.println("Ingresar un nombre : \n");
            String nombre = scanner.nextLine();
            System.out.println("Ingresar una contrasena : \n");
            String contrasena = scanner.nextLine();
            Cliente clienteNuevo = new Cliente(numeroDeTelefono,nombre,contrasena);
            MenuDeInicio.clientesRepositorio.agregar(clienteNuevo);
            setClienteIniciado(clienteNuevo);
            menuCliente.menuCliente();
        }else{
            for (Cliente cliente : MenuDeInicio.clientesRepositorio.listar()) {
                if (numeroDeTelefono == cliente.getNumeroDeTelefono()) {
                    System.out.println("El numero de telefono ya esta asociado a una cuenta");
                    registrarse();
                }
            }
        }
    }

    public static void setClienteIniciado(Cliente clienteIniciado) {
        InicioDeSesionCliente.clienteIniciado = clienteIniciado;
    }

}
