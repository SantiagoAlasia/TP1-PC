package app;

public class Pedido {
    private int[] posicionCasillero; // Posicion del casillero asociado al pedido
    private final int idUsuario;  // Indicador del Usuario que creo el pedido

    // Constructor: Guarda el id del usuario que lo creo
    public Pedido(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public synchronized int [] getPosicionCasillero() {
        return posicionCasillero;
    }

    public synchronized  void setPosicionCasillero(int[] posicionCasillero) {
        this.posicionCasillero = posicionCasillero;
    }
}