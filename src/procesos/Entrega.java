public class Entrega() extends Proceso{
    private int probError;

    // Constructor: Llama al cosntructor de la clase Proceso y setea sus atributos adicionales
    public Entrega(RegistroPedidos registros, int demora, int cantidadPedidos, int probError) {
        super(registros, demora, cantidadPedidos);
        this.probError = probError;
    }

    @Override
    public void run() {
        while (registros.getCantidadPedidos(5) < cantidadPedidosMax && registros.getCantidadPedidos(0) + registros.getCantidadPedidos(1) != 0) {
            Pedido pedido = registro.eliminarPedido(1);

            if(Math.random() > probError)){ // Actua en base a la probabilidad de error
                registro.agregarPedido(pedido, 2);
            }
            else{
                registro.agregarPedido(pedido, 3);
            }
            demorar(); // Manda al hilo a dormir
        }
    }
}