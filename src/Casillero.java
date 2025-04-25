public class Casillero {
    private EstadoCasillero estado;
    private int contador;

    // Constructor: Inicializa el contador y setea el estado en vacio
    public Casillero() {
        this.estado = EstadoCasillero.VACIO;
        this.contador = 0;
    }

    public EstadoCasillero getEstado(){
        return estado;
    }

    public String toString() {
        return "ocupado " + contador + " veces, con estado final: " + estado ;
    }

    // Cambia el estado si es que es valido el cambio
    public boolean ocupar() {
        if (estado = EstadoCasillero.VACIO){
            estado = EstadoCasillero.OCUPADO;
            contador++;
            return true;
        }
        return false; // No es posible cambiar de estado
    }

    public void liberar() {
        estado = EstadoCasillero.VACIO;
    }

    public void marcarFueraDeServicio() {
        estado = EstadoCasillero.FUERA_DE_SERVICIO;
    }
}