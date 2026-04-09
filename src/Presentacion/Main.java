/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Manejo de errores y validaciones de entrada con try-catch
package presentacion;

import entidad.Producto;
import negocio.ProductoService;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductoService service = new ProductoService();
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            try {
                System.out.println("\n1. Registrar Producto");
                System.out.println("2. Listar Productos");
                System.out.println("3. Buscar Producto");
                System.out.println("4. Actualizar Producto");
                System.out.println("5. Eliminar Producto");
                System.out.println("6. Salir");
                System.out.print("Opción: ");
                op = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (op) {
                    case 1:
                        System.out.print("ID (numero): ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Cantidad: ");
                        int cantidad = sc.nextInt();

                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();

                        service.registrar(new Producto(id, nombre, cantidad, precio));
                        System.out.println("Producto registrado correctamente.");
                        break;

                    case 2:
                        service.listar().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("ID a buscar: ");
                        int buscarId = sc.nextInt();
                        System.out.println(service.buscar(buscarId));
                        break;

                    case 4:
                        System.out.print("ID: ");
                        int actId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nombre: ");
                        nombre = sc.nextLine();

                        System.out.print("Cantidad: ");
                        cantidad = sc.nextInt();

                        System.out.print("Precio: ");
                        precio = sc.nextDouble();

                        service.actualizar(new Producto(actId, nombre, cantidad, precio));
                        System.out.println("Producto actualizado.");
                        break;

                    case 5:
                        System.out.print("ID a eliminar: ");
                        int delId = sc.nextInt();
                        service.eliminar(delId);
                        System.out.println("Producto eliminado.");
                        break;

                    case 6:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida");
                }

            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Debe ingresar el tipo de dato correcto.");
                sc.nextLine(); // limpiar entrada incorrecta
            }

        } while (op != 6);

        sc.close();
    }
}
