/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

/**
 *
 * @author felip
 */
class Departamento {
    //Atributos
    private String nombre;
    private double presupuesto;
    private Empleado responsable;
    
    
    
    //Constructor
    public Departamento(String nombre, double presupuesto, Empleado responsable) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.responsable = responsable;
    }
    
    public String getNombreDep(){return nombre;}
    public void setNombreDep(String nombre){this.nombre = nombre;}
    
    public double getPresupuesto(){return presupuesto;}
    public void setPresupuesto(double presupuesto){this.presupuesto = presupuesto;}
    
    public Empleado getResponsable(){return responsable;}
    public void setResponsable(Empleado responsable){this.responsable = responsable;}
    
    @Override
    public String toString() {
        return nombre + "\nResponsable a Cargo:  " + responsable ;
    }
}
