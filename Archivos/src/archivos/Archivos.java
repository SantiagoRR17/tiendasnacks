/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author PC
 */
public class Archivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        var fileName = "my_file.txt";
        var file = new File(fileName);
        try {
            if (file.exists()) {
                System.out.println("The file already exists!");
            } else {
                //Create the file
                var salida = new PrintWriter(new FileWriter(file));
                salida.close();
                System.out.println("The file has been created");
            }
        } catch (IOException e) {
             System.out.println("The file could not be created");
             e.printStackTrace();
        }

    }

}
