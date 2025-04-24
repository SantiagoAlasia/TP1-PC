public class Despacho() extends  Proceso{
    private int probError;
    private MatrizCasilleros matrizCasilleros;

    public Despacho(RegistroPedidos registros, int demora, MatrizCasilleros matrizCasilleros,int cantidadPedidos, int probError) {
        super(registros, demora, cantidadPedidos);
        this.matrizCasilleros = matrizCasilleros;
        this.probError = probError;
    }

    @Override
    public void run() {
        while (registros.getCantidadPedidos(5) < cantidadPedidosMax && registros.getCantidadPedidos(0) != 0) {
            // En base a la probabilidad de error, cambiar de colas un registro
            // Cambia el estado del casillero a vacio
            // Si entra en los casos de error, cambiar a fuera de servicio
            demorar(); // Manda al hilo a dormir
        }
    }
}