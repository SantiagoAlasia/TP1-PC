public class Casillero {
    private final int id;
    private EstadoCasillero estado;
    private int contador;

    public Casillero(int id) {
        this.id = id;
        this.estado = EstadoCasillero.VACIO;
        this.contador = 0;
    }

    public int getId() {
        return id;
    }

    public String getEstado() {
        return "ocupado " + contador + " veces, con estado final: " + estado ;
    }

    public boolean ocupar() {
        if (estado = EstadoCasillero.VACIO){
            estado = EstadoCasillero.OCUPADO;
            contador++;
            return true;
        }
        return false;
    }

    public void liberar() {
        estado = EstadoCasillero.VACIO;
    }

    public void marcarFueraDeServicio() {
        estado = EstadoCasillero.FUERA_DE_SERVICIO;
    }
}