package gestiontienda;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionTienda {

    public static void main(String[] args) {
        Map<String, Integer> inventario = new HashMap<>();
        Scanner leer = new Scanner(System.in);
        int opcion;

        System.out.println("--- SISTEMA DE INVENTARIO DE LA TIENDA ---");

        do {
            System.out.println("\n1. Agregar/Actualizar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:

                    System.out.print("Nombre del producto: ");
                    String nombre = leer.nextLine().toLowerCase();
                    System.out.print("Cantidad en stock: ");
                    int cantidad = leer.nextInt();
                    inventario.put(nombre, cantidad);
                    System.out.println("Producto registrado con éxito.");
                    break;

                case 2:

                    System.out.println("\n--- Lista de Productos ---");
                    if (inventario.isEmpty()) {
                        System.out.println("El inventario está vacío.");
                    } else {
                        for (Map.Entry<String, Integer> item : inventario.entrySet()) {
                            System.out.println("Producto: " + item.getKey() + " | Stock: " + item.getValue());
                        }
                    }
                    break;

                case 3:

                    System.out.print("Nombre del producto a eliminar: ");
                    String eliminar = leer.nextLine().toLowerCase();
                    if (inventario.containsKey(eliminar)) {
                        inventario.remove(eliminar);
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("No se encontró el producto.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
}