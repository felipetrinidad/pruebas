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

public class GestorEmpleados {
    private List<Empleado> empleados;

    public GestorEmpleados() {
        this.empleados = new ArrayList<>();
    }

    // Create: agregar un nuevo empleado
    public boolean agregarEmpleado(Empleado empleado) {
        if (existeEmpleado(empleado.getDNI())) {
            System.out.println("Ya existe un empleado con el DNI: " + empleado.getDNI());
            return false;
        }
        empleados.add(empleado);
        System.out.println("Empleado agregado exitosamente");
        return true;
    }

    // Read: obtener todos los empleados
    public List<Empleado> obtenerTodosLosEmpleados() {
        return new ArrayList<>(empleados);
    }

    // Read: buscar empleado por DNI
    public Empleado buscarEmpleadoPorDNI(String dni) {
        for (Empleado empleado : empleados) {
            if (empleado.getDNI().equals(dni)) {
                return empleado;
            }
        }
        return null;
    }

    // Update: actualizar un empleado existente
    public boolean actualizarEmpleado(String dni, String nuevoNombre, String nuevoDomicilio, String nuevoTelefono, 
                                      double nuevoSalario, Empleado.Puesto nuevoPuesto, String nuevaFechaIngreso, 
                                      Departamento nuevoDepartamento) {
        Empleado empleado = buscarEmpleadoPorDNI(dni);
        if (empleado != null) {
            empleado.setNombre(nuevoNombre);
            empleado.setDomicilio(nuevoDomicilio);
            empleado.setTelefono(nuevoTelefono);
            empleado.setSalario(nuevoSalario);
            empleado.setPuesto(nuevoPuesto);
            empleado.setFechaIngr(nuevaFechaIngreso);
            empleado.setDepartamento(nuevoDepartamento);
            return true;
        }
        return false;
    }

    // Delete: eliminar un empleado por DNI
    public boolean eliminarEmpleado(String dni) {
        Empleado empleado = buscarEmpleadoPorDNI(dni);
        if (empleado != null) {
            empleados.remove(empleado);
            return true;
        }
        return false;
    }
    
    
    // Método auxiliar para verificar existencia
    private boolean existeEmpleado(String dni) {
        return buscarEmpleadoPorDNI(dni) != null;
    }
}
