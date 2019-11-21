package prog2.TP;


public class InicioDeSesionAdministrador {
    private MenuAdministradorInterfaz menuAdmin = new MenuAdministradorInterfaz();
    public static Administrador administradorIniciado;

    public void inicioDeSesionAdmin(){

        String respuesta = Scanner.getString("Queres iniciar sesion o salir : ");
        if (respuesta.equals("iniciar sesion")){
            String nombreDeUsuario = Scanner.getString("Ingresar nombre de usuario : ");
            String contrasena = Scanner.getString("Ingrese contrasena : ");
            if (MenuDeInicio.administradoresRepositorio.listar().size() == 0){
                System.out.println("No hay administradores en el sistema");
                return;
            }
            for (Administrador admin: MenuDeInicio.administradoresRepositorio.listar()) {
                if (nombreDeUsuario.equals(admin.getAlias()) && contrasena.equals(admin.getConstrasena())){
                    System.out.println("Inicio de sesion exitoso");
                    administradorIniciado = admin;
                    menuAdmin.menuAdministrador();
                    break;
                }
            }
            System.out.println("Los datos ingresados no son validos");
            inicioDeSesionAdmin();

        }else if(respuesta.equals("salir")){
            MenuDeInicio.inicioDeSesion();
        }else{
            System.out.println("Ingrese una respuesta valida\n");
            inicioDeSesionAdmin();
        }


    }



}
