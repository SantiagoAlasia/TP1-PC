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
    private void inicializarcasilleros() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = new Casillero(idCasillero);
            }
        }
    }

    // Buscaremos de manera aleatoria casilleros que esten vacios y retornaremos la posicion dentro de la matriz
    // Si no se encuentran casilleros, se retornara null
    public int[] obtenerPosicionCasilleroDisponible() {
        int [] posicion  = {0, 0};
        Casillero c;

        for (int intento = 0; intento < 200; intento++) {
            posicion[0] = random.nextInt(filas);
            posicion[1] = random.nextInt(columnas);
            Casillero c = matriz[posicion[0]][posicion[1]];

            if (c.getEstado == EstadoCasillero.VACIO){
                return posicion;
            }
        }
        return null;
    }

    // Para la estadistica, metodo para obtener todos la matriz de casilleros
    public Casillero[][] getMatriz() {
        return matriz;
    }

    public int getFilas(){
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}