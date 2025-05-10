package app;

import java.util.ArrayDeque;
import java.util.Queue;

public class RegistroPedidos {
    Queue<Pedido> pedidosEnPreparacion;
    Queue<Pedido> pedidosEnTransito;
    Queue<Pedido> pedidosEntregados;
    Queue<Pedido> pedidosFallidos;
    Queue<Pedido> pedidosVerificados;

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();
    private final Object lock4 = new Object();
    private final Object lock5 = new Object();

    // Constructor: Inicializa todas las Colas
    public RegistroPedidos(){
        pedidosEnPreparacion = new ArrayDeque<>();
        pedidosEnTransito = new ArrayDeque<>();
        pedidosEntregados = new ArrayDeque<>();
        pedidosFallidos = new ArrayDeque<>();
        pedidosVerificados = new ArrayDeque<>();
    }

    // Agrega el pedido a la lista destino
    // Si destino == 0 => Pedidos en preparacion
    //    destino == 1 => Pedidos en Transito
    //    destino == 2 => Pedidos Entregados
    //    destino == 3 => Pedidos Fallidos
    //    destino == 4 => Pedidos Verificados
    public void agregarPedido(Pedido pedido, int destino){
        switch(destino){
            case 0:
                synchronized (lock1) {
                    pedidosEnPreparacion.add(pedido);
                }
                break;
            case 1:
                synchronized (lock2) {
                    pedidosEnTransito.add(pedido);
                }
                break;
            case 2:
                synchronized (lock3) {
                    pedidosEntregados.add(pedido);
                }
                break;
            case 3:
                synchronized (lock4) {
                    pedidosFallidos.add(pedido);
                }
                break;
            case 4:
                synchronized (lock5) {
                    pedidosVerificados.add(pedido);
                }
                break;
            default:
                break;
        }
    }

    // Retorna y Elimina un pedido de la lista destino
    // Si destino == 0 => Pedidos en preparacion
    //    destino == 1 => Pedidos en Transito
    //    destino == 2 => Pedidos Entregados
    //    destino == 3 => Pedidos Fallidos
    //    destino == 4 => Pedidos Verificados
    public Pedido eliminarPedido(int destino){
        switch(destino){
            case 0:
                synchronized (lock1) {
                    return  pedidosEnPreparacion.poll();
                }
            case 1:
                synchronized (lock2) {
                    return pedidosEnTransito.poll();
                }
            case 2:
                synchronized (lock3) {
                    return pedidosEntregados.poll();
                }
            case 3:
                synchronized (lock4) {
                    return pedidosFallidos.poll();
                }
            case 4:
                synchronized (lock5) {
                    return pedidosVerificados.poll();
                }
            default:
                return null;
        }
    }

    // Retorna la cantidad de pedidos en la cola
    // Si destino == 0 => Pedidos en preparacion
    //    destino == 1 => Pedidos en Transito
    //    destino == 2 => Pedidos Entregados
    //    destino == 3 => Pedidos Fallidos
    //    destino == 4 => Pedidos Verificados
    public int getCantidadPedidos(int destino){
        switch(destino){
            case 0:
                synchronized (lock1) {
                    return pedidosEnPreparacion.size();
                }
            case 1:
                synchronized (lock2) {
                    return pedidosEnTransito.size();
                }
            case 2:
                synchronized (lock3) {
                    return pedidosEntregados.size();
                }
            case 3:
                synchronized (lock4) {
                    return pedidosFallidos.size();
                }
            case 4:
                synchronized (lock5) {
                    return pedidosVerificados.size();
                }
            default:
                return -1;
        }
    }
}