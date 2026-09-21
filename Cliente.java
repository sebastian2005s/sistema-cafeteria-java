import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String codigo;
    private String nombreCompleto;
    private String correoElectronico;
    private List<Pedido> pedidos;

    public Cliente() {
        this.pedidos = new ArrayList<>();
    }

    public Cliente(String codigo, String nombreCompleto, String correoElectronico) {
        setCodigo(codigo);
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido nuevoPedido) {
        for (Pedido p : pedidos) {
            if (p.getCodigo().equals(nuevoPedido.getCodigo())) {
                throw new IllegalArgumentException("El código del pedido ya existe para este cliente.");
            }
        }
        pedidos.add(nuevoPedido);
    }

    public void mostrarDatos() {
        System.out.println("=== Datos del Cliente ===");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Correo: " + correoElectronico);
        System.out.println("--- Pedidos ---");
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (Pedido p : pedidos) {
                System.out.println(p.toString());
            }
        }
        System.out.println("Importe Total Acumulado: $" + calcularImporteTotal());
        System.out.println("=========================\n");
    }

    public double calcularImporteTotal() {
        double total = 0;
        for (Pedido p : pedidos) {
            if (p.getEstado() != EstadoPedido.CANCELADO) {
                total += p.calcularImporte();
            }
        }
        return total;
    }

    public Pedido buscarPedido(String codigoBusqueda) {
        for (Pedido p : pedidos) {
            if (p.getCodigo().equals(codigoBusqueda)) {
                return p;
            }
        }
        return null;
    }

    public void cambiarEstadoPedido(String codigoPedido, EstadoPedido nuevoEstado) {
        Pedido p = buscarPedido(codigoPedido);
        if (p != null) {
            p.setEstado(nuevoEstado);
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.trim().isEmpty()) {
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("El código del cliente no puede estar vacío.");
        }
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
}
