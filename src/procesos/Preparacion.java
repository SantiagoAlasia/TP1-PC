package procesos;

import app.MatrizCasilleros;
import app.Usuarios;
import app.RegistroPedidos;
import app.Pedido;
import app.Casillero;


public class Preparacion extends Proceso{
    private MatrizCasilleros matrizCasilleros;
    private Usuarios usuario;

    // Constructor: Llama al cosntructor de la clase Proceso y setea sus atributos adicionales
    public Preparacion(RegistroPedidos registros, int demora, MatrizCasilleros matrizCasilleros, int cantidadPedidos) {
        super(demora, registros, cantidadPedidos);
        this.matrizCasilleros = matrizCasilleros;
    }

    @Override
    public void run() {
        while (registros.getCantidadPedidos(5) < cantidadPedidosMax) {
            usuario = new Usuarios(); // Simula la llegada de un usuario
            Pedido pedido = usuario.getPedido();// Obtiene el pedido que tiene el usuario
            int posicion[] = matrizCasilleros.obtenerPosicionCasilleroDisponible(); // Pide la posicion de un casillero VACIO

            if (matrizCasilleros.ocuparCasillero(posicion)) {
                registros.agregarPedido(pedido, 0);
            } else {
                System.out.println("Asignacion de un pedido a un casillero no Vacio");  // Imprimir q el casillero no es valido
            }

            demorar(); // Manda al hilo a dormir
        }
    }
}