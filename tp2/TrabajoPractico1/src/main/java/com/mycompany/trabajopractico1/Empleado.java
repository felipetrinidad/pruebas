/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

/**
 *
 * @author felip
 */
public class Empleado extends Persona {
    //Atributos
    private double salario;
    private Puesto puesto; // administrativo, técnico, gerente
    private String fechaIngreso;
    private Departamento departamento;
    
    // enum: "lista" de elementos predeterminados
    public enum Puesto {
        ADMINISTRATIVO,
        TECNICO,
        GERENTE
    }
    
    //Constructor
    public Empleado(String nombre, String domicilio, String dni, String telefono, double salario,
                    Puesto puesto, String fechaIngreso, Departamento departamento) {
        
        super(nombre, domicilio, dni, telefono);
        this.salario = salario;
        this.puesto = puesto;
        this.fechaIngreso = fechaIngreso;
        this.departamento = departamento;
    }
    
    //CRUD
    public double getSalario(){return salario;}
    public void setSalario(double salario){this.salario = salario;}
    
    public Puesto getPuesto(){return puesto;}
    public void setPuesto(Puesto puesto){this.puesto = puesto;}
    
    public String getFechaIngr(){return fechaIngreso;}
    public void setFechaIngr(String fechaIngreso){this.fechaIngreso = fechaIngreso;}
    
    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
    
    
    @Override
    public String toString() {
        return super.toString() + " Puesto: " + getPuesto()  + ", Fecha Ingreso: " + getFechaIngr();
    }
}
