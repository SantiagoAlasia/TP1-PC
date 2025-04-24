public class Entrega() extends  Proceso{
    private int probError;

    public Entrega(RegistroPedidos registros, int demora, int cantidadPedidos, int probError) {
        super(registros, demora, cantidadPedidos);
        this.probError = probError;
    }

    @Override
    public void run() {
        while (registros.getCantidadPedidos(5) < cantidadPedidosMax && registros.getCantidadPedidos(1) != 0) {
            // En base a la probabilidad de erro, cambia de cola un pedido
            demorar(); // Manda al hilo a dormir
        }
    }
}