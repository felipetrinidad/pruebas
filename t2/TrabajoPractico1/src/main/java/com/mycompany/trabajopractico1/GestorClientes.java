/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

/**
 *
 * @author felip
 */
import java.util.ArrayList;
import java.util.List;

public class GestorClientes {
    private List<Cliente> clientes;

    public GestorClientes() {
        this.clientes = new ArrayList<>();
    }

    // Create: agregar un nuevo cliente
    public boolean agregarCliente(Cliente cliente) {
        if (existeCliente(cliente.getDNI())) {
            System.out.println("Ya existe un cliente con el DNI: " + cliente.getDNI());
            return false;
        }
        clientes.add(cliente);
        System.out.println("Cliente agregado exitosamente");
        return true;
    }

    // Read: obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return new ArrayList<>(clientes); 
    }

    // Read: buscar cliente por DNI
    public Cliente buscarClientePorDNI(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDNI().equals(dni)) {
                return cliente;
            }
        }
        return null; // o lanzar una excepción
    }

    // Update: actualizar un cliente existente
    public boolean actualizarCliente(String dni, String nuevoNombre, String nuevoDomicilio, String nuevoTelefono, 
                                     double nuevoLimite, Cliente.Categoria nuevaCategoria) {
        Cliente cliente = buscarClientePorDNI(dni);
        if (cliente != null) {
            cliente.setNombre(nuevoNombre);
            cliente.setDomicilio(nuevoDomicilio);
            cliente.setTelefono(nuevoTelefono);
            cliente.setLimCredito(nuevoLimite);
            cliente.setCategoria(nuevaCategoria);
            return true;
        }
        return false;
    }

    // Delete: eliminar un cliente por DNI
    public boolean eliminarCliente(String dni) {
        Cliente cliente = buscarClientePorDNI(dni);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }
    
    // Método auxiliar para verificar existencia
    private boolean existeCliente(String dni) {
        return buscarClientePorDNI(dni) != null;
    }
}