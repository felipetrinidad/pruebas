/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

/**
 *
 * @author felip
 */
public class Proveedor extends Persona {
    private String razonSocial;
    private String nif; // Número Identificación Fiscal
    
    public Proveedor(String nom, String dom, String dni, String tel, String razonSocial, String nif){
        super(nom, dom, dni, tel);
        this.razonSocial = razonSocial;
        this.nif = nif;
    }
    
    //CRUD
    public String getRazSocial(){return razonSocial;}
    public void setRazSocial(String razonSocial){this.razonSocial = razonSocial;}
    
    public String getNIF(){return nif;}
    public void setNIF(String nif){this.nif = nif;}
    
    
    @Override
    public String toString() {
        return super.toString() + ", Razon Social: " + razonSocial + ", NIF: " + nif;
    }
}
