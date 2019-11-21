package prog2.TP;



public class InicioDeSesionCliente {
    private MenuClienteInterfaz menuCliente = new MenuClienteInterfaz();
    public static Cliente clienteIniciado;

    public void inicioDeSesionCliente() {

        String respuesta = Scanner.getString("Queres iniciar sesion o registrarte. Si desea salir, ingrese salir : ");
        if (respuesta.equals("iniciar sesion")) {
            iniciarSesion();
        } else if (respuesta.equals("registrarte")) {
            registrarse();
        } else if (respuesta.equals("salir")) {
            MenuDeInicio.inicioDeSesion();
        }else{
            System.out.println("Ingrese una opcion valida");
            inicioDeSesionCliente();
        }
    }


    public void iniciarSesion(){
        String nombreDeUsuario = Scanner.getString("Ingresar nombre de usuario : ");

        String contrasena = Scanner.getString("Ingrese contrasena : ");
        if (MenuDeInicio.clientesRepositorio.listar().size() == 0){
            System.out.println("No hay clientes en el sistema");
            return;
        }
        for (Cliente cliente: MenuDeInicio.clientesRepositorio.listar()) {
            if (nombreDeUsuario.equals(cliente.getAlias()) && contrasena.equals(cliente.getConstrasena())){
                System.out.println("Inicio de sesion exitoso");
                clienteIniciado = cliente;
                menuCliente.menuCliente();
            }
        }
        System.out.println("Los datos ingresados no son validos");
        iniciarSesion();
    }

    public void registrarse(){
        int numeroDeTelefono = Scanner.getInt("Ingresar numero de telefono : ");
        if (MenuDeInicio.clientesRepositorio.listar().size() == 0){
            String nombre = Scanner.getString("Ingresar un nombre : ");
            String contrasena = Scanner.getString("Ingresar una contrasena : ");
            Cliente clienteNuevo = new Cliente(numeroDeTelefono,nombre,contrasena);
            MenuDeInicio.clientesRepositorio.agregar(clienteNuevo);
            clienteIniciado = clienteNuevo;
            menuCliente.menuCliente();
        }else{
            for (Cliente cliente : MenuDeInicio.clientesRepositorio.listar()) {
                if (numeroDeTelefono == cliente.getNumeroDeTelefono()) {
                    System.out.println("El numero de telefono ya esta asociado a una cuenta");
                    registrarse();
                }else{
                    String nombre = Scanner.getString("Ingresar un nombre : ");
                    String contrasena = Scanner.getString("Ingresar una contrasena : ");
                    Cliente clienteNuevo = new Cliente(numeroDeTelefono,nombre,contrasena);
                    MenuDeInicio.clientesRepositorio.agregar(clienteNuevo);
                    clienteIniciado = clienteNuevo;
                    menuCliente.menuCliente();
                }
            }
        }
    }



}
