package prog2.TP;

import java.util.ArrayList;

public class Administrador extends Usuario{

    public Administrador(int telefono, String alias, String contrasena) {
        super(telefono,alias,contrasena);
    }

    public void bloquearUsuario(Cliente usuario){
        usuario.bloquear();
    }

    public void desbloquearUsuario(Cliente usuario){
        usuario.desbloquear();
    }

    public void multarUsuario(Cliente usuario, int valorDeLaMulta){
        usuario.agregarFactura(new Factura(valorDeLaMulta));
        bloquearUsuario(usuario);
    }

    public LoteDeCompra crearLoteDeCompra(TipoDeActivo tipoDeActivo, Zona zona, Terminal terminal, int cantidad){
        if (!zona.equals(terminal.getZona())){
            throw new RuntimeException("La zona de la terminal no coincide con la zona seleccionada");
        }
        LoteDeCompra nuevoLoteDeCompra = new LoteDeCompra(tipoDeActivo, zona, terminal, cantidad);
        for (Activo activo: nuevoLoteDeCompra.getLoteDeCompra()) {
            activo.setLoteDeCompra(nuevoLoteDeCompra);
        }
        return nuevoLoteDeCompra;
    }

    public Terminal crearTerminal(String nombreDeTerminal, Zona zona){
        Terminal nuevaTerminal = new Terminal(zona, nombreDeTerminal);
        zona.agregarTerminal(nuevaTerminal);
        return nuevaTerminal;
    }

    public Zona crearZona(String nombreZona){
        return new Zona(nombreZona);
    }

    public void reiniciarPuntos(ArrayList<Cliente> usuarios){
        for (Usuario usuario : usuarios) {
            for (Puntos puntos:usuario.getPuntosDelUsuario()) {
                puntos.resetearPuntos();
            }
        }
    }

    public TablaDePuntaje crearTablaDePuntajes(Zona zona, ArrayList<Cliente> usuarios){
        return new TablaDePuntaje(zona, usuarios);
    }


}

