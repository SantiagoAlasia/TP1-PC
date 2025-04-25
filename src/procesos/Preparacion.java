public class Preparacion () extends Proceso{
    private MatrizCasilleros matrizCasilleros;
    private Usuarios usuario;

    // Constructor: Llama al cosntructor de la clase Proceso y setea sus atributos adicionales
    public Preparacion(RegistroPedidos registros, int demora, MatrizCasilleros matrizCasilleros, int cantidadPedidos) {
        super(registros, demora, cantidadPedidos);
        this.matrizCasilleros = matrizCasilleros;
    }

    @Override
    public void run() {
        while (registros.getCantidadPedidos(5) < cantidadPedidosMax) {
            usuario = new Usuario(); // Simula la llegada de un usuario
            Pedido pedido = Usuario.getPedido();// Obtiene el pedido que tiene el usuario
            int posicion[] = matrizCasilleros.obtenerPosicionCasilleroDisponible(); // Pide la posicion de un casillero VACIO
            if (!matrizCasilleros[posicion[0]][posicion[1]].ocupar()) {
                System.out.println("Asignacion de un pedido a un casillero no Vacio");  // Imprimir q el casillero no es valido
            }
            registros.agregarPedido(pedido, 0);
            demorar(); // Manda al hilo a dormir
        }
    }
}