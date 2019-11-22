package prog2.TP;


public class MenuAdministrador {



    public void bloquearUsuario(){
        int usuarioBloquear = prog2.TP.Scanner.getInt("Ingresar telefono de usuario que desea bloquear : ");
        if (MenuDeInicio.clientesRepositorio.listar().size() == 0){
            System.out.println("No hay usuarios en el sistema");
            return;
        }
        for (Cliente usuario: MenuDeInicio.clientesRepositorio.listar()) {
            if (usuario.getNumeroDeTelefono() == usuarioBloquear){
                if (usuario.getActivoAlquilado() != null){
                    usuario.getActivoAlquilado().cambiarEstadoANoAlquilado();
                    usuario.borrarActivoAlquilado();
                    System.out.println("El activo alquilado por el usuario ha sido devuelto a su terminal de origen");
                }
                InicioDeSesionAdministrador.administradorIniciado.bloquearUsuario(usuario);
                System.out.println("El usuario ha sido bloqueado");
                break;
            }else{
                System.out.println("No hay usuario asociado al telefono ingresado");
            }
        }
    }

    public void desbloquarUsuario(){
        int usuarioDesbloquear = prog2.TP.Scanner.getInt("Ingresar telefono de usuario que desea desbloquear : ");
        if (MenuDeInicio.clientesRepositorio.listar().size() == 0){
            System.out.println("No hay usuarios en el sistema");
            return;
        }
        for (Cliente usuario: MenuDeInicio.clientesRepositorio.listar()) {
            if (usuario.getNumeroDeTelefono() == usuarioDesbloquear){
                InicioDeSesionAdministrador.administradorIniciado.desbloquearUsuario(usuario);
                System.out.println("El usuario ha sido desbloqueado");
                break;
            }else{
                System.out.println("No hay usuario asociado al telefono ingresado");
            }
        }
    }

