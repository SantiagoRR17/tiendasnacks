/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author PC
 */
public class ReadFile {
    public static void main(String[] args) {
        var fileName = "my_file.txt";
        var file = new File(fileName);
        try {
            System.out.println("File content:");
            //Open the file for reading
            var input = new BufferedReader(new FileReader(file));
            //Read line by line
            var line = input.readLine();
            //Read every line 
            while(line != null){
                System.out.println(line);
                //move to the next line
                line = input.readLine();
            }
            //Close the file
            input.close();
        } catch (Exception e) {
            System.out.println("Could not read the file");
            
            
        }
    }
}
