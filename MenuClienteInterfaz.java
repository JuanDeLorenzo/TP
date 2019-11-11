package prog2.TP;

import java.util.Scanner;

public class MenuClienteInterfaz {
    Scanner scanner = new Scanner(System.in);
    private MenuCliente menuCliente = new MenuCliente();


    public void menuCliente(){
        System.out.println("1) Alquilar activo. \n 2) Entregar activo. \n 3) Ver tabla de puntos. \n 4) Ver mis puntos. \n 5) Ver facturas. \n 6) Salir. \n");
        System.out.println("Seleccione una opcion");
        int opcionSeleccionada = scanner.nextInt();

        switch (opcionSeleccionada){
            case 1: menuCliente.alquilarActivo();break;
            case 2: menuCliente.entregarActivo();break;
            case 3: menuCliente.verTablaDePuntajes();break;
            case 4: menuCliente.verPuntosDelUsuario();break;
            case 5: menuCliente.verFacturasDelUsuario();break;
            case 6: System.out.println("Gracias por usar nuestro programa");return;
            default : System.out.println("Seleccione una opcion valida");
        }
        menuCliente();
    }
}
