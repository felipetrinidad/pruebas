/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author felip
 */
public class Descuento2por1 implements EstrategiaDescuento {
    
    @Override
    public double aplicar(List<ProductoServicio> items) {
        double subTotal = 0;
        
        // Agrupar productos por ID
        Map<String, List<ProductoServicio>> productosAgrupados = items.stream().collect(Collectors.groupingBy(ProductoServicio::getCodigo));
        
        // Aplicar 2x1 a cada grupo de productos iguales
        for (List<ProductoServicio> grupo : productosAgrupados.values()) {
            int cantidad = grupo.size();
            double precioUnitario = grupo.get(0).getPrecio();
            
            // Calcular cuántos pagar: cada 2 productos iguales, pagas 1
            int aPagar = (cantidad / 2) + (cantidad % 2);
            subTotal += aPagar * precioUnitario;
        }
        
        return subTotal;
    }

    
}
