public class Pedido {
    private String codigo;
    private String descripcion;
    private double precioUnitario;
    private int cantidad;
    private EstadoPedido estado;

    public Pedido() {
        this.estado = EstadoPedido.PENDIENTE;
    }

    public Pedido(String codigo, String descripcion, double precioUnitario, int cantidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        setPrecioUnitario(precioUnitario);
        setCantidad(cantidad);
        this.estado = EstadoPedido.PENDIENTE;
    }

    public double calcularImporte() {
        return this.precioUnitario * this.cantidad;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario > 0) {
            this.precioUnitario = precioUnitario;
        } else {
            throw new IllegalArgumentException("El precio debe ser mayor a cero.");
        }
    }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad = cantidad;
        } else {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero.");
        }
    }

    public EstadoPedido getEstado() { return estado; }
    public void setEstado(EstadoPedido estado) { this.estado = estado; }
    
    @Override
    public String toString() {
        return String.format("Pedido[%s]: %s | Cant: %d | Precio: $%.2f | Subtotal: $%.2f | Estado: %s", 
                codigo, descripcion, cantidad, precioUnitario, calcularImporte(), estado);
    }
}
