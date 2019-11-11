package prog2.TP;


public class MenuClienteInterfaz {
    private MenuCliente menuCliente = new MenuCliente();


    public void menuCliente(){
        System.out.println("1) Alquilar activo. \n 2) Entregar activo. \n 3) Ver tabla de puntos. \n 4) Ver mis puntos. \n 5) Ver facturas. \n 6) Salir. \n");
        int opcionSeleccionada = Scanner.getInt("Seleccione una opcion : ");

        switch (opcionSeleccionada){
            case 1: menuCliente.alquilarActivo();break;
            case 2: menuCliente.entregarActivo();break;
            case 3: menuCliente.verTablaDePuntajes();break;
            case 4: menuCliente.verPuntosDelUsuario();break;
            case 5: menuCliente.verFacturasDelUsuario();break;
            case 6: System.out.println("Gracias por usar nuestro programa");MenuDeInicio.inicioDeSesion();
            default : System.out.println("Seleccione una opcion valida");
        }
        menuCliente();
    }
}
