/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class Carrito {
    private List<ProductoServicio> items;
    private EstrategiaDescuento estrategia;
    private static final double IVA = 0.21;

    public Carrito() {
        this.items = new ArrayList<>();
    }

    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }
    public EstrategiaDescuento getEstrategia(){return estrategia;}

    public void agregarProducto(ProductoServicio producto) {
        items.add(producto);
    }

    public void eliminarProducto(ProductoServicio producto) {
        items.remove(producto);
    }

    public List<ProductoServicio> getItems() {
        return items;
    }

    // Subtotal sin IVA ni descuentos
    public double calcularSubtotal() {
        double subtotal = 0;
        if(getEstrategia() != null){
            subtotal = estrategia.aplicar(items);
            return subtotal;
        }
        for (ProductoServicio p : items) {
            subtotal += p.getPrecio();
        }
        return subtotal;
    }

    
    //REVISAR #################################################################
    // Aplica descuento (si hay estrategia)   
    public double calcularConDescuento() {
        double subtotal = calcularSubtotal();
        if (estrategia != null) {
            return estrategia.aplicar(items);
        }
        return subtotal;
    }

    // Calcula el IVA (21%)
    public double calcularIVA() {
        return calcularSubtotal() * IVA;
    }

    // Total final = con descuento + IVA
    public double calcularTotal() {
        double total = calcularSubtotal() + calcularIVA();
        return total;
    }
}
