import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        HashMap<String, producto> mapa = new HashMap<>();
        inventario inv = new inventario(mapa);
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de inventario");
        System.out.println("Seleccione una opcion:");
        System.out.println("1. Añadir producto");
        System.out.println("2. Actualizar stock");
        System.out.println("3. Vender producto");
        System.out.println("4. Buscar producto");
        System.out.println("5. Filtrar por categoria");
        System.out.println("6. Mostrar inventario");
        System.out.println("7. Salir");

        String opcion = sc.nextLine();
        switch (opcion) {
            case "1":
                System.out.println("Ingrese el codigo del producto:");
                String codigo = sc.nextLine();
                System.out.println("Ingrese el nombre del producto:");
                String nombre = sc.nextLine();
                System.out.println("Ingrese el precio del producto:");
                double precio = Double.parseDouble(sc.nextLine());
                System.out.println("Ingrese la categoria del producto (Laptops, Smartphones, Tablets, Smartwatch, SmartTV):");
                String categoriaStr = sc.nextLine();
                categoria.categorias categoriaEnum = categoria.categorias.valueOf(categoriaStr);
                System.out.println("Ingrese el stock del producto:");
                int stock = Integer.parseInt(sc.nextLine());

                producto p = new producto(codigo, nombre, precio, categoriaEnum, stock);
                inv.añadirProducto(p);
                break;
            case "2":
                System.out.println("Ingrese el nombre del producto a actualizar:");
                String nombreActualizar = sc.nextLine();
                System.out.println("Ingrese el nuevo stock:");
                int nuevoStock = Integer.parseInt(sc.nextLine());
                inv.actualizarStock(nombreActualizar, nuevoStock);
                break;
            case "3":
                System.out.println("Ingrese el nombre del producto a vender:");
                String nombreVender = sc.nextLine();
                System.out.println("Ingrese la cantidad a vender:");
                int cantidad = Integer.parseInt(sc.nextLine());
                inv.venderproducto(nombreVender, cantidad);
                break;
            case "4":
                System.out.println("Ingrese el nombre del producto a buscar:");
                String nombreBuscar = sc.nextLine();
                inv.buscarProducto(nombreBuscar);
                break;
            case "5":
                System.out.println("Ingrese la categoria a filtrar (Laptops, Smartphones, Tablets, Smartwatch, SmartTV):");
                String categoriaFiltrarStr = sc.nextLine();
                categoria.categorias categoriaFiltrarEnum = categoria.categorias.valueOf(categoriaFiltrarStr);
                inv.filtrarPorCategoria(categoriaFiltrarEnum);
                break;
            case "6":
                inv.mostrarInventario();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }


        sc.close();
    }
}