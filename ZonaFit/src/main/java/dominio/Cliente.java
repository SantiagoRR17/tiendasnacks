/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author PC
 */
public class Cliente {
    
    private int id;
    private String nombre;
    private String apellido;
    private int membresia;
    
    public Cliente(){}
    
    public Cliente(int id){
        this.id = id;
    }

    public Cliente(String nombre, String apellido, int membresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.membresia = membresia;
    }

    public Cliente(int id, String nombre, String apellido, int membresia) {
        this(nombre, apellido, membresia); //llamar el constructor con esos atributos 
        this.id = id;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMembresia() {
        return membresia;
    }

    public void setMembresia(int membresia) {
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return id + ". " + nombre + " " + apellido + ", membresia " + membresia + ".";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.apellido);
        hash = 79 * hash + this.membresia;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.membresia != other.membresia) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.apellido, other.apellido);
    }
    
    
    
}
