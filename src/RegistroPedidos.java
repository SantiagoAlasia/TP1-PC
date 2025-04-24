import java.util.ArrayDeque;
import java.util.Queue;

public class RegistroPedidos(){
    Queue<Pedido> pedidosEnPreparacion;
    Queue<Pedido> pedidosEnTransito;
    Queue<Pedido> pedidosEntregados;
    Queue<Pedido> pedidosFallidos;
    Queue<Pedido> pedidosVerificados

    public static RegistroPedidos(){
        pedidosEnPreparacion = new ArrayDeque<>();
        pedidosEnTransito = new ArrayDeque<>();
        pedidosEntregados = new ArrayDeque<>();
        pedidosFallidos = new ArrayDeque<>();
        pedidosVerificados = new ArrayDeque<>();
    };

    // Agrega el pedido a la lista destino
    // Si destino == 0 => Pedidos en preparacion
    //    destino == 1 => Pedidos en Transito
    //    destino == 2 => Pedidos Entregados
    //    destino == 3 => Pedidos Fallidos
    //    destino == 4 => Pedidos Verificados
    public void agregarPedido(Pedido pedido, int destino){
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
    public Pedido eliminarPedido(int destino){
        switch(destino){
            case 0:
                return  pedidosEnPreparacion.remove();
                break;
            case 1:
                return pedidosEnTransito.remove();
                break;
            case 2:
                return pedidosEntregados.remove();
                break;
            case 3:
                return pedidosFallidos.remove();
                break;
            case 4:
                return pedidosVerificados.remove();
                break;
            default:
                return null;
                break;
        }
    }

    // Retorna la cantidad de pedidos en la cola
    // Si destino == 0 => Pedidos en preparacion
    //    destino == 1 => Pedidos en Transito
    //    destino == 2 => Pedidos Entregados
    //    destino == 3 => Pedidos Fallidos
    //    destino == 4 => Pedidos Verificados
    //    destino == 5 => Total de pedidos
    public int getCantidadPedidos(int destino){
        switch(destino){
            case 0:
                return pedidosEnPreparacion.size();
                break;
            case 1:
                return pedidosEnTransito.size();
                break;
            case 2:
                return pedidosEntregados.size();
                break;
            case 3:
                return pedidosFallidos.size();
                break;
            case 4:
                return pedidosVerificados.size();
                break;
            case 5:
                return (pedidosEnPreparacion.size() + pedidosEnTransito.size() + pedidosEntregados.size() + pedidosFallidos.size() + pedidosVerificados.size());
            default:
                return null;
                break;
        }
    }

}