package procesos;

import app.Pedido;
import app.MatrizCasilleros;
import app.RegistroPedidos;

public class Despacho extends  Proceso {
    private final double probError;
    private MatrizCasilleros matrizCasilleros;

    // Constructor: Llama al cosntructor de la clase Proceso y setea sus atributos adicionales
    public Despacho(RegistroPedidos registros, int demora, MatrizCasilleros matrizCasilleros,int cantidadPedidos, double probError) {
        super(demora, registros, cantidadPedidos);
        this.matrizCasilleros = matrizCasilleros;
        this.probError = probError;
    }

    @Override
    public void run() {
        while (registros.getCantidadPedidos(5) < cantidadPedidosMax || registros.getCantidadPedidos(0) != 0) {
            try{
                Pedido pedido = registros.eliminarPedido(0); // Trata de eliminar un pedido de la cola de Pedidos en Preparacion
                int [] posicion = pedido.getPosicionCasillero(); // Busca la posicion del casillero vinculado al pedido seleccionado

                if (Math.random() > probError){ // Actua en base a la probabilidad de error
                    registros.agregarPedido(pedido, 1); // Agrega el pedido a la cola de Pedidos en Transito
                    matrizCasilleros.liberarCasillero(posicion); // Pone vacio el estado del casillero

                } else{
                    registros.agregarPedido(pedido, 3); // Agrega el pedido al registro de Pedidos Fallidos
                    matrizCasilleros.marcarCasilleroFueraDeServicio(posicion); // Cambia el estado del casilero a fuera de servicio
                }

                demorar(); // Manda al hilo a dormir
            }catch (Exception e){ // Si no encuntra ningun pedido en la cola, duerme 1ms y vuelve a tratar
                //System.out.println("(Despacho): Registro de Pedidos en Preparacion vacio. Esperando mas pedidos");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
