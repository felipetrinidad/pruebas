/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

import java.time.LocalDate;

/**
 *
 * @author felip
 */


public class Pago {
    // Atributos
    private static int contadorRecibos = 0;
    private final int numeroRecibo;
    private double montoPagado;
    private final double montoTotal;
    private final LocalDate fecha;
    private final MetodoPago metodoPago; 
    private Estado estado; // Cambiado a no final para poder modificarlo
    private final Carrito carrito;
    
    // enum
    public enum Estado {PENDIENTE, PARCIAL, CANCELADO, APROBADO}
    
    // Constructor para pago completo
    public Pago(double montoTotal, MetodoPago metodoPago, Carrito carrito) {
        this(montoTotal, 0, metodoPago, carrito);
        this.estado = Estado.PENDIENTE;
    }
    
    // Constructor para pagos parciales
    public Pago(double montoTotal, double montoPagado, MetodoPago metodoPago, Carrito carrito) {
        if (montoTotal <= 0) {
            throw new IllegalArgumentException("El monto total debe ser mayor a 0");
        }
        if (montoPagado < 0 || montoPagado > montoTotal) {
            throw new IllegalArgumentException("El monto pagado debe estar entre 0 y el monto total");
        }
        
        this.numeroRecibo = ++contadorRecibos;
        this.montoTotal = montoTotal;
        this.montoPagado = montoPagado;
        this.metodoPago = metodoPago;
        this.carrito = carrito;
        this.fecha = LocalDate.now();
        actualizarEstado();
    }
    
    // Método para realizar un pago parcial
    public void realizarPagoParcial(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a pagar debe ser mayor a 0");
        }
        if (this.estado == Estado.APROBADO) {
            throw new IllegalStateException("El pago ya está completamente aprobado");
        }
        if (this.estado == Estado.CANCELADO) {
            throw new IllegalStateException("El pago está cancelado");
        }
        
        double nuevoMontoPagado = this.montoPagado + monto;
        
        if (nuevoMontoPagado > this.montoTotal) {
            throw new IllegalArgumentException("El monto excede el total pendiente. Pendiente: $" + 
                                             (this.montoTotal - this.montoPagado));
        }
        
        this.montoPagado = nuevoMontoPagado;
        actualizarEstado();
        
        // Procesar el pago con el método de pago
        metodoPago.procesarPago(monto, carrito);
    }
    
    // Método para actualizar el estado según el monto pagado
    private void actualizarEstado() {
        if (montoPagado == 0) {
            this.estado = Estado.PENDIENTE;
        } else if (montoPagado < montoTotal) {
            this.estado = Estado.PARCIAL;
        } else {
            this.estado = Estado.APROBADO;
        }
    }
    
    // Getters
    public int getNumeroRecibo() { return numeroRecibo; }
    public double getMontoPagado() { return montoPagado; }
    public double getMontoTotal() { return montoTotal; }
    public double getSaldoPendiente() { return montoTotal - montoPagado; }
    public LocalDate getFechaPago() { return fecha; }
    public String getMetodoPago() { return metodoPago.getDetalles(); }
    public Estado getEstadoPago() { return estado; }
    public Carrito getCarrito() { return carrito; }

    @Override
    public String toString() {
        return "Recibo: " + getNumeroRecibo() + 
               ", Monto Total: $" + getMontoTotal() +
               ", Monto Pagado: $" + getMontoPagado() +
               ", Pendiente: $" + getSaldoPendiente() +
               ", Fecha: " + getFechaPago() + 
               ", Método: " + getMetodoPago() + 
               ", Estado: " + getEstadoPago();
    }
}