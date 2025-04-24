public class main {
    // Constantes que definen la simulacion
    // Los valores son tomados del enunciado
    private static final int cantidadPedidosMax = 500; // Maxima cantidad de pedidos que se van a recibir
    private static final int filasMatriz = 10;
    private static final int columnasMatriz = 20;
    private static final float probErrorDespacho = 0.15;
    private static final float probErrorEntregas = 0.10;
    private static final float probErrorVerificacion = 0.05;

    // Definimos los tiempos para cada proceso
    private static final int demoraPreparacion = 1000;
    private static final int demoraDespacho = 2000;
    private static final int demoraEntregas = 500;
    private static final int demoraVerificacion = 750;
    private static final int demoraLog = 200; //200ms

    public  static void main(String[] args){
        // Instanciacion de las clases ListaDePedidos y MatrizCasilleros
        RegistroPedidos  registros = new RegistroPedidos();
        MatrizCasilleros matrizCasilleros = new MatrizCasilleros(10, 20);

        // Creacion de los hilos de procesos y de Log
        Thread hiloLog = new Thread(new Log(matrizCasilleros, registros, demoraLog););
        Thread hilos[] = new Thread[10];

        // Asignacion de procesos a cada hilo.
        for(int i = 0; i < 10; i++){
            switch(i) {
                case 0: case 1: case 2: // Preparacion de pedidos
                    hilos[i] = new Thread(new PreparacionPedido(listaDePedidos, demoraPreparacion, matrizCasilleros, cantidadPedidosMax));
                    break;
                case 3: case 4: // Despacho de pedidos
                    hilos[i] = new Thread(new DespachoPedido(listaDePedidos, demoraDespacho, matrizCasilleros, probErrorDespacho));
                    break;
                case 5: case 6: case 7: // Entrega al cliente
                    hilos[i] = new Thread(new EntregaCliente(listaDePedidos, demoraEntregas, probErrorEntregas));
                    break;
                case 8: case 9: // Verificación final
                    hilos[i] = new Thread(new VerificacionFinal(listaDePedidos, demoraVerificacion, probErrorVerificacion);
                    break;
            }
        }

        // Iniciar todos los hilos
        loggerThread.start();
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

        // Esperar que termine el hilo de Log
        try {
            hiloLog.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n---------------- Simulación finalizada ----------------\n");
    }
}
