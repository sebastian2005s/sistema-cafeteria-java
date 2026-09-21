public class Main {
    public static void main(String[] args) {
        try {
            Cliente cliente1 = new Cliente("C001", "Ana Garcia", "ana@universidad.edu");
            
            Pedido p1 = new Pedido("P001", "Café Americano", 2.50, 2);
            Pedido p2 = new Pedido("P002", "Sandwich de Pollo", 4.00, 1);
            
            cliente1.agregarPedido(p1);
            cliente1.agregarPedido(p2);
            
            cliente1.mostrarDatos();
            
            cliente1.cambiarEstadoPedido("P001", EstadoPedido.ATENDIDO);
            
            System.out.println("Intentando agregar un pedido con código duplicado...");
            Pedido p3 = new Pedido("P001", "Jugo de Naranja", 3.00, 1);
            // cliente1.agregarPedido(p3);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }
}
