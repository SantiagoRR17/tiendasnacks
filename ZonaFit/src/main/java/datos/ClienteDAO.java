/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import conexion.Conexion;
import dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ClienteDAO implements IClienteDAO{

    public ClienteDAO() {
    }

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        var sql = "SELECT * FROM cliente ORDER BY id_cliente";
        try {
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);
            }
            
        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }
        finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        var sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
            }
            
            
        } catch (Exception e) {
            System.out.println("Error al buscar el cliente: "+ e.getMessage());
        }
        finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        var sql = "INSERT INTO cliente(nombre, apellido, membresia) " + " VALUES(?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3,cliente.getMembresia());
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error al agregar el cliente: "+ e.getMessage());
        }
        finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        return false;
    }
    
    public static void main(String[] args) {
        IClienteDAO clienteDao = new ClienteDAO();
        /* Listar clientes
        
        */
        
        //Buscar por id
        /*
        var cliente1 = new Cliente(2);
        System.out.println("Cliente antes de la busqueda: " + cliente1.toString());
        var encontrado = clienteDao.buscarClientePorId(cliente1);
        if(encontrado){
            System.out.println("Cliente encontrado: " + cliente1);
        }else{
            System.out.println("No se encontro cliente: " + cliente1.getId());
        }
        */
        var cliente2 = new Cliente("Dante","Musulman",18);
        var agregado = clienteDao.agregarCliente(cliente2);
        if(agregado){
            System.out.println("Se ha creado el cliente " + cliente2.toString());
        }else{
            System.out.println("No se ha podido crear al cliente: " + cliente2.toString());
        }
        
        System.out.println("-----------Listar clientes-----------");
        
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);
        
        
    }
    
    
}
