package app;

public class Casillero {
    private EstadoCasillero estado;
    private int contador;

    // Constructor: Inicializa el contador y setea el estado en vacio
    public Casillero() {
        this.estado = EstadoCasillero.VACIO;
        this.contador = 0;
    }

    public synchronized EstadoCasillero getEstado() {
        return estado;
    }

    // No es SYNCRONIZED ya que solo hara uso de este metodo el UNICO hiloLog
    public int getContador() {
        return contador;
    }

    // No es SYNCRONIZED ya que solo hara uso de este metodo el UNICO hiloLog
    public String toString() {
        return "ocupado " + contador + " veces, con estado final: " + estado ;
    }

    // Cambia el estado si es que es valido el cambio
    public synchronized boolean ocupar() {
        if (estado == EstadoCasillero.VACIO){
            estado = EstadoCasillero.OCUPADO;
            contador ++;
            return true;
        }
        return false; // No es posible cambiar de estado
    }

    public synchronized void liberar() {
        estado = EstadoCasillero.VACIO;
    }

    public synchronized void marcarFueraDeServicio() {
        estado = EstadoCasillero.FUERA_DE_SERVICIO;
    }
}