package app;

import java.util.Random;

public class MatrizCasilleros {
    private final Casillero[][] matriz; // Matriz de casilleros, estara limitada a lo pedido por consigna
    private final int filas;
    private final int columnas;

    // Constructor: Crea la matriz del tamaño especificado y la carga de casilleros
    public MatrizCasilleros(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matriz = new Casillero[filas][columnas];
        inicializarCasilleros();
    }

    // Inicializa todos los casilleros de la matriz como vacios
    // Solo se usa por el constructor, por lo que no es nesesario usar SYNCRONIZED
    private void inicializarCasilleros() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = new Casillero();
            }
        }
    }

    // Buscaremos de manera aleatoria casilleros que esten vacios
    // Si encuentra casillero vacios, los ocupa y retornaremos la posicion dentro de la matriz
    // Si no se encuentran casilleros, se retornara {-1, -1}
    public synchronized int[] getPosicionCasilleroDisponible() {
        int [] posicion  = {0, 0};
        int [] error = {-1, -1};
        Random random = new Random();

        for (int intento = 0; intento < 500; intento++) {
            posicion[0] = random.nextInt(filas);
            posicion[1] = random.nextInt(columnas);
            Casillero c = matriz[posicion[0]][posicion[1]];

            if (c.getEstado() == EstadoCasillero.VACIO){
                boolean casilleroDisponible = c.ocupar();

                if (!casilleroDisponible){
                    System.out.println("(Preparacion): Se quiso ocupar un casillero que ya estaba ocupado");
                }

                return posicion;
            }
        }
        return error;
    }

    // Para la estadistica, metodo para obtener todos la matriz de casilleros
    public synchronized Casillero[][] getMatriz() {
        return matriz;
    }

    // Unicamente lo utiliza el hiloLog por lo que no es nesesario usar SYNCRONIZED
    public int getFilas(){
        return filas;
    }

    // Unicamente lo utiliza el hiloLog por lo que no es nesesario usar SYNCRONIZED
    public int getColumnas() {
        return columnas;
    }

    public synchronized void liberarCasillero(int[] posicion) {
        matriz[posicion[0]][posicion[1]].liberar();
    }

    public synchronized void marcarCasilleroFueraDeServicio(int[] posicion) {
        matriz[posicion[0]][posicion[1]].marcarFueraDeServicio();
    }
}