package prog2.TP;

import java.util.Scanner;

public class MenuAdministrador {
    private Scanner scanner = new Scanner(System.in);


    public void bloquearUsuario(){
        System.out.println("Ingresar telefono de usuario que desea bloquear");
        int usuarioBloquear = scanner.nextInt();
        if (MenuDeInicio.clientesRepositorio.listar().size() == 0){
            System.out.println("No hay usuarios en el sistema");
            return;
        }
        for (Cliente usuario: MenuDeInicio.clientesRepositorio.listar()) {
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
        if (MenuDeInicio.clientesRepositorio.listar().size() == 0){
            System.out.println("No hay usuarios en el sistema");
            return;
        }
        for (Cliente usuario: MenuDeInicio.clientesRepositorio.listar()) {
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
        if (MenuDeInicio.clientesRepositorio.listar().size() == 0){
            System.out.println("No hay usuarios en el sistema");
            return;
        }
        System.out.println("Ingrese valor de la multa");
        int valorMulta = scanner.nextInt();
        for (Cliente usuario: MenuDeInicio.clientesRepositorio.listar()) {
            if (usuario.getNumeroDeTelefono() == usuarioMultar){
                InicioDeSesionAdministrador.administradorIniciado.multarUsuario(usuario, valorMulta);
                break;
            }else{
                System.out.println("No hay usuario asociado al telefono ingresado");
            }
        }
    }

    public void crearLoteDeCompra(){
        System.out.println("Ingresar nombre del activo que quiere comprar");
        String tipoDeActivoIngresado = scanner.nextLine();


        TipoDeActivo tipoDeActivoSeleccionado = null;
        for (Activo activo: MenuDeInicio.activosRepositorio.listar()) {
            if (tipoDeActivoIngresado.equals(activo.getTipoDeActivo().getTipoDeActivo())){
                tipoDeActivoSeleccionado = activo.getTipoDeActivo();
            }
        }


        if (tipoDeActivoSeleccionado == null){
            System.out.println("Tipo de activo no existente, desea crearlo?");
            String respuesta = scanner.nextLine();
            if (respuesta.equals("si")){
                System.out.println("Ingrese costo por minuto del Activo");
                int costoDelActivo = scanner.nextInt();
                System.out.println("Ingrese puntos por minuto del Activo");
                int puntosDelActivo = scanner.nextInt();
                tipoDeActivoSeleccionado = new TipoDeActivo(tipoDeActivoIngresado,puntosDelActivo,costoDelActivo);
            }else{
                return;
            }

        }

        System.out.println("Seleccionar zona");
        if (MenuDeInicio.zonasRepositorio.listar().size() == 0){
            System.out.println("No hay zonas en el sistema");
            return;
        }

        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listar().size(); i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listar().get(i).getNombreZona());
        }
        int zonaSeleccionada = scanner.nextInt();

        System.out.println("Seleccionar terminal");
        if (MenuDeInicio.zonasRepositorio.listarTerminales().size() == 0){
            System.out.println("No hay terminales en el sistema");
            return;
        }
        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listarTerminales().size() ; i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listarTerminales(MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada)).get(i).getNombre());
        }
        int terminalSeleccionada = scanner.nextInt();

        System.out.println("Ingresar cantidad de activos a comprar");
        int cantidadDeActivos = scanner.nextInt();

        InicioDeSesionAdministrador.administradorIniciado.crearLoteDeCompra(tipoDeActivoSeleccionado, MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada), MenuDeInicio.zonasRepositorio.listarTerminales().get(terminalSeleccionada),cantidadDeActivos);

    }

    public void crearTerminal(){
        System.out.println("Ingrese nombre de la terminal");
        String nombreDeLaTerminal = scanner.nextLine();
        for (Terminal terminal : MenuDeInicio.zonasRepositorio.listarTerminales()) {
            if (nombreDeLaTerminal.equals(terminal.getNombre())){
                System.out.println("Ya existe una terminal con ese nombre");
                return;
            }
        }

        System.out.println("Ingese zona de la terminal");
        if (MenuDeInicio.zonasRepositorio.listar().size() == 0){
            System.out.println("No hay zonas en el sistema");
            return;
        }
        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listar().size(); i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listar().get(i).getNombreZona());
        }
        int zonaSeleccionada = scanner.nextInt();
        System.out.println("La terminal fue creada con exito");
        MenuDeInicio.zonasRepositorio.listarTerminales().add(InicioDeSesionAdministrador.administradorIniciado.crearTerminal(nombreDeLaTerminal, MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada)));
    }

    public void crearZona(){
        System.out.println("Ingrese nombre de la zona");
        String nombreDeLaZona = scanner.nextLine();
        for (Zona zona : MenuDeInicio.zonasRepositorio.listar()) {
            if (nombreDeLaZona.equals(zona.getNombreZona())){
                System.out.println("Ya existe una zona con ese nombre");
                return;
            }
        }
        System.out.println("Se creo la zona con exito");
        MenuDeInicio.zonasRepositorio.agregar(InicioDeSesionAdministrador.administradorIniciado.crearZona(nombreDeLaZona));
    }

    public void crearTablaDePuntajes(){
        if (MenuDeInicio.zonasRepositorio.listar().size() == 0){
            System.out.println("No hay zonas en el sistema");
            return;
        }
        for (Zona zona:MenuDeInicio.zonasRepositorio.listar()) {
            MenuDeInicio.tablasDePuntaje.add(InicioDeSesionAdministrador.administradorIniciado.crearTablaDePuntajes(zona, ClientesRepositorio.repositorioClientes));
        }
        System.out.println("Las tablas se crearon exitosamente");
    }

    public void verTablaDePuntajes(){
        System.out.println("Seleccionar zona");
        if (ZonasRepositorio.repositorioZonas.size() == 0){
            System.out.println("No hay zonas en el sistema");
            return;
        }
        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listar().size(); i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listar().get(i).getNombreZona());
        }
        int zonaSeleccionada = scanner.nextInt();

        for (TablaDePuntaje tablaDePuntaje: MenuDeInicio.tablasDePuntaje) {
            if (MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada).equals(tablaDePuntaje.getZona())){
                tablaDePuntaje.printLeaderBoard();
            }
            break;
        }
    }

    public void darCuponesDelMes(){
        if (MenuDeInicio.tablasDePuntaje.size() == 0){
            System.out.println("No hay tabla de puntajes en el sistema");
            return;
        }
        for (TablaDePuntaje tablaDePuntaje: MenuDeInicio.tablasDePuntaje) {
            tablaDePuntaje.entregarCuponDeDescuento();
        }
    }

    public void reiniciarPuntos(){
        if (MenuDeInicio.clientesRepositorio.listar().size() == 0){
            System.out.println("No hay usuarios en el sistema");
            return;
        }
        InicioDeSesionAdministrador.administradorIniciado.reiniciarPuntos(MenuDeInicio.clientesRepositorio.listar());
        System.out.println("Se resetearon los puntos exitosamente");
    }


}
