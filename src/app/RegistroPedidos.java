package app;

import java.util.ArrayDeque;
import java.util.Queue;

public class RegistroPedidos {
    Queue<Pedido> pedidosEnPreparacion;
    Queue<Pedido> pedidosEnTransito;
    Queue<Pedido> pedidosEntregados;
    Queue<Pedido> pedidosFallidos;
    Queue<Pedido> pedidosVerificados;

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
    public synchronized void agregarPedido(Pedido pedido, int destino){
        switch(destino){
            case 0:
                pedidosEnPreparacion.add(pedido);
                break;
            case 1:
                pedidosEnTransito.add(pedido);
                break;
            case 2:
                pedidosEntregados.add(pedido);
                break;
            case 3:
                pedidosFallidos.add(pedido);
                break;
            case 4:
                pedidosVerificados.add(pedido);
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
    public synchronized Pedido eliminarPedido(int destino){
        switch(destino){
            case 0:
                return  pedidosEnPreparacion.poll();
            case 1:
                return pedidosEnTransito.poll();
            case 2:
                return pedidosEntregados.poll();
            case 3:
                return pedidosFallidos.poll();
            case 4:
                return pedidosVerificados.poll();
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
    public synchronized int getCantidadPedidos(int destino){
        switch(destino){
            case 0:
                return pedidosEnPreparacion.size();
            case 1:
                return pedidosEnTransito.size();
            case 2:
                return pedidosEntregados.size();
            case 3:
                return pedidosFallidos.size();
            case 4:
                return pedidosVerificados.size();
            default:
                return -1;
        }
    }
}