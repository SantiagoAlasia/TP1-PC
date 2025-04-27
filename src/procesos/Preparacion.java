package procesos;

import app.MatrizCasilleros;
import app.Usuarios;
import app.RegistroPedidos;
import app.Pedido;


public class Preparacion extends Proceso{
    private MatrizCasilleros matrizCasilleros;
    private Usuarios usuario;

    // Constructor: Llama al constructor de la clase Proceso y setea sus atributos adicionales
    public Preparacion(RegistroPedidos registros, int demora, MatrizCasilleros matrizCasilleros, int cantidadPedidos) {
        super(demora, registros, cantidadPedidos);
        this.matrizCasilleros = matrizCasilleros;
    }

    @Override
    public void run() {
        while (getPedidosIngresado() < cantidadPedidosMax) {
            incrementarPedidosIngresado(); // Incremeta la cantidad de pedidos que existen en el sistema
            usuario = new Usuarios(); // Simula la llegada de un usuario
            Pedido pedido = usuario.getPedido();// Obtiene el pedido que tiene el usuario

            int error [] = {-1, -1};
            int posicion [] = error;

            // Busca un casillero que este VACIO, lo ocupa y devuelve la posicion del casillero
            while(posicion[0] == error[0] && posicion[1] == error[1]) {
                posicion = matrizCasilleros.getPosicionCasilleroDisponible();

                // Si no encontro ninguno, vuelve a tratar hasta encontrar un casillero VACIO,
                // recien ahi asigna posicion a posicionCasillero de pedido
                //if (posicion[0] == error[0] && posicion[1] == error[1]) {
                //    System.out.println("(Preparacion): No se encontro una posicion de casillero valida, volviendo a buscar para el mismo pedido ...");
                //}
            }

            pedido.setPosicionCasillero(posicion); // Le asigna la posicion del casillero al pedido
            registros.agregarPedido(pedido, 0); // Agrega el pedido a la cola Pedidos en preparacion

            demorar(); // Manda al hilo a dormir
        }
    }
}