public class Usuarios{
    private Pedido pedido; // Pedido con el que se trabajara

    public Usuarios(){
        pedido = new Pedido();
    }

    public Pedido getPedido() {
        return pedido;
    }
}