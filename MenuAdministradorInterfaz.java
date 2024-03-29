package prog2.TP;


public class MenuAdministradorInterfaz {
    MenuAdministrador menuAdministrador = new MenuAdministrador();

    public void menuAdministrador(){
        System.out.println("1) Bloquear usuario. \n 2) Desbloquear usuario. \n 3) Multar usuario. \n 4) Crear lote de compra. \n 5) Crear terminal. \n 6) Crear zona. \n 7) Crear tabla de puntajes. \n 8) Ver tabla de puntajes. \n 9) Dar cupones del mes \n 10) Reiniciar puntos \n 11) Agregar descuento a activo \n 12) Salir.");
        int opcionSeleccionada = Scanner.getInt("Seleccione una opcion : ");

        switch (opcionSeleccionada){
            case 1: menuAdministrador.bloquearUsuario();break;
            case 2: menuAdministrador.desbloquarUsuario();break;
            case 3: menuAdministrador.multarUsuario();break;
            case 4: menuAdministrador.crearLoteDeCompra();break;
            case 5: menuAdministrador.crearTerminal();break;
            case 6: menuAdministrador.crearZona();break;
            case 7: menuAdministrador.crearTablaDePuntajes();break;
            case 8: menuAdministrador.verTablaDePuntajes();break;
            case 9: menuAdministrador.darCuponesDelMes();break;
            case 10: menuAdministrador.reiniciarPuntos();break;
            case 11: menuAdministrador.agregarDescuentoAActivo();break;
            case 12: System.out.println("Gracias por usar nuestro programa"); MenuDeInicio.inicioDeSesion();
            default : System.out.println("Seleccione una opcion valida");
        }
        menuAdministrador();
    }
}
