package procesos;

import app.Pedido;
import app.RegistroPedidos;

public class Entrega extends Proceso{
    private double probError;

    // Constructor: Llama al cosntructor de la clase Proceso y setea sus atributos adicionales
    public Entrega(RegistroPedidos registros, int demora, int cantidadPedidos, double probError) {
        super(demora, registros, cantidadPedidos);
        this.probError = probError;
    }

    @Override
    public void run() {
        while (getPedidosIngresado() < cantidadPedidosMax || (registros.getCantidadPedidos(0) + registros.getCantidadPedidos(1)) != 0) {
            try{
                Pedido pedido = registros.eliminarPedido(1); // Trata de eliminar un pedido de la cola de Pedidos en Transito

                if(Math.random() > probError){ // Actua en base a la probabilidad de error
                    registros.agregarPedido(pedido, 2); // Agrega el pedido a la cola de Pedidos Entregados
                } else{
                    registros.agregarPedido(pedido, 3); // Agrega el pedido a la cola de Pedidos Fallidos
                }

                demorar(); // Manda al hilo a dormir
            }catch(Exception e){ // Si no encuntra ningun pedido en la cola, duerme 1ms y vuelve a tratar
                //System.out.println("(Entrega): Registro de Pedidos en Transito vacio. Esperando mas pedidos");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}