package maquina_snacks;

import java.util.ArrayList;
import java.util.Scanner;

public class MaquinaSnacks {
    
    static Scanner sc= new Scanner(System.in);
    static Snacks listaSnacks = new Snacks();
    static ArrayList<Snack> listaCompra = new ArrayList<>();
    public static void main(String[] args) {
        maquinaSnacks();
    }
    
    public static void maquinaSnacks(){
        
        int opcion = 0;
        
        System.out.println("*** Maquina de snacks ***");
        do {            
            System.out.println("***********************************************");
            if(listaSnacks.snacks.size() != 0){
                listaSnacks.mostrarSnacks();
            }else{
                System.out.println("Aun no hay snacks en la maquina....");
            }
            System.out.println("***********************************************\n");
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());
            ejecutarOpciones(opcion);
            System.out.println("Si desea salir presione 4, de lo contrario presione cualquier numero...");
            opcion = Integer.parseInt(sc.nextLine());
        } while (opcion != 4);
        
    }
    
    private static void mostrarMenu(){
        
        System.out.println("Menu:");
        System.out.println("\n1. Comprar Snack");
        System.out.println("2. Mostrar ticket");
        System.out.println("3. Agregar nuevo Snack");
        System.out.println("4. Salir");
        
        System.out.println("Elige una opcion:");
    }
    
    private static void ejecutarOpciones(int opcion){
        int idSnackCompra=0;
        switch (opcion) {
            case 1:
                System.out.println("**Snacks Disponibles**");
                listaSnacks.mostrarSnacks();
                System.out.println("--------------------------------------------");
                System.out.println("Ingrese el id del snack que desea comprar:");
                idSnackCompra = Integer.parseInt(sc.nextLine());
                System.out.println("Se ha añadido el snack "+ (listaSnacks.snacks.get(idSnackCompra-1).toString()) + " a la lista de compras." );
                System.out.println("........................................... ");
                listaCompra.add(listaSnacks.snacks.get(idSnackCompra-1));
                
                break;
            case 2:
                double totalCompra = 0;
                System.out.println("**Ticket de compra**");
                System.out.println("Este es el resumen de su pedido:");
                for (Snack snack : listaCompra) {
                    System.out.println(snack.toString());
                    totalCompra += snack.getPrecio();
                }
                System.out.println("--------------------------------------------");
                System.out.println("** Total a pagar: $"+totalCompra+" **");
                break;
            case 3:
                agregarSnack();
                System.out.println("");
                listaSnacks.mostrarSnacks();
                System.out.println("-------------------------");
                break;
            case 4:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opcion no valida, intente de nuevo...");
        }
        
    }
    
    private static void comprarSnacks(){
        
        
    }
    
    private static void mostrarTicket(){
        
        
    }
    
    private static void agregarSnack(){
        
        System.out.println("Ingtese el nombre del snack:");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese el precio del snack:");
        double precio = Double.parseDouble(sc.nextLine());
        
        Snack snack = new Snack(nombre, precio);
        System.out.println("------------------------");
        listaSnacks.agregarSnack(snack);
    }
    
}