    public void multarUsuario(){
        int usuarioMultar = prog2.TP.Scanner.getInt("Ingresar telefono de usuario que desea multar : ");
        if (MenuDeInicio.clientesRepositorio.listar().size() == 0){
            System.out.println("No hay usuarios en el sistema");
            return;
        }

        int valorMulta = Scanner.getInt("Ingrese valor de la multa : ");
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

        if (MenuDeInicio.zonasRepositorio.listar().size() == 0){
            System.out.println("No hay zonas en el sistema");
            return;
        }

        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listar().size(); i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listar().get(i).getNombreZona());
        }
        int zonaSeleccionada = prog2.TP.Scanner.getInt("Seleccionar una zona : ");

        if (MenuDeInicio.zonasRepositorio.listarTerminales().size() == 0){
            System.out.println("No hay terminales en el sistema");
            return;
        }
        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listarTerminales().size() ; i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listarTerminales(MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada)).get(i).getNombre());
        }
        int terminalSeleccionada = prog2.TP.Scanner.getInt("Seleccionar terminal : ");


        for (int i = 0; i <MenuDeInicio.activosRepositorio.listarActivosDiferentes().size() ; i++) {
            System.out.println(i + ")" + MenuDeInicio.activosRepositorio.listarActivosDiferentes().get(i).getTipoDeActivo().getNombreDelActivo());
            if (i == MenuDeInicio.activosRepositorio.listarActivosDiferentes().size()-1){
                System.out.println(++i + ")Crear activo");
            }
        }

        if (MenuDeInicio.activosRepositorio.listarActivosDiferentes().size() == 0){
            System.out.println("No hay activos en el sistema");
        }
        int tipoDeActivoIngresado = prog2.TP.Scanner.getInt("Seleccione el activo que desea comprar : ");


        if (tipoDeActivoIngresado == MenuDeInicio.activosRepositorio.listarActivosDiferentes().size()){

            String nombreDelActivo = Scanner.getString("Ingrese el nombre del activo : ");
            int costoDelActivo = Scanner.getInt("Ingrese costo por minuto del activo : ");
            int puntosDelActivo = Scanner.getInt("Ingrese puntos por minuto del activo : ");
            Activo nuevoActivo = new Activo(new TipoDeActivo(nombreDelActivo,puntosDelActivo,costoDelActivo),MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada));
            MenuDeInicio.activosRepositorio.agregar(nuevoActivo);
            System.out.println("El activo ha sido creado exitosamente");
            return;

        }


        int cantidadDeActivos = prog2.TP.Scanner.getInt("Ingresar cantidad de activos a comprar : ");

        LoteDeCompra nuevoLoteDeCompra = InicioDeSesionAdministrador.administradorIniciado.crearLoteDeCompra(MenuDeInicio.activosRepositorio.listarActivosDiferentes().get(tipoDeActivoIngresado).getTipoDeActivo(), MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada), MenuDeInicio.zonasRepositorio.listarTerminales(MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada)).get(terminalSeleccionada),cantidadDeActivos);
        for (Activo activo : nuevoLoteDeCompra.getLoteDeCompra() ) {
            MenuDeInicio.activosRepositorio.agregar(activo);
        }
        System.out.println("La compra se realizo exitosamente");
    }

    public void crearTerminal(){
        String nombreDeLaTerminal = Scanner.getString("Ingrese nombre de la terminal : ");
        for (Terminal terminal : MenuDeInicio.zonasRepositorio.listarTerminales()) {
            if (nombreDeLaTerminal.equals(terminal.getNombre())){
                System.out.println("Ya existe una terminal con ese nombre");
                return;
            }
        }

        if (MenuDeInicio.zonasRepositorio.listar().size() == 0){
            System.out.println("No hay zonas en el sistema");
            return;
        }
        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listar().size(); i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listar().get(i).getNombreZona());
        }
        int zonaSeleccionada = Scanner.getInt("Ingese zona de la terminal : ");
        System.out.println("La terminal fue creada con exito");
        MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada).agregarTerminal(new Terminal(MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada), nombreDeLaTerminal));
    }

    public void crearZona(){
        String nombreDeLaZona = Scanner.getString("Ingrese nombre de la zona");
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
            MenuDeInicio.tablasDePuntaje.add(InicioDeSesionAdministrador.administradorIniciado.crearTablaDePuntajes(zona, MenuDeInicio.clientesRepositorio.listar()));
        }
        System.out.println("Las tablas se crearon exitosamente");
    }

    public void verTablaDePuntajes(){
        if (ZonasRepositorio.repositorioZonas.size() == 0){
            System.out.println("No hay zonas en el sistema");
            return;
        }
        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listar().size(); i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listar().get(i).getNombreZona());
        }
        int zonaSeleccionada = Scanner.getInt("Seleccionar zona : ");
        if(MenuDeInicio.tablasDePuntaje.size() == 0){
            System.out.println("No hay tablas en la zona seleccionada");
            return;
        }
        for (TablaDePuntaje tablaDePuntaje: MenuDeInicio.tablasDePuntaje) {
            if (MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada).equals(tablaDePuntaje.getZona())){
                tablaDePuntaje.mostrarTablaDePuntaje();
                break;
            }
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
        System.out.println("Los cupones se han entregado exitosamente");
    }

    public void reiniciarPuntos(){
        if (MenuDeInicio.clientesRepositorio.listar().size() == 0){
            System.out.println("No hay usuarios en el sistema");
            return;
        }
        InicioDeSesionAdministrador.administradorIniciado.reiniciarPuntos(MenuDeInicio.clientesRepositorio.listar());
        System.out.println("Se resetearon los puntos exitosamente");
    }

    public void agregarDescuentoAActivo(){
        if (MenuDeInicio.activosRepositorio.listarActivosDiferentes().size() == 0){
            System.out.println("No hay activos en el sistema");
        }
        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listar().size(); i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listar().get(i).getNombreZona());
        }
        int zonaSeleccionada = Scanner.getInt("Seleccione una zona : ");

        for (int i = 0; i <MenuDeInicio.activosRepositorio.listarActivosDiferentes().size() ; i++) {
            System.out.println(i + ")" + MenuDeInicio.activosRepositorio.listarActivosDiferentes().get(i).getTipoDeActivo().getNombreDelActivo());
        }
        int activoSeleccionado = Scanner.getInt("Seleccionar un activo : ");

        int puntosRequeridosDescuento = Scanner.getInt("Ingresar puntos requeridos para aplicar al descuento : ");
        int porcentajeDelDescuento = Scanner.getInt("Ingresar porcentaje del descuento : ");
        Descuento nuevoDescuento = new Descuento(puntosRequeridosDescuento,porcentajeDelDescuento);
        for (Activo activo : MenuDeInicio.activosRepositorio.listar()) {
            if (activo.getTipoDeActivo().getNombreDelActivo().equals(MenuDeInicio.activosRepositorio.listarActivosDiferentes().get(activoSeleccionado).getTipoDeActivo().getNombreDelActivo()) && activo.getZona().getNombreZona().equals(MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada).getNombreZona())){
                activo.agregarDescuento(nuevoDescuento);
            }
        }
        System.out.println("Los descuentos se agregaron exitosamente");

    }


}
