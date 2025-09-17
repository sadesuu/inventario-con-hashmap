import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class inventario {
    private HashMap<String, producto> productos = new HashMap<>();


    public inventario(HashMap<String, producto> product) {
        this.productos = product;
    }
    

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (producto p : productos.values()) {
            builder.append(p.toString()).append("\n");
        }
        return builder.toString();
    }

    public void añadirProducto(producto p) {
        productos.put(p.getNombre(), p);
    }

    public void actualizarStock(String nombreProducto, int nuevoStock) {
        if (productos.containsKey(nombreProducto)) {
            producto p = productos.get(nombreProducto);
            p.setStock(nuevoStock);
        } else {
            System.out.println("Producto con nombre " + nombreProducto + " no encontrado.");
        }
    }

    public void venderproducto(String nombreProducto, int cantidad) {
        if (productos.containsKey(nombreProducto)) {
            producto p = productos.get(nombreProducto);
            if (p.getStock() >= cantidad) {
                p.setStock(p.getStock() - cantidad);
                System.out.println("Venta realizada: " + cantidad + " unidades de " + nombreProducto);
            } else {
                System.out.println("Stock insuficiente para " + nombreProducto);
            }
        } else {
            System.out.println("Producto con nombre " + nombreProducto + " no encontrado.");
        }

    }

    public void buscarProducto( String nombreProducto) {
        if (productos.containsKey(nombreProducto)) {
            producto p = productos.get(nombreProducto);
            System.out.println("Producto encontrado: " + p.toString());
        } else {
            System.out.println("Producto con nombre '" + nombreProducto + "' no encontrado.");
        }
    }

    public List<producto> filtrarPorCategoria(categoria.categorias cat) {
        List<producto> productosFiltrados = new ArrayList<>();
        for (producto p : productos.values()) {
            if (p.getCategoria() == cat) {
                productosFiltrados.add(p);
            }
        }
        return productosFiltrados;
    }

    public void mostrarInventario() {
        System.out.println("Inventario completo:");
        for (producto p : productos.values()) {
            System.out.println(p.toString());
        }
    }
}
