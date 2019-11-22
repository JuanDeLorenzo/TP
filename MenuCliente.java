package prog2.TP;

import java.util.ArrayList;

public class MenuCliente {


    public void alquilarActivo(){
        if (InicioDeSesionCliente.clienteIniciado.getActivoAlquilado() != null){
            System.out.println("Tenes un activo alquilado");
            return;
        }
        if (InicioDeSesionCliente.clienteIniciado.isEstaBloqueado()){
            System.out.println("El usuario esta bloqueado");
            return;
        }
        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listar().size(); i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listar().get(i).getNombreZona());
        }
        int zonaUsuario = Scanner.getInt("Ingrese zona en la que se encuentra : ");
        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listarTerminales().size() ; i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listarTerminales(MenuDeInicio.zonasRepositorio.listar().get(zonaUsuario)).get(i).getNombre());
        }
        int terminalUsuario = Scanner.getInt("Ingrese terminal en la que se encuentra : ");

        ArrayList<Activo> activosCoincidentes = new ArrayList<>();
        for (Activo activo: MenuDeInicio.activosRepositorio.listar()) {
            if (activo.getTerminalActual() == null){
            }else{
                if (activo.getTerminalActual().getNombre().equals(MenuDeInicio.zonasRepositorio.listarTerminales(MenuDeInicio.zonasRepositorio.listar().get(zonaUsuario)).get(terminalUsuario).getNombre())){
                    activosCoincidentes.add(activo);
                }
            }
        }
        if (activosCoincidentes.size() == 0){
            System.out.println("No hay activos disponibles en tu ubicacion");
        }else{
            for (int i = 0; i < activosCoincidentes.size(); i++) {
                System.out.println(i + ") " + activosCoincidentes.get(i).toString());
            }
            int activoSeleccionado = Scanner.getInt("Seleccione activo que desea alquilar : ");

            int horaDeEntregaEstimada = Scanner.getInt("Ingresar hora de entrega estimada : ");
            int minutosEntregaEstimada = Scanner.getInt("Ingresar minuto de entrega estimada : ");

            InicioDeSesionCliente.clienteIniciado.alquilarActivo(activosCoincidentes.get(activoSeleccionado), new Tiempo(horaDeEntregaEstimada, minutosEntregaEstimada));
            System.out.println("El activo ha sido alquilado exitosamente\n");
        }
    }

    public void entregarActivo(){
        if (InicioDeSesionCliente.clienteIniciado.getActivoAlquilado() == null){
            System.out.println("No tenes un activo alquilado");
            return;
        }
        for (int i = 0; i < InicioDeSesionCliente.clienteIniciado.getActivoAlquilado().getZona().getTerminales().size() ; i++) {
            System.out.println(i + ") " + InicioDeSesionCliente.clienteIniciado.getActivoAlquilado().getZona().getTerminales().get(i).getNombre());
        }
        int terminalSeleccionada = Scanner.getInt("Seleccione terminal de entrega del activo : ");
        int duracionDelViaje = Scanner.getInt("Ingrese duracion del viaje en minutos : ");
        int horaDeEntrega = Scanner.getInt("Ingrese hora en la cual se entregue el activo : ");
        int minutoDeEntrega = Scanner.getInt("Ingrese minuto en el cual se entregue el activo : ");


        InicioDeSesionCliente.clienteIniciado.entregaActivo(InicioDeSesionCliente.clienteIniciado.getActivoAlquilado().getZona().getTerminales().get(terminalSeleccionada), duracionDelViaje, new Tiempo(horaDeEntrega,minutoDeEntrega));
        System.out.println("El activo ha sido entregado exitosamente");
    }

    public void verTablaDePuntajes(){
        if (MenuDeInicio.zonasRepositorio.listar().size() == 0){
            System.out.println("No hay zonas en el sistema");
            return;
        }
        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listar().size() ; i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listar().get(i).getNombreZona());
        }
        int zonaSeleccionada = Scanner.getInt("Seleccione zona : ");

        for (TablaDePuntaje tablaDePuntaje: MenuDeInicio.tablasDePuntaje) {
            if (MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada).equals(tablaDePuntaje.getZona())){
                tablaDePuntaje.mostrarTablaDePuntaje();
            }else{
                System.out.println("No hay tabla de puntaje para la zona seleccionada");
            }
        }
    }

    public void verPuntosDelUsuario(){
        if (MenuDeInicio.zonasRepositorio.listar().size() == 0){
            System.out.println("No hay zonas en el sistema");
            return;
        }
        for (int i = 0; i < MenuDeInicio.zonasRepositorio.listar().size() ; i++) {
            System.out.println(i + ") " + MenuDeInicio.zonasRepositorio.listar().get(i).getNombreZona());
        }
        int zonaSeleccionada = Scanner.getInt("Seleccione zona : ");
        Puntos puntosDelUsuario = InicioDeSesionCliente.clienteIniciado.getPuntos(MenuDeInicio.zonasRepositorio.listar().get(zonaSeleccionada));
        System.out.println("Puntos Totales: " + puntosDelUsuario.getPuntosTotales());
        System.out.println("Puntos para Descuento: " + puntosDelUsuario.getPuntosParaDescuento());
    }

    public void verFacturasDelUsuario(){
        if (InicioDeSesionCliente.clienteIniciado.getFacturas().size() == 0){
            System.out.println("No tenes facturas");
            return;
        }
        for (int i = 0; i < InicioDeSesionCliente.clienteIniciado.getFacturas().size() ; i++) {
            System.out.println(i + ") Tipo de factura : " + InicioDeSesionCliente.clienteIniciado.getFacturas().get(i).getTipoDeFactura());

        }
        int facturaSeleccionada = Scanner.getInt("Seleccione factura : ");
        InicioDeSesionCliente.clienteIniciado.getFacturas().get(facturaSeleccionada).mostrarFactura();
    }

}
