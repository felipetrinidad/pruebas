/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

/**
 *
 * @author felip
public class Persona {
 */
public class Persona {
    // Atributos
    private String nombre;
    private String domicilio;
    private String dni;
    private String telefono;
    
    //Constructor
    public Persona(String nombre, String domicilio, String dni, String telefono){
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.telefono = telefono;    
    }
    //CRUD
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if(nombre.isEmpty()){
            throw new IllegalStateException("Debe ingresar un Nombre.");
        }
        this.nombre = nombre; 
    }
    
    public String getDomicilio() { return domicilio; }
    public void setDomicilio(String domicilio) {
        if(domicilio.isEmpty()){
            throw new IllegalStateException("Debe ingresar su Domicilio.");
        }
        this.domicilio = domicilio;
    }
    
    public String getDNI() { return dni; }
    public void setDNI(String dni) {
        if(dni.isEmpty() || dni.length()!=10){
            throw new IllegalStateException("DNI invalido.");
        }
        this.dni = dni;
    }
    
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    
    @Override
    public String toString() {
        return nombre + ", DNI: " + dni + ", Telefono: " + telefono;
    }
}
