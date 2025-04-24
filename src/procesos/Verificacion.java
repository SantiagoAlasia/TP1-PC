public class Verificacion() extends  Proceso{
    private int probError;

    public Verificacion(RegistroPedidos registros, int demora, int cantidadPedidos, int probError) {
        super(registros, demora, cantidadPedidos);
        this.probError = probError;
    }

    @Override
    public void run() {
        while (registros.getCantidadPedidos(3) + registros.getCantidadPedidos(4) < cantidadPedidosMax) {
            // En base a la probabilidad de erro, cambia de cola un pedido
            demorar(); // Manda al hilo a dormir
        }
    }
}