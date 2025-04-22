# TP1-PC
Trabajo Practico N°1 de Programación Concurrente.

# Enunciado
Se debe desarrollar un sistema concurrente para la gestión de entregas en una empresa de logística que realiza envíos de productos comprados en una plataforma de e-commerce. El sistema consta de varios procesos que deben ejecutarse simultáneamente y que respetan las siguientes reglas de funcionamiento.
El sistema mantiene una matriz que representa las posiciones de los casilleros en los centros de almacenamiento, de donde salen los pedidos. Cada casillero puede estar en estado: vacío, ocupado, o fuera de servicio. Además, cada casillero posee un contador que aumenta cada vez que se ocupa.
Adicionalmente, el sistema mantiene los siguientes registros:
● Pedidos en preparación
● Pedidos en tránsito
● Pedidos entregados
● Pedidos fallidos
El funcionamiento del sistema posee cuatro etapas:
Preparación de Pedido: Este proceso se encarga de recibir los pedidos de los usuarios. Se tienen tres hilos que ejecutan este proceso. Cada hilo intenta seleccionar un casillero aleatorio en la matriz, verificando que esté disponible. Si el casillero no está vacío, el hilo debe buscar otro casillero que sí lo esté. Una vez ocupado el casillero, el mismo se marca como ocupado y se registra el pedido en el registro de pedidos en preparación.
Despacho de Pedido: Este proceso es ejecutado por dos hilos, y se encarga de despachar los pedidos del listado de pedidos en preparación. Cada hilo toma un pedido aleatorio del registro de pedidos en preparación y realiza una verificación de los datos del pedido y del usuario. Se establece una probabilidad del 85% de que la información sea correcta y un 15% de que sea incorrecta. Si la información fue correcta, el casillero vuelve al estado vacío, y el pedido se elimina del registro de pedidos en preparación y se agrega al registro de pedidos en tránsito. De lo contrario, el casillero pasa a estado fuera de servicio y el pedido se marca como fallido, se elimina del registro de pedidos en preparación y se agrega al registro de pedidos fallidos.
Entrega al Cliente: Tres hilos se encargan de ejecutar este paso. Cada hilo selecciona un pedido aleatorio del registro de pedidos en tránsito y con una probabilidad del 90%, lo confirma. Si el pedido es confirmado, se elimina del registro de pedidos en tránsito y se agrega al registro de pedidos entregados. Si el pedido no es confirmado, se elimina del registro de pedidos en tránsito y se agrega al registro de pedidos fallidos.
Verificación Final: Al finalizar la ejecución, se debe verificar el estado final de los pedidos para asegurar que las operaciones se hayan realizado correctamente. Este proceso selecciona de manera aleatoria un pedido del registro de pedidos entregados, y con una probabilidad del 95%, el pedido es verificado. Si el pedido fue verificado, se debe eliminar del registro de pedidos entregados y se debe insertar en el registro de pedidos verificados. En caso contrario, se elimina del registro de pedidos entregados y se inserta en el registro de pedidos fallidos. Este proceso es ejecutado por dos hilos.

Consideraciones:
Cada proceso tiene una demora fija por iteración, pero distinta entre procesos, a ser definida por el equipo.
Cada pedido debe ser accesible por un solo hilo a la vez para evitar conflictos de asignación simultánea.
Cada pedido debe ser revisado por un solo hilo a la vez (independientemente del proceso).
Cada pedido puede ser procesado una sola vez.
Los procesos de preparación, despacho, entrega y verificación deben ejecutarse de forma concurrente para simular un entorno de pedidos realista.
Los tiempos de espera para realizar cada operación deben ser aleatorios y configurables por el grupo.
Al iniciar el programa, todos los hilos deben ser lanzados para que comiencen su ejecución.
El sistema debe contar con un LOG con fines estadísticos, el cual registre cada 200 milisegundos en un archivo:
- Cantidad de pedidos fallidos.
- Cantidad de pedidos verificados.
Además, al finalizar, el log debe imprimir una estadística de los casilleros y el tiempo total que demoró el programa.
