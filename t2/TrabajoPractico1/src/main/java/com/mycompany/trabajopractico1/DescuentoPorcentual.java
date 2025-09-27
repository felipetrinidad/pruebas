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
public class DescuentoPorcentual implements EstrategiaDescuento{
    private double porcentaje;
    
    public DescuentoPorcentual(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    public void setPorcentaje(double porcentaje){this.porcentaje = porcentaje;}
    
    @Override
    public double aplicar(List<ProductoServicio> items) {
        double subtotal = items.stream().mapToDouble(item -> item.getPrecio() ).sum();
        return subtotal * (1 - porcentaje / 100);
    }
    
}
