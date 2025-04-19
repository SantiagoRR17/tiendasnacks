/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import datos.ClienteDAO;
import datos.IClienteDAO;
import dominio.Cliente;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class AppZonaFit {

    static Scanner sc;

    public static void main(String[] args) {

        appZonaFit();
    }

    public static void appZonaFit() {
        IClienteDAO clienteDao = new ClienteDAO();
        int opcion = 0;
        sc = new Scanner(System.in);
        do {
            imprimirMenu();
            opcion = Integer.parseInt(sc.nextLine());
            ejecutarOpciones(opcion, clienteDao);
        } while (opcion != 5);

    }

    public static void imprimirMenu() {

        System.out.println("------------------------------------------------");
        System.out.println("Bienvenido al sistema del gimansio Zona Fit :D");
        System.out.println("A continuacion seleccione la opcion a la que desea acceder:");
        System.out.println("1. Listar clientes registrados");
        System.out.println("2. Agregar cliente nuevo");
        System.out.println("3. Modificar cliente");
        System.out.println("4. Eliminar cliente");
        System.out.println("5. Salir");
        System.out.println("------------------------------------------------");
    }

    public static void ejecutarOpciones(int opcion, IClienteDAO clienteDao) {
        String nombre;
        String apellido;
        int membresia;
        int id;
        List<Cliente> clientes;
        var encontrado = false;
        switch (opcion) {
            case 1:
                System.out.println("-------- Lista de clientes --------");
                clientes = clienteDao.listarClientes();
                clientes.forEach(System.out::println);
                break;
            case 2:

                System.out.println("Ingrese los datos del cliente a registrar. ");
                System.out.println("Nombre: ");
                nombre = sc.nextLine();
                System.out.println("Apellido: ");
                apellido = sc.nextLine();
                System.out.println("Membresia: ");
                membresia = Integer.parseInt(sc.nextLine());

                Cliente clienteNuevo = new Cliente(nombre, apellido, membresia);

                var creado = clienteDao.agregarCliente(clienteNuevo);
                if (creado) {
                    System.out.println("Se ha creado con exito el cliente " + clienteNuevo.toString());
                } else {
                    System.out.println("No se ha podido crear al cliente " + clienteNuevo.toString());
                }

                break;
            case 3:
                System.out.println("-------- Lista de clientes --------");
                clientes = clienteDao.listarClientes();
                clientes.forEach(System.out::println);

                System.out.println("Ingrese el id del cliente que desea modificar: ");
                id = Integer.parseInt(sc.nextLine());

                Cliente clienteMod = new Cliente(id);

                encontrado = buscarClientePorId(clienteMod, clienteDao);

                if (encontrado) {
                    System.out.println("Ingrese los nuevos datos del cliente a registrar. ");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    apellido = sc.nextLine();
                    System.out.println("Membresia: ");
                    membresia = Integer.parseInt(sc.nextLine());
                    clienteMod.setNombre(nombre);
                    clienteMod.setApellido(apellido);
                    clienteMod.setMembresia(membresia);
                    var modificado = clienteDao.modificarCliente(clienteMod);
                    if (modificado) {
                        System.out.println("Se ha modificado con exito el cliente " + clienteMod.toString());
                    } else {
                        System.out.println("No se ha podido modificar al cliente " + clienteMod.toString());
                    }
                } else {
                    System.out.println("No se ha encontrado al cliente con id " + clienteMod.getId());
                }

                break;
            case 4:
                System.out.println("-------- Lista de clientes --------");
                clientes = clienteDao.listarClientes();
                clientes.forEach(System.out::println);

                System.out.println("Ingrese el id del cliente que desea eliminar: ");
                id = Integer.parseInt(sc.nextLine());

                Cliente clienteDel = new Cliente(id);
                encontrado = buscarClientePorId(clienteDel, clienteDao);

                if (encontrado) {
                    var eliminado = clienteDao.eliminarCliente(clienteDel);
                    if (eliminado) {
                        System.out.println("Se ha eliminado con exito el cliente " + clienteDel.toString());
                    } else {
                        System.out.println("No se ha podido eliminar al cliente " + clienteDel.toString());
                    }
                } else {
                    System.out.println("No se ha encontrado al cliente con id " + clienteDel.getId());
                }

                break;
            case 5:
                System.out.println("Gracias por utilizar el sistema de Zona Fit. Saliendo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida...");
        }

    }

    public static boolean buscarClientePorId(Cliente cliente, IClienteDAO clienteDao) {
        var encontrado = clienteDao.buscarClientePorId(cliente);
        if (encontrado) {
            return true;
        }
        return false;
    }

}
