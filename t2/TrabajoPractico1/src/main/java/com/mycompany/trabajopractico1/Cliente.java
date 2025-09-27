/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;



/**
 *
 * @author felip
 */
import com.mycompany.trabajopractico1.Factura;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    // Atributos
    private double lim_cred;
    private List<Factura> historialCompra = new ArrayList<>();
    private Categoria categoria;
    private String mail;
    
    public enum Categoria {
        REGULAR,
        PREMIUM,
        CORPORATIVO}
    
    
    //COnstructor
    public Cliente(String nom, String dom, String dni, String tel, double lim, Categoria categoria) {
        super(nom, dom, dni, tel);
        this.lim_cred = lim;
        this.categoria = categoria;
        this.mail = mail;
    }
    
    
    //Metodos
    public void agregarAlHistorial(Factura factura) {
        historialCompra.add(factura);
    }
    
    //Notificaciones
    
    public String getEmail() {return mail;}
    public void setEmail(String mail){this.mail = mail;}
            
    
    
    //CRUD
    public double getLimCredito(){return lim_cred;}
    public void setLimCredito(double lim_cred){this.lim_cred = lim_cred;}
    
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
  
    
    public void getHistorial(){
        System.out.println("HISTORIAL DE COMPRAS  -  CLIENTE: " + getNombre());
        System.out.println("");
        if (historialCompra.isEmpty()) {
            System.out.println("El cliente no tiene compras registradas.");
        } else {
            for (int i = 0; i < historialCompra.size(); i++) {
                System.out.println("COMPRA #" + (i + 1) + ":");
                historialCompra.get(i).mostrarDetalle();
                System.out.println("----------------------------------------");
            }
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Categoria: " + getCategoria() + ",\nLimite Credito: $" +
                                getLimCredito() + ", Domicilio: " + getDomicilio();
    }
}
