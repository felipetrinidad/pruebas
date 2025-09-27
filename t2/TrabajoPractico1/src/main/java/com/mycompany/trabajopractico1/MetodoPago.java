/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

/**
 *
 * @author felip
 */
public abstract class MetodoPago {
    
    public abstract double procesarPago(double monto, Carrito carrito);
    
    public abstract String getDetalles();
}
