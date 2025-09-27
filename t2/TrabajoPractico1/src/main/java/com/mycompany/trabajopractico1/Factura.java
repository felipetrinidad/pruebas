/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author felip
 */




public class Factura {
    // Atributos
    private static int contadorFacturas = 0;
    private final int numero;
    private final LocalDate fechaEmision;
    private final Cliente cliente;
    private final Empleado empleado;
    private final Carrito carrito;
    private List<Pago> pagos; // Cambiado a lista para múltiples pagos
    private final double totalFactura;
    
    // Constructor
    public Factura(Cliente cliente, Empleado empleado, Carrito carrito) {
        this.numero = ++contadorFacturas;
        this.cliente = cliente;
        this.empleado = empleado;
        this.carrito = carrito;
        this.fechaEmision = LocalDate.now();
        this.totalFactura = carrito.calcularTotal();
        this.pagos = new ArrayList<>();
    }
    
    // Getters
    public int getNumeroFactura() { return numero; }
    public LocalDate getFechaFactura() { return fechaEmision; }
    public Cliente getCliente() { return cliente; }
    public Empleado getEmiente() { return empleado; }
    public List<Pago> getPagos() { return pagos; }
    public double getTotalFactura() { return totalFactura; }
    public double getSaldoPendiente() {
        double totalPagado = pagos.stream().mapToDouble(Pago::getMontoPagado).sum();
        if(totalFactura - totalPagado < 0){
            return 0;
        }
        return totalFactura - totalPagado;
    }
    public boolean isPagadaCompletamente() {
        return getSaldoPendiente() <= 0;
    }
    
    // Métodos para pagos
    public void asociarPagoCompleto(MetodoPago metodoPago) {
        Pago pago = new Pago(totalFactura, metodoPago, carrito);
        pago.realizarPagoParcial(totalFactura); // Pago completo
        pagos.add(pago);
    }
    
    public void realizarPagoParcial(double monto, MetodoPago metodoPago) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        if (monto > getSaldoPendiente()) {
            throw new IllegalArgumentException("El monto excede el saldo pendiente: $" + getSaldoPendiente());
        }
        
        // Buscar un pago parcial existente o crear uno nuevo
        Pago pagoParcial = pagos.stream()
            .filter(p -> p.getEstadoPago() == Pago.Estado.PARCIAL || p.getEstadoPago() == Pago.Estado.PENDIENTE)
            .findFirst()
            .orElse(new Pago(totalFactura, metodoPago, carrito));
        
        if (!pagos.contains(pagoParcial)) {
            pagos.add(pagoParcial);
        }
        
        pagoParcial.realizarPagoParcial(monto);
    }
    
    
    // NOTIFICACIONES
    public void notificarPorEmail(NotificacionServicio servicio) {
        String mensaje = generarMensajeFactura();
        servicio.Notificar(cliente.getEmail(), mensaje);
    }

    public void notificarPorSMS(NotificacionServicio servicio) {
        String mensaje = generarMensajeFactura();
        servicio.Notificar(cliente.getTelefono(), mensaje);
    }

    // mensaje estandarizado
    private String generarMensajeFactura() {
        return "Factura N°" + numero +
                " | Total: $" + totalFactura +
                " | Estado: " + (isPagadaCompletamente() ? "PAGADA" : "PENDIENTE");
}

    
    // Mostrar detalle de factura
    public void mostrarDetalle() {
        System.out.println("=== FACTURA Numero: " + getNumeroFactura() + " ===");
        System.out.println("Fecha: " + getFechaFactura());
        System.out.println(" ");
        
        System.out.println("CLIENTE:");
        System.out.println("Nombre: " + cliente.toString());
        System.out.println(" ");
        
        System.out.println("EMPLEADO:");
        System.out.println("Nombre: " + empleado.toString());
        System.out.println(" ");
        
        System.out.println("DEPARTAMENTO: ");
        System.out.println(empleado.getDepartamento());
        
        System.out.println(" ");
        System.out.println("ITEMS:");
        for (ProductoServicio p : carrito.getItems()) {
            System.out.println(" - " + p);
        }

        System.out.println("");
        System.out.println("Subtotal: $" + carrito.calcularSubtotal());
        System.out.println("IVA (21%): $" + carrito.calcularIVA());
        System.out.println("TOTAL FACTURA: $" + totalFactura);

        if (!pagos.isEmpty()) {
            System.out.println("");
            System.out.println("PAGOS REALIZADOS:");
            for (Pago pago : pagos) {
                System.out.println(pago + "\n");
            }
            System.out.println("SALDO PENDIENTE: $" + getSaldoPendiente());
            System.out.println("ESTADO: " + (isPagadaCompletamente() ? "PAGADA" : "PENDIENTE"));
        }

        System.out.println("==============================");
    }
}
