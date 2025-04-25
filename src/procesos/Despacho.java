package procesos;

import app.Pedido;
import app.MatrizCasilleros;
import app.RegistroPedidos;

public class Despacho extends  Proceso {
    private final double probError;
    private MatrizCasilleros matrizCasilleros;

    // Constructor: Llama al cosntructor de la clase Proceso y setea sus atributos adicionales
    public Despacho(RegistroPedidos registros, int demora, MatrizCasilleros matrizCasilleros,int cantidadPedidos, double probError) {
        super(demora, registros, cantidadPedidos);
        this.matrizCasilleros = matrizCasilleros;
        this.probError = probError;
    }

    @Override
    public void run() {
        while (registros.getCantidadPedidos(5) < cantidadPedidosMax && registros.getCantidadPedidos(0) != 0) {
            Pedido pedido = registros.eliminarPedido(0);
            int [] posicion = pedido.getPosicionCasillero();

            if( Math.random() > probError){ // Actua en base a la probabilidad de error
                registros.agregarPedido(pedido, 1);
                matrizCasilleros.liberarCasillero(posicion); // Pone vacio el estado del casillero
            } else{
                registros.agregarPedido(pedido, 3);
                matrizCasilleros.marcarCasilleroFueraDeServicio(posicion); // Cambia el estado del casilero a fuera de servicio
            }

            demorar(); // Manda al hilo a dormir
        }
    }
}
