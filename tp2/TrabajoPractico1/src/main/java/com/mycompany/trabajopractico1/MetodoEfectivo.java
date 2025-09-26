/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

/**
 *
 * @author felip
 */
public class MetodoEfectivo extends MetodoPago{

    @Override
    public double procesarPago(double monto, Carrito carrito) {
        if(monto < 0|| monto > carrito.calcularTotal()){
            System.out.println("\nMonto inválido");
        }
        System.out.println("\nProcesando $" + monto + " con Efectivo...");
        return monto;
    }

    @Override
    public String getDetalles() {
        return "Efectivo.";
    }
    
}
