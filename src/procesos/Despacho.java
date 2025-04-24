import java.util.Random;

public class Despacho() extends  Proceso{
    private int probError;
    private MatrizCasilleros matrizCasilleros;
    private random;
    

    public Despacho(RegistroPedidos registros, int demora, MatrizCasilleros matrizCasilleros,int cantidadPedidos, int probError) {
        super(registros, demora, cantidadPedidos);
        this.matrizCasilleros = matrizCasilleros;
        this.probError = probError;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (registros.getCantidadPedidos(5) < cantidadPedidosMax && registros.getCantidadPedidos(0) != 0) {
            if(random.nextDouble() > probError)){ // Actua en base a la probabilidad de error
                // Cambiar un pedido del registro de preparacion al registro en transito
                // Pone vacio el casillero
            } 
            else{
                // Si entra en los casos de error, cambiar a fuera de servicio    
            }
            demorar(); // Manda al hilo a dormir
        }
    }
}
