package app;

public class Pedido {
    private int[] posicionCasillero; // Posicion del casillero asociado al pedido

    // Constructor: setea la posicion del casillero [0, 0]
    public Pedido() {}

    public synchronized int [] getPosicionCasillero() {
        return posicionCasillero;
    }

    public synchronized  void setPosicionCasillero(int[] posicionCasillero) {
        this.posicionCasillero = posicionCasillero;
    }
}