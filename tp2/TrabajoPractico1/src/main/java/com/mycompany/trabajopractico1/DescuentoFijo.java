/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

import java.util.List;

/**
 *
 * @author felip
 */
public class DescuentoFijo implements EstrategiaDescuento{
    private final double monto;
    
    public DescuentoFijo(double monto) {
        this.monto = monto;
    }
    
    @Override
    public double aplicar(List<ProductoServicio> items) {
        double subTotal = items.stream().mapToDouble(item -> item.getPrecio()).sum();
        if(monto > subTotal){
            return 0;
        }
        return subTotal - monto;
    }
}
