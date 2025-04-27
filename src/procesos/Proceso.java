package procesos;

import app.RegistroPedidos;

public abstract class Proceso implements Runnable{
    protected int demora;
    protected RegistroPedidos registros;
    protected int cantidadPedidosMax;

    // Constructor: Inicializa los valores generales a cada proceso
    public Proceso(int demora, RegistroPedidos registros, int cantiadadPedidos){
        this.demora = demora;
        this.registros = registros;
        this.cantidadPedidosMax = cantiadadPedidos;
    }

    // Metodo para mandar a dormir al hilo el tiempo que corresponda en cada caso
    protected void demorar() {
        try {
            Thread.sleep(demora);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run(){}
}