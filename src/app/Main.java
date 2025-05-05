package app;

import procesos.Preparacion;
import procesos.Despacho;
import procesos.Entrega;
import procesos.Verificacion;

public class Main {
    // Constantes que definen la simulacion
    // Los valores son tomados del enunciado
    private static final int cantidadPedidosMax = 500; // Maxima cantidad de pedidos que se van a recibir
    private static final int filasMatriz = 10;
    private static final int columnasMatriz = 20;
    private static final double probErrorDespacho = 0.15;
    private static final double probErrorEntregas = 0.10;
    private static final double probErrorVerificacion = 0.05;

    // Definimos los tiempos para cada proceso
    private static final int demoraPreparacion = 70;
    private static final int demoraDespacho = 90;
    private static final int demoraEntregas = 50;
    private static final int demoraVerificacion = 40;
    private static final int demoraLog = 200; //200ms

    // Constructor: Instancia los objetos y lanza los hilos
    public static void main(String[] args){
        // Instanciacion de las clases app.RegistroPedidos y app.MatrizCasilleros
        RegistroPedidos registros = new RegistroPedidos();
        MatrizCasilleros matrizCasilleros = new MatrizCasilleros(filasMatriz, columnasMatriz);

        // Creacion de los hilos de procesos y de app.Log
        Thread hiloLog = new Thread(new Log(matrizCasilleros, registros, demoraLog));
        Thread[] hilos = new Thread[10];

        // Asignacion de procesos a cada hilo.
        for(int i = 0; i < 10; i++){
            switch(i) {
                case 0: case 1: case 2: // Preparacion de pedidos
                    hilos[i] = new Thread(new Preparacion(registros, demoraPreparacion, matrizCasilleros, cantidadPedidosMax));
                    break;
                case 3: case 4: // Despacho de pedidos
                    hilos[i] = new Thread(new Despacho(registros, demoraDespacho, matrizCasilleros, cantidadPedidosMax, probErrorDespacho));
                    break;
                case 5: case 6: case 7: // Entrega al cliente
                    hilos[i] = new Thread(new Entrega(registros, demoraEntregas, cantidadPedidosMax, probErrorEntregas));
                    break;
                case 8: case 9: // Verificación final
                    hilos[i] = new Thread(new Verificacion(registros, demoraVerificacion, cantidadPedidosMax, probErrorVerificacion));
                    break;
            }
        }

        // Iniciar todos los hilos
        hiloLog.start();
        for (int i = 0; i < 10; i++) {
            hilos[i].start();
        }

        // Esperar que terminen todos los hilos
        for (int i = 0; i < 10; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Detiene el hilo logger
        Log.detener();
        try {
            hiloLog.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n---------------- Simulación finalizada ----------------\n");
    }
}