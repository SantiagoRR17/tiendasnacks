/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dominio.Snack;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ServicioSnacksArchivo implements IServicioSnacks {

    private final String FILE_NAME = "snacks.txt";
    //Crear lista de snacks
    private List<Snack> snacks = new ArrayList<>();

    //Constructor de la clase
    public ServicioSnacksArchivo() {
        var archivo = new File(FILE_NAME);
        var existe = false;
        try {

            existe = archivo.exists();
            if (existe) {
                this.snacks = obtenerSnacks();
            } else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Archivo creado");
            }

        } catch (Exception e) {
            System.out.println("Error al crear archivo " + e.getMessage());

        }
        //Cargar elementos por default
        if (!existe) {
            cargarSnacksIniciales();
        }
    }

    public void cargarSnacksIniciales() {
        this.agregarSnack(new Snack("Mcflurry", 10500));
        this.agregarSnack(new Snack("Mani", 5500));
        this.agregarSnack(new Snack("Jumbo Brownie", 4700));
    }

    private List<Snack> obtenerSnacks(){
        var snacks = new ArrayList<Snack>();
        try {
            
            List<String> lineas = Files.readAllLines(Paths.get(FILE_NAME));
            for (String linea : lineas) {
                String[] lineaSnack = linea.split(",");
                var idSnack = lineaSnack[0];
                var nombreSnack = lineaSnack[1];
                var precioSnack = Double.parseDouble(lineaSnack[2]);
                var snack = new Snack(nombreSnack, precioSnack);
                snacks.add(snack);
            }
        } catch (Exception e) {
            System.out.println("Error al leer archivo"+e.getMessage());
        }
        return snacks;
    }
    @Override
    public void agregarSnack(Snack snack) {
        //guardar en la lista
        this.snacks.add(snack);

        //guardar en el archivo
        this.agregarSnackArchivo(snack);
    }

    public void agregarSnackArchivo(Snack snack) {
        boolean anexar = false;
        var archivo = new File(FILE_NAME);
        try {
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(snack.escribirSnack());
            salida.close();

        } catch (Exception e) {
            System.out.println("Error editando archivo");
        }

    }

    @Override
    public void mostrarSnacks() {
        System.out.println("La maquina cuenta con los siguientes snacks:");
        var inventarioSnacks = "";
        for(var snack: this.snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        
        System.out.println(inventarioSnacks);
        
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }

}
