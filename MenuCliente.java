package prog2.TP;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MenuCliente {
    private Scanner scanner = new Scanner(System.in);


    public void alquilarActivo(){
        System.out.println("Ingrese zona en la que se encuentra");
        String zonaUsuario = scanner.nextLine();

        System.out.println("Ingrese terminal en la que se encuentra");
        String terminalUsuario = scanner.nextLine();

        ArrayList<Activo> activosCoincidentes = new ArrayList<>();
        for (Activo activo: ActivosRepositorio.repositorioActivos) {
            if (zonaUsuario.equals(activo.getZona().getNombreZona()) && terminalUsuario.equals(activo.getTerminalDeActual())) {
                activosCoincidentes.add(activo);
            }
        }
        if (activosCoincidentes.size() == 0){
            System.out.println("No hay activos disponibles en tu ubicacion");
        }else{
            System.out.println("Seleccione activo que desea alquilar");
            for (int i = 0; i < activosCoincidentes.size(); i++) {
                System.out.println(++i + ") " + activosCoincidentes.get(i).toString());
            }
            int activoSeleccionado = scanner.nextInt();

            System.out.println("Ingrese año en el cual va a entregar el activo");
            int anoIngresado = scanner.nextInt();
            System.out.println("Ingrese mes en el cual va a entregar el activo");
            int mesIngresado = scanner.nextInt();
            System.out.println("Ingrese dia en el cual va a entregar el activo");
            int diaIngresado = scanner.nextInt();
            System.out.println("Ingrese hora en la cual va a entregar el activo");
            int horaIngresada = scanner.nextInt();
            System.out.println("Ingrese minuto en el cual va a entregar el activo");
            int minutoIngresado = scanner.nextInt();

            Date fecha = new Date(anoIngresado, mesIngresado, diaIngresado, horaIngresada, minutoIngresado);

            InicioDeSesionCliente.clienteIniciado.iniciarViaje(ActivosRepositorio.repositorioActivos.get(activoSeleccionado), fecha);
        }
    }

    public void entregarActivo(){
        System.out.println("Seleccione terminal de entrega del activo");
        for (int i = 0; i < InicioDeSesionCliente.clienteIniciado.getActivoAlquilado().getZona().getTerminales().size() ; i++) {
            System.out.println(++i + ") " + InicioDeSesionCliente.clienteIniciado.getActivoAlquilado().getZona().getTerminales().get(i).getNombre());
        }
        int terminalSeleccionada = scanner.nextInt();

        InicioDeSesionCliente.clienteIniciado.entregaActivo(InicioDeSesionCliente.clienteIniciado.getActivoAlquilado().getZona().getTerminales().get(terminalSeleccionada));
    }

    public void verTablaDePuntajes(){
        System.out.println("Seleccione zona");
        for (int i = 0; i < ZonasRepositorio.repositorioZonas.size() ; i++) {
            System.out.println(++i + ") " + ZonasRepositorio.repositorioZonas.get(i).getNombreZona());
        }
        int zonaSeleccionada = scanner.nextInt();

        for (TablaDePuntaje tablaDePuntaje: MenuDeInicio.tablasDePuntaje) {
            if (ZonasRepositorio.repositorioZonas.get(zonaSeleccionada).equals(tablaDePuntaje.getZona())){
                tablaDePuntaje.printLeaderBoard();
            }else{
                System.out.println("No hay tabla de puntaje para la zona seleccionada");
            }
        }
    }

    public void verPuntosDelUsuario(){
        System.out.println("Seleccione zona");
        for (int i = 0; i < ZonasRepositorio.repositorioZonas.size() ; i++) {
            System.out.println(++i + ") " + ZonasRepositorio.repositorioZonas.get(i).getNombreZona());
        }
        int zonaSeleccionada = scanner.nextInt();
        Puntos puntosDelUsuario = InicioDeSesionCliente.clienteIniciado.getPuntos(ZonasRepositorio.repositorioZonas.get(zonaSeleccionada));
        System.out.println("Puntos Totales: " + puntosDelUsuario.getPuntosTotales());
        System.out.println("Puntos para Descuento: " + puntosDelUsuario.getPuntosParaDescuento());
    }

    public void verFacturasDelUsuario(){
        System.out.println("Seleccione factura");
        for (int i = 0; i < InicioDeSesionCliente.clienteIniciado.getFacturas().size() ; i++) {
            System.out.println(++i + ") Tipo de factura : " + InicioDeSesionCliente.clienteIniciado.getFacturas().get(i).getTipoDeFactura() + "\n" +
                    "Fecha de la factura : " + InicioDeSesionCliente.clienteIniciado.getFacturas().get(i).getFechaDelViaje().getDay() + "/" + InicioDeSesionCliente.clienteIniciado.getFacturas().get(i).getFechaDelViaje().getMonth() + "/" + InicioDeSesionCliente.clienteIniciado.getFacturas().get(i).getFechaDelViaje().getYear());
        }
        int facturaSeleccionada = scanner.nextInt();
        InicioDeSesionCliente.clienteIniciado.getFacturas().get(facturaSeleccionada).mostrarFactura();
    }

}
