/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author PC
 */
public class ReadWholeFile {
    public static void main(String[] args) {
        var fileName = "my_file.txt";
        try {
            //read every line of the file
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            System.out.println("File content:");
            /*Clasic for each method
                for (String line : lines) {
                    System.out.println(line);
                }
            */
            //foreach method from the list class
            lines.forEach(System.out::println);
            
        } catch (Exception e) {
            System.out.println("Fatal Error trying to read the file x.x " + e.getMessage());
        
        }
        
        
        
        
    }
}
