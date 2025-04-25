public class Pedido {
    private int[] posicionCasillero; // Posicion del casillero asociado al pedido
    private final int idUsuario;  // Indicador del Usuario que creo el pedido

    // Constructor: Guarda el id del usuario que lo creo
    public Pedido(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public int getPosicionCasillero() {
        return posicionCasillero;
    }

    public void setPosicionCasillero(int[] posicionCasillero) {
        this.posicionCasillero = posicionCasillero;
    }
}