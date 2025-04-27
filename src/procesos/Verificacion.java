package procesos;

import app.Pedido;
import app.RegistroPedidos;

public class Verificacion extends  Proceso{
    private double probError;

    // Constructor: Llama al cosntructor de la clase Proceso y setea sus atributos adicionales
    public Verificacion(RegistroPedidos registros, int demora, int cantidadPedidos, double probError) {
        super(demora, registros, cantidadPedidos);
        this.probError = probError;
    }

    @Override
    public void run() {
        while ((registros.getCantidadPedidos(3) + registros.getCantidadPedidos(4)) < cantidadPedidosMax) {
            try{
                Pedido pedido = registros.eliminarPedido(2); // Trata de eliminar un pedido de la cola de Pedidos Entregados

                if(Math.random() > probError){ // En base a la probabilidad de error, cambia de cola un pedido
                    registros.agregarPedido(pedido, 4); // Agrega el pedido a la cola de Pedidos Verificados
                } else{
                    registros.agregarPedido(pedido, 3); // Agrega el pedido a la cola de Pedidos Fallidos
                }

                demorar(); // Manda al hilo a dormir
            }catch(Exception e){ // Si no encuntra ningun pedido en la cola, duerme 1ms y vuelve a tratar
                //System.out.println("(Verificacion): Registro de Pedidos Entregados vacio. Esperando mas pedidos");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}