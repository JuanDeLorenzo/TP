package prog2.TP;

import java.util.ArrayList;
import java.util.Date;

public class MenuCliente {


    public void alquilarActivo(){
        String zonaUsuario = Scanner.getString("Ingrese zona en la que se encuentra : ");
        String terminalUsuario = Scanner.getString("Ingrese terminal en la que se encuentra : ");

        ArrayList<Activo> activosCoincidentes = new ArrayList<>();
        for (Activo activo: MenuDeInicio.activosRepositorio.listar()) {
            if (zonaUsuario.equals(activo.getZona().getNombreZona()) && terminalUsuario.equals(activo.getTerminalDeActual())) {
                activosCoincidentes.add(activo);
            }
        }
        if (activosCoincidentes.size() == 0){
            System.out.println("No hay activos disponibles en tu ubicacion");
        }else{
            for (int i = 0; i < activosCoincidentes.size(); i++) {
                System.out.println(++i + ") " + activosCoincidentes.get(i).toString());
            }
            int activoSeleccionado = Scanner.getInt("Seleccione activo que desea alquilar : ");

            int horaDeEntregaEstimada = Scanner.getInt("Ingresar hora de entrega estimada");

            InicioDeSesionCliente.clienteIniciado.iniciarViaje(MenuDeInicio.activosRepositorio.listar().get(activoSeleccionado), horaDeEntregaEstimada);
        }
    }

    public void entregarActivo(){
        for (int i = 0; i < InicioDeSesionCliente.clienteIniciado.getActivoAlquilado().getZona().getTerminales().size() ; i++) {
            System.out.println(++i + ") " + InicioDeSesionCliente.clienteIniciado.getActivoAlquilado().getZona().getTerminales().get(i).getNombre());
        }
        int terminalSeleccionada = Scanner.getInt("Seleccione terminal de entrega del activo : ");
        int duracionDelViaje = Scanner.getInt("Ingrese duracion del viaje : ");
        int horaDeEntrega = Scanner.getInt("Ingrese hora en la que esta entregando el activo : ");

        InicioDeSesionCliente.clienteIniciado.entregaActivo(InicioDeSesionCliente.clienteIniciado.getActivoAlquilado().getZona().getTerminales().get(terminalSeleccionada), duracionDelViaje, horaDeEntrega);
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
