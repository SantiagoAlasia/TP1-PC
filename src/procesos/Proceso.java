package procesos;

import app.RegistroPedidos;

public abstract class Proceso implements Runnable{
    protected int demora;
    protected RegistroPedidos registros;
    protected int cantidadPedidosMax;
    protected static int pedidosIngresado; // Contados de los pedidos totales del sistema

    // Constructor: Inicializa los valores generales a cada proceso
    public Proceso(int demora, RegistroPedidos registros, int cantiadadPedidos){
        this.demora = demora;
        this.registros = registros;
        this.cantidadPedidosMax = cantiadadPedidos;
        this.pedidosIngresado = 0;
    }

    // Metodo para mandar a dormir al hilo el tiempo que corresponda en cada caso
    protected void demorar() {
        try {
            Thread.sleep(demora);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    protected static synchronized void incrementarPedidosIngresado() {
        pedidosIngresado++;
    };

    protected static synchronized int getPedidosIngresado() {
        return pedidosIngresado;
    }

    @Override
    public void run(){}
}