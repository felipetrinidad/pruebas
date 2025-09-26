/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

/**
 *
 * @author felip
 */
public class MetodoTarjetaCredito extends MetodoPago{
    private final String numeroTarjeta;
    private final String fechaVencimiento;
    private final String cvv;
    
    public MetodoTarjetaCredito(String numeroTarjeta, String fechaVencimiento, String cvv){
        if (numeroTarjeta == null || numeroTarjeta.length() != 16) {
            throw new IllegalArgumentException("\nNumero de tarjeta invalido");
        }
        if (fechaVencimiento == null || !fechaVencimiento.matches("\\d{2}/\\d{2}")) {
            throw new IllegalArgumentException("\nFecha de expiración invalida");
        }
        if (cvv == null || cvv.length() != 3) {
            throw new IllegalArgumentException("\nCVV Invalido");
        }
        
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
    }

    @Override
    public double procesarPago(double monto, Carrito carrito) {
        
        if (monto <= 0 || monto > carrito.calcularTotal()) {
            System.out.println("\nMonto inválido");
        }
        
        System.out.println("\nProcesando $" + monto + " con Tarjeta de Credito");
        return monto;
    }

    @Override
    public String getDetalles() {
        return "Tarjeta de Crédito terminada en: " + numeroTarjeta.substring(numeroTarjeta.length() - 4);
    }
}
