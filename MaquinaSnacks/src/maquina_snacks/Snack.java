package maquina_snacks;

public class Snack {
    
    private static int contadorSnacks;
    private int idSnack;
    private String nombre;
    private double precio;

    public Snack(String nombre, double precio) {
        ++contadorSnacks;
        this.nombre = nombre;
        this.precio = precio;
        this.idSnack = contadorSnacks;
    }

    public int getIdSnack() {
        return idSnack;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return idSnack + ". " + nombre + ", $" + precio;
    }
    
    
    
    
    
}
