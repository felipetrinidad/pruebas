/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

/**
 *
 * @author felip
 */
public class MetodoTransferencia extends MetodoPago{
    private final String numeroCuenta;
    private final String clave;

    public MetodoTransferencia(String numeroCuenta, String clave){
        if (numeroCuenta == null || numeroCuenta.isEmpty()) {
            throw new IllegalArgumentException("\nNumero de cuenta bancaria invalido");
        }
        if (clave == null || clave.isEmpty()) {
            throw new IllegalArgumentException("\nClave bancaria invalida");
        }
        
        this.numeroCuenta = numeroCuenta;
        this.clave = clave;
    }
    
    
    @Override
    public double procesarPago(double monto, Carrito carrito) {
        if (monto <= 0 || monto > carrito.calcularTotal()) {
            System.out.println("\nMonto inválido");
        }
        
        System.out.println("\nProcesando $" + monto + " con Transferencia Bancaria");
        return monto;
    }

    @Override
    public String getDetalles() {
        return "Transferencia bancaria a la cuenta: " + numeroCuenta;
    }
    
    
}
