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
        while (registros.getCantidadPedidos(5) < cantidadPedidosMax && registros.getCantidadPedidos(0) + registros.getCantidadPedidos(1) != 0) {
            Pedido pedido = registros.eliminarPedido(1);

            if(Math.random() > probError){ // Actua en base a la probabilidad de error
                registros.agregarPedido(pedido, 2);
            } else{
                registros.agregarPedido(pedido, 3);
            }
            demorar(); // Manda al hilo a dormir
        }
    }
}