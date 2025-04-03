package maquina_snacks;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    
    static List<Snack> snacks;

    public Snacks() {
        snacks = new ArrayList<>();
    }
    
    
    
    public void agregarSnack(Snack snack){
        
        snacks.add(snack);
        System.out.println("Se ha agregado el snack "+ snack.getNombre() + " a la lista...");
    }
    
    public void mostrarSnacks(){
        System.out.println("La lista cuenta con los siguientes snacks:");
        //snacks.forEach(System.out::println);
        for (Snack snacky : snacks) {
            System.out.println( snacky.toString());
        }
    }

    public static List<Snack> getSnacks() {
        return snacks;
    }
    
    
    
    
}
