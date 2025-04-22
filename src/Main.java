public class main {
    public  static void main(String[] args){
        // Inicializacion de Objetos claves para el sistema.
        ListasDePedidos  listados = new ListaDePedidos();
        MatrizCasilleros casilleros = new MatrizCasilleros(10, 20);

        // Creacion de los hilos de procesos y de Log.
        Thread hiloLog = new Thread(new Log(););
        Threa hilos[] = new Thread[10];

        // Asignacion de procesos a cada hilo.
        for(int i = 0; i < 10; i++){
            switch(i) {
                case 0: case 1: case 2: // Preparacion de pedidos.
                    hilos[i] = new Thread(new PreparacionPedido());
                    break;
                case 3: case 4: // Despacho de pedidos.
                    hilos[i] = new Thread(new DespachoPedido());
                    break;
                case 5: case 6: case 7: // Entrega al cliente.
                    hilos[i] = new Thread(new EntregaCliente());
                    break;
                case 8: case 9: // Verificación final.
                    hilos[i] = new Thread(new VerificacionFinal());
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

        System.out.println("Simulación finalizada.");
    }
}