import java.io.FileWriter; // Permite escribir texto en un archivo (crea o abre un archivo log.txt y prmite escribir un texto )
import java.io.PrintWriter; //lo vamos a usar para escribir el log linea por linea de forma legible
import java.io.IOException; // usamos el try/catch para atrapar error al abir o escribir el log.txt
import java.lang.Thread; // el log "duerme" 200 ms entre cada registro, simulando un monitoreoperiodico del sistema

public class Log implements Runnable {
    private final RegistroPedidos registros; //Consulta pedidos fallidos / verificados
    private final MatrizCasilleros matrizCasilleros; // Permite acceder a los casileros
    private final long inicio; //guarda el tiempo de inicio del programa
    private boolean ejecutar = true; //control para detener el hilo
    private int demora; //tiempo que debera esperar entre escritura y escritura

    //constructor: recibe la lista de pedidos y la matriz de casilleros
    public Log (MatrizCasilleros matrizCasilleros, RegistroPedidos registros, int demora) {
        this.matrizCasilleros = matrizCasilleros;
        this.registros = registros;
        this.inicio = System.currentTimeMillis(); // guarda el tiempo de inicio en milisegundos
        this.demora = demora;
    }

    //Metodo que permite detener el hilo desde afuera
    public void detener () {
        ejecutar = false;
    }

    @Override
    public void run() {
        try (
                //abrimos un archivo para escribir el log
                PrintWriter log = new PrintWriter(new FileWriter ("./data/log.txt"))
        ){
            //mientras el sistema siga ejecutando
            while (ejecutar) {
                //Obtenemos la cantidad actual de pedidos fallidos y verificados
                int fallidos = registros.getCantidadPedidos (3);
                int verificados = registros.getCantidadVerificados (4);

                //Escribimos una linea con esos valores
                log.println("Fallidos: " + fallidos + "      Verificados: " + verificados);
                log.flush(); //forzamos que escriba el archivo sin esperar
                Thread.sleep (200); //esperamos 200 ms antes de repetir
            }
            // cuando el hilo se detiene escribimos estadísticas finales
            log.println("\n --- Estadísticas Finales ---");

            Casillero[][] matriz = matrizCasilleros.getMatriz(); //obtenemos la matriz completa
            for (int i = 0; i < matrizCasilleros.getCantFilas(); i++) {
                for (int j = 0; j < matrizCasilleros.getCantColumnas(); j++) {
                    Casillero c = matriz[i][j];

                    // cuantas veces el casillero fue ocupado y su estado final
                    log.println("Casillero [" + i + "][" + j + "]: " + c.getEstado());
                }
            }
            //tiempo total de ejecucion
            long fin = System.currentTimeMillis();
            long duracion = fin - inicio;
            log.println("\nTiempo total de ejecucion "+ duracion+"ms");


        } catch (IOException | InterruptedException e){
            e.printStackTrace();
            System.out.println("Error en con el Log");
            //si hubo un error al escribir el archivo o al dormir el hilo lo mostramos
        }
    }

}