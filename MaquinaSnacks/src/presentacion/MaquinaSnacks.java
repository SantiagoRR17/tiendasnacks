package presentacion;

import dominio.Snack;
import java.util.ArrayList;
import java.util.Scanner;
import servicio.IServicioSnacks;
import servicio.ServicioSnacksArchivo;
import servicio.ServicioSnacksLista;

public class MaquinaSnacks {

    static Scanner sc = new Scanner(System.in);
    //static ServicioSnacksLista listaSnacks = new ServicioSnacksLista();

    static ArrayList<Snack> listaCompra = new ArrayList<>();

    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks() {
        IServicioSnacks listaSnacks = new ServicioSnacksArchivo();
        int opcion = 0;

        System.out.println("*** Maquina de snacks ***");
        do {
            System.out.println("***********************************************");
            
            listaSnacks.mostrarSnacks();
            System.out.println("***********************************************\n");
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());
            ejecutarOpciones(opcion, listaSnacks);
            System.out.println("Si desea salir presione 4, de lo contrario presione cualquier numero...");
            opcion = Integer.parseInt(sc.nextLine());
        } while (opcion != 4);

    }

    private static void mostrarMenu() {

        System.out.println("Menu:");
        System.out.println("\n1. Comprar Snack");
        System.out.println("2. Mostrar ticket");
        System.out.println("3. Agregar nuevo Snack");
        System.out.println("4. Salir");

        System.out.println("Elige una opcion:");
    }

    private static void ejecutarOpciones(int opcion, IServicioSnacks listaSnacks) {

        switch (opcion) {
            case 1:
                comprarSnacks(listaSnacks);
                break;
            case 2:
                mostrarTicket();
                break;
            case 3:
                agregarSnack(listaSnacks);
                System.out.println("");
                listaSnacks.mostrarSnacks();
                System.out.println("-------------------------");
                break;
            case 4:
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida, intente de nuevo...");
        }

    }

    private static void comprarSnacks(IServicioSnacks listaSnacks) {
        int idSnackCompra = 0;
        System.out.println("**Snacks Disponibles**");
        listaSnacks.mostrarSnacks();
        System.out.println("--------------------------------------------");
        System.out.println("Ingrese el id del snack que desea comprar:");
        idSnackCompra = Integer.parseInt(sc.nextLine());
        if (listaSnacks.getSnacks().get(idSnackCompra - 1) != null) {
            System.out.println("Se ha añadido el snack " + (listaSnacks.getSnacks().get(idSnackCompra - 1).toString()) + " a la lista de compras.");
        } else {
            System.out.println("No se ha encontrado un snack con el id " + idSnackCompra + ", intentelo de nuevo...");
        }

        System.out.println("........................................... ");
        listaCompra.add(listaSnacks.getSnacks().get(idSnackCompra - 1));

    }

    private static void mostrarTicket() {
        double totalCompra = 0;
        System.out.println("**Ticket de compra**");
        System.out.println("Este es el resumen de su pedido:");
        for (Snack snack : listaCompra) {
            System.out.println(snack.toString());
            totalCompra += snack.getPrecio();
        }
        System.out.println("--------------------------------------------");
        System.out.println("** Total a pagar: $" + totalCompra + " **");
    }

    private static void agregarSnack(IServicioSnacks listaSnacks) {

        System.out.println("Ingrese el nombre del snack:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el precio del snack:");
        double precio = Double.parseDouble(sc.nextLine());

        Snack snack = new Snack(nombre, precio);
        System.out.println("------------------------");
        listaSnacks.agregarSnack(snack);
    }

}
