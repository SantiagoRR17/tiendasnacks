/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class WriteContentFile {
    public static void main(String[] args) {
        boolean include = false;
        Scanner sc = new Scanner(System.in);
        var fileName= "my_file.txt";
        var file = new File(fileName);
        
        try {
            
            include = file.exists();
            var output = new PrintWriter(new FileWriter(file, include));
            System.out.println("Write the content you want to add to the file:");
            var newConent = sc.nextLine();
            
            output.println(newConent);
                       
            output.close();
            
        } catch (Exception e) {
            System.out.println("Could not edit the file " + e.getMessage());
        }
        
        
    }
}
