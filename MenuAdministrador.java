package prog2.TP;

import java.util.Scanner;

public class MenuAdministrador {
    private Scanner scanner = new Scanner(System.in);


    public void bloquearUsuario(){
        System.out.println("Ingresar telefono de usuario que desea bloquear");
        int usuarioBloquear = scanner.nextInt();
        for (Cliente usuario: ClientesRepositorio.repositorioClientes) {
            if (usuario.getNumeroDeTelefono() == usuarioBloquear){
                InicioDeSesionAdministrador.administradorIniciado.bloquearUsuario(usuario);
                break;
            }else{
                System.out.println("No hay usuario asociado al telefono ingresado");
            }
        }
    }

    public void desbloquarUsuario(){
        System.out.println("Ingresar telefono de usuario que desea desbloquear");
        int usuarioDesbloquear = scanner.nextInt();
        for (Cliente usuario: ClientesRepositorio.repositorioClientes) {
            if (usuario.getNumeroDeTelefono() == usuarioDesbloquear){
                InicioDeSesionAdministrador.administradorIniciado.desbloquearUsuario(usuario);
                break;
            }else{
                System.out.println("No hay usuario asociado al telefono ingresado");
            }
        }
    }

    public void multarUsuario(){
        System.out.println("Ingresar telefono de usuario que desea multar");
        int usuarioMultar = scanner.nextInt();
        System.out.println("Ingrese valor de la multa");
        int valorMulta = scanner.nextInt();
        for (Cliente usuario: ClientesRepositorio.repositorioClientes) {
            if (usuario.getNumeroDeTelefono() == usuarioMultar){
                InicioDeSesionAdministrador.administradorIniciado.multarUsuario(usuario, valorMulta);
                break;
            }else{
                System.out.println("No hay usuario asociado al telefono ingresado");
            }
        }
    }

    public void crearLoteDeCompra(){
        System.out.println("Seleccionar tipo de activo que quiere comprar");
        for (int i = 0; i < MenuDeInicio.activosRepositorio.listarTipoDeActivos().size(); i++) {
            System.out.println(++i + ") " + MenuDeInicio.activosRepositorio.listarTipoDeActivos().get(i).getTipoDeActivo());
        }
        int tipoDeActivoSeleccionado = scanner.nextInt();

        System.out.println("Seleccionar zona");
        for (int i = 0; i < ZonasRepositorio.repositorioZonas.size(); i++) {
            System.out.println(++i + ") " + ZonasRepositorio.repositorioZonas.get(i).getNombreZona());
        }
        int zonaSeleccionada = scanner.nextInt();

        System.out.println("Seleccionar terminal");
        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listarTerminales().size() ; i++) {
            System.out.println(++i + ") " + MenuDeInicio.zonasRepositorio.listarTerminales().get(i).getNombre());
        }
        int terminalSeleccionada = scanner.nextInt();

        System.out.println("Ingresar cantidad de activos a comprar");
        int cantidadDeActivos = scanner.nextInt();

        InicioDeSesionAdministrador.administradorIniciado.crearLoteDeCompra(MenuDeInicio.activosRepositorio.listarTipoDeActivos().get(tipoDeActivoSeleccionado), ZonasRepositorio.repositorioZonas.get(zonaSeleccionada), MenuDeInicio.zonasRepositorio.listarTerminales().get(terminalSeleccionada),cantidadDeActivos);

    }

    public void crearTerminal(){
        System.out.println("Ingrese nombre de la terminal");
        String nombreDeLaTerminal = scanner.nextLine();

        System.out.println("Ingese zona de la terminal");
        for (int i = 0; i < ZonasRepositorio.repositorioZonas.size(); i++) {
            System.out.println(++i + ") " + ZonasRepositorio.repositorioZonas.get(i).getNombreZona());
        }
        int zonaSeleccionada = scanner.nextInt();

        MenuDeInicio.zonasRepositorio.listarTerminales().add(InicioDeSesionAdministrador.administradorIniciado.crearTerminal(nombreDeLaTerminal, ZonasRepositorio.repositorioZonas.get(zonaSeleccionada)));
    }

    public void crearZona(){
        System.out.println("Ingrese nombre de la zona");
        String nombreDeLaZona = scanner.nextLine();

        ZonasRepositorio.repositorioZonas.add(InicioDeSesionAdministrador.administradorIniciado.crearZona(nombreDeLaZona));
    }

    public void crearTablaDePuntajes(){
        if (ZonasRepositorio.repositorioZonas.size() == 0){
            System.out.println("No hay zonas creadas");
            return;
        }
        for (Zona zona:ZonasRepositorio.repositorioZonas) {
            MenuDeInicio.tablasDePuntaje.add(InicioDeSesionAdministrador.administradorIniciado.crearTablaDePuntajes(zona, ClientesRepositorio.repositorioClientes));
        }
        System.out.println("Las tablas se crearon exitosamente");
    }

    public void verTablaDePuntajes(){
        System.out.println("Seleccionar zona");
        if (ZonasRepositorio.repositorioZonas.size() == 0){
            System.out.println("No hay zonas creadas");
            return;
        }
        for (int i = 0; i < ZonasRepositorio.repositorioZonas.size(); i++) {
            System.out.println(++i + ") " + ZonasRepositorio.repositorioZonas.get(i).getNombreZona());
        }
        int zonaSeleccionada = scanner.nextInt();

        for (TablaDePuntaje tablaDePuntaje: MenuDeInicio.tablasDePuntaje) {
            if (ZonasRepositorio.repositorioZonas.get(zonaSeleccionada).equals(tablaDePuntaje.getZona())){
                tablaDePuntaje.printLeaderBoard();
            }
            break;
        }
    }

    public void darCuponesDelMes(){
        if (MenuDeInicio.tablasDePuntaje.size() == 0){
            System.out.println("No se han realizado las tablas de puntaje");
            return;
        }
        for (TablaDePuntaje tablaDePuntaje: MenuDeInicio.tablasDePuntaje) {
            tablaDePuntaje.entregarCuponDeDescuento();
        }
    }

    public void reiniciarPuntos(){
        InicioDeSesionAdministrador.administradorIniciado.reiniciarPuntos(ClientesRepositorio.repositorioClientes);
        System.out.println("Se resetearon los puntos exitosamente");
    }


}
