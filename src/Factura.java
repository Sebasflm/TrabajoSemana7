import java.util.ArrayList;
import java.util.List;

public class Factura {
        private List<Producto> productos;

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    private double subtotal;
        private double descuento;
        private double total;
        private String nombreComprador;
        private String cedulaComprador;

        public Factura() {
            productos = new ArrayList<>();
            subtotal = 0;
            descuento = 0;
            total = 0;
            nombreComprador = "";
            cedulaComprador = "";
        }

        public void agregarProducto(Producto producto, int cantidad) {
            productos.add(producto);
            subtotal += calcularSubtotalProducto(producto, cantidad);
        }

        private double calcularSubtotalProducto(Producto producto, int cantidad) {
            if (cantidad >= producto.getCantidadMayorista()) {
                return producto.getPrecioMayorista() * cantidad;
            } else {
                return producto.getPrecioNormal() * cantidad;
            }
        }

        public void calcularDescuento() {
            if (subtotal > 1000) {
                descuento = subtotal * 0.1;
            } else if (subtotal > 500) {
                descuento = subtotal * 0.07;
            } else if (subtotal > 100) {
                descuento = subtotal * 0.05;
            }
            total = subtotal - descuento;
        }

        public void imprimirFactura() {
            System.out.println("Factura:");
            System.out.println("Comprador: " + nombreComprador);
            System.out.println("Cédula: " + cedulaComprador);
            System.out.println("------------------------");
            System.out.println("Productos:");

            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);
                int numeroProducto = i + 1;
                System.out.println(numeroProducto + ". " + producto.getNombre() + " (Cantidad: " + producto.getCantidadMayorista() + ")");
                System.out.println("   Precio unitario: $" + producto.getPrecioNormal());
                System.out.println("   Precio mayorista: $" + producto.getPrecioMayorista());
            }

            System.out.println("------------------------");
            System.out.println("Subtotal: $" + subtotal);
            System.out.println("Descuento: $" + descuento);
            System.out.println("Total: $" + total);
        }

        public void setNombreComprador(String nombreComprador) {
            this.nombreComprador = nombreComprador;
        }

        public void setCedulaComprador(String cedulaComprador) {
            this.cedulaComprador = cedulaComprador;
        }
}

