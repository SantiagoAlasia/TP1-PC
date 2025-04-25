public class Usuarios{
    private final int id;
    private final Pedido pedido; // Pedido con el que se trabajara
    private static int contadorUsuarios = 0;

    // Constructor: Simplemente se asigna un id y crea un pedido
    public Usuarios(){
        this.id = ++contadorUsuarios;
        pedido = new Pedido(id);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public int getId() {
        return id;
    }
}