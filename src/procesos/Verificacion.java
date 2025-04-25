public class Verificacion() extends  Proceso{
    private int probError;

    // Constructor: Llama al cosntructor de la clase Proceso y setea sus atributos adicionales
    public Verificacion(RegistroPedidos registros, int demora, int cantidadPedidos, int probError) {
        super(registros, demora, cantidadPedidos);
        this.probError = probError;
    }

    @Override
    public void run() {
        while (registros.getCantidadPedidos(3) + registros.getCantidadPedidos(4) < cantidadPedidosMax) {
            pedido = registro.eliminarPedido(2);

            if(Math.random() > probError)){ // En base a la probabilidad de error, cambia de cola un pedido
                registro.agregarPedido(pedido, 4);
            }
            else{
                registro.agregarPedido(pedido, 3);
            }
            demorar(); // Manda al hilo a dormir
        }
    }
}