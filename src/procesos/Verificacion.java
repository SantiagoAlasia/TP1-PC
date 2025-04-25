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
        while (registros.getCantidadPedidos(3) + registros.getCantidadPedidos(4) < cantidadPedidosMax) {
            Pedido pedido = registros.eliminarPedido(2);

            if(Math.random() > probError){ // En base a la probabilidad de error, cambia de cola un pedido
                registros.agregarPedido(pedido, 4);
            } else{
                registros.agregarPedido(pedido, 3);
            }
            demorar(); // Manda al hilo a dormir
        }
    }
}