public abstract class Procesos implements Runnable{
    protected int demora;
    protected RegistroPedidos registros;
    protected cantidadPedidosMax;

    public Proceso(int demora, RegistroPedidos registros, int cantiadaPedidos){
        this.demora = demora;
        this.registros = lregistros;
        this.cantidadPedidosMax = cantiadaPedidos;
    }

    protected void demorar() {
        try {
            Thread.sleep(demora);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run();
}