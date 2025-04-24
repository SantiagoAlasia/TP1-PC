public class Preparacion () extends Proceso{
    private MatrizCasilleros matrizCasilleros;
    private Usuarios usuario;

    public Preparacion(RegistroPedidos registros, int demora, MatrizCasilleros matrizCasilleros,int cantidadPedidos) {
        super(registros, demora, cantidadPedidos);
        this.matrizCasilleros = matrizCasilleros;
    }

    @Override
    public void run() {
        while (registros.getCantidadPedidos(5) < cantidadPedidosMax) {
            // Crear un usuario
            // Obtener el pedido que tiene el usuario
            int posicion[] = matrizCasilleros.obtenerPosicionCasilleroDisponible(); // Pide la posicion de un casillero VACIO
            if (!matrizCasilleros.ocupar()) {
                // Imprimir q el casillero no es valido
            }
            registros.agregarPedido(pedido, 0);
            demorar(); // Manda al hilo a dormir
        }
    }
}