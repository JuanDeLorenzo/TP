package prog2.TP;

import java.util.Scanner;

public class InicioDeSesionAdministrador {
    private Scanner scanner = new Scanner(System.in);
    private MenuAdministradorInterfaz menuAdmin = new MenuAdministradorInterfaz();
    public static Administrador administradorIniciado;

    public void inicioDeSesionAdmin(){
        System.out.println("Ingresar nombre de usuario : \n");
        String nombreDeUsuario = scanner.nextLine();

        System.out.println("Ingrese contrasena : ");
        String contrasena = scanner.nextLine();
        if (MenuDeInicio.administradoresRepositorio.listar().size() == 0){
            System.out.println("No hay administradores en el sistema");
            return;
        }
        for (Administrador admin: MenuDeInicio.administradoresRepositorio.listar()) {
            if (nombreDeUsuario.equals(admin.getAlias()) && contrasena.equals(admin.getConstrasena())){
                System.out.println("Inicio de sesion exitoso");
                setAdministradorIniciado(admin);
                menuAdmin.menuAdministrador();
                break;
            }else{
                System.out.println("Los datos ingresados no son validos");
                inicioDeSesionAdmin();
            }
        }
    }

    public void setAdministradorIniciado(Administrador administradorIniciado) {
        this.administradorIniciado = administradorIniciado;
    }

}
