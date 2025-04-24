public class Pedido {
    private final int id; // Identificador del pedido
    private int idCasillero; // Identificador del casillero asociado al pedido
    private int idUsuario;  // Indicador del Usuario que creo el pedido

    public Pedido(int id, int idUsuario) {
        this.id = id;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public int getIdCasillero() {
        return idCasillero;
    }

    public void setIdCasillero(int idCasillero) {
        this.idCasillero = idCasillero;
    }
}