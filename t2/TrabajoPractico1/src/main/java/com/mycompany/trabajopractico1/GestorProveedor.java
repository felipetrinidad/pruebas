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
import java.util.stream.Collectors;

public class GestorProveedor {
    private List<Proveedor> proveedores;

    public GestorProveedor() {
        this.proveedores = new ArrayList<>();
    }

    // CREATE - Agregar un nuevo proveedor
    public boolean agregarProveedor(Proveedor proveedor) {
        if (existeProveedor(proveedor.getDNI())) {
            System.out.println("Ya existe un proveedor con el DNI: " + proveedor.getDNI());
            return false;
        }
        proveedores.add(proveedor);
        System.out.println("Proveedor agregado exitosamente");
        return true;
    }

    // READ - Buscar proveedor por DNI
    public Proveedor buscar(String dni) {
        return proveedores.stream()
                .filter(p -> p.getDNI().equals(dni))
                .findFirst()
                .orElse(null);
    }

    // READ - Listar todos los proveedores
    public void listar() {
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados");
            return;
        }
        System.out.println("LISTA DE PROVEEDORES:");
        proveedores.forEach(System.out::println);
    }

    // UPDATE - Modificar proveedor
    public boolean modificar(String dni, String nuevoNombre, String nuevoDomicilio, String nuevoTelefono, 
                            String nuevaRazonSocial, String nuevoNIF) {
        Proveedor proveedor = buscar(dni);
        if (proveedor == null) {
            System.out.println("Proveedor no encontrado");
            return false;
        }
        
        proveedor.setNombre(nuevoNombre);
        proveedor.setDomicilio(nuevoDomicilio);
        proveedor.setTelefono(nuevoTelefono);
        proveedor.setRazSocial(nuevaRazonSocial);
        proveedor.setNIF(nuevoNIF);
        
        System.out.println("Proveedor modificado exitosamente");
        return true;
    }

    // DELETE - Eliminar proveedor
    public boolean eliminar(String dni) {
        Proveedor proveedor = buscar(dni);
        if (proveedor == null) {
            System.out.println("Proveedor no encontrado");
            return false;
        }
        proveedores.remove(proveedor);
        System.out.println("Proveedor eliminado exitosamente");
        return true;
    }

    // Método auxiliar para verificar existencia
    private boolean existeProveedor(String dni) {
        return buscar(dni) != null;
    }

    // Otros métodos útiles

    // Buscar por razón social (parcial)
    public List<Proveedor> buscarPorRazonSocial(String razonSocialParcial) {
        return proveedores.stream()
                .filter(p -> p.getRazSocial().toLowerCase().contains(razonSocialParcial.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Buscar por NIF
    public Proveedor buscarPorNIF(String nif) {
        return proveedores.stream()
                .filter(p -> p.getNIF().equals(nif))
                .findFirst()
                .orElse(null);
    }

    // Getter para obtener la lista de proveedores (copia)
    public List<Proveedor> getProveedores() {
        return new ArrayList<>(proveedores);
    }

    public int getCantidad() {
        return proveedores.size();
    }
}