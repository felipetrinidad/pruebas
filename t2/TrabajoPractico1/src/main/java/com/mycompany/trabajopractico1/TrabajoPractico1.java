/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabajopractico1;
import com.mycompany.interfaz.Gui;

/**
 *
 * @author felip
 */
public class TrabajoPractico1 {
    private Gui gui;
    
    public static void main(String[] args) {
        
////     Crear proveedores
//        Proveedor provTecnologia = new Proveedor("Juan Perez", "Av. Libertad 742", "30123456", "3764234567", 
//                                                "Tecnologia S.A.", "10-12345678-9");
//        
////         Crear departamentos
        Empleado gerenteVentas = new Empleado("Carlos Lopez", "Av. San Martin 456", "25432198", "3754876543", 
                                             900000, Empleado.Puesto.GERENTE, "01/01/2020", null);
        Departamento deptoVentas = new Departamento("Departamendo de Ventas", 5000000, gerenteVentas);
        gerenteVentas.setDepartamento(deptoVentas);
//        
////         Crear empleados
        Empleado empleado1 = new Empleado("Ana Torres", "Calle Sarmiento 789", "28765432", "3754554423", 
                                          500000, Empleado.Puesto.ADMINISTRATIVO, "15/03/2021", deptoVentas);
        
////         Crear clientes
        Cliente cliente1 = new Cliente("Roberto Diaz", "Av. Belgrano 321", "33445566", "3754258491", 
                                       100000, Cliente.Categoria.PREMIUM);
//        
////         Crear productos y servicios
//        ProductoServicio producto1 = new ProductoServicio("P001", "Notebook Gamer", 35000, ProductoServicio.Tipo.PRODUCTO,
//                                                          "tecnologia", provTecnologia);
//        
//        ProductoServicio producto2 = new ProductoServicio("P002", "Teclado", 10000, ProductoServicio.Tipo.PRODUCTO,
//                                                          "periferico", provTecnologia);
//        
//        ProductoServicio servicio1 = new ProductoServicio("S001", "Instalacion", 5000, ProductoServicio.Tipo.SERVICIO,
//                                                          "Servicio Tecnico", provTecnologia);
//        
////         Crear factura
//        Factura factura1 = new Factura("F-0001", cliente1, empleado1);
//        factura1.agregarItem(producto1);
//        factura1.agregarItem(producto2);
//        factura1.agregarItem(servicio1);
//        
//        Factura factura2 = new Factura("F-0002", cliente1, empleado1);
//        factura2.agregarItem(producto1);
//        factura2.agregarItem(producto2);
//        factura2.agregarItem(servicio1);
//        
//        
////         Agregar Factura al Historial del CLiente
//        cliente1.agregarAlHistorial(factura1);
//        cliente1.agregarAlHistorial(factura2);
//        
////         Crear pago
//        factura1.asociarPago("P-001", Pago.Metodo.TARJETA, Pago.Estado.APROBADO);
//        factura2.asociarPago("P-002", Pago.Metodo.TRANSFERENCIA, Pago.Estado.APROBADO);        
//        
////         Mostrar detalle de la factura
//        factura1.mostrarDetalle();
////        cliente1.getHistorial();
//##########################################################################################
// TP2

//        Carrito carrito = new Carrito();
//        Proveedor proveedor = new Proveedor("Juan Perez", "Av. Libertad 742", "30123456", "3764234567","Tecnologia S.A.", "10-12345678-9"); // ejemplo
//        carrito.agregarProducto(new ProductoServicio("P1", "Teclado", 2000, ProductoServicio.Tipo.PRODUCTO, "Electrónica", proveedor));
//        carrito.agregarProducto(new ProductoServicio("P1", "Teclado", 2000, ProductoServicio.Tipo.PRODUCTO, "Electrónica", proveedor));
//        carrito.agregarProducto(new ProductoServicio("P2", "Mouse", 1500, ProductoServicio.Tipo.PRODUCTO, "Electrónica", proveedor));
//
//// Aplicar 10% descuento
//        carrito.setEstrategia(new Descuento2por1());
//
//        System.out.println("Subtotal: $" + carrito.calcularSubtotal());
//        System.out.println("Con descuento: $" + carrito.calcularConDescuento());
//        System.out.println("IVA (21%): $" + carrito.calcularIVA());
//        System.out.println("Total final: $" + carrito.calcularTotal());
//        
//        // 1. Tarjeta de Crédito
//        MetodoPago tarjetaCredito = new MetodoTarjetaCredito("1234567812345678", "12/25", "123");
//        
//        // 2. Efectivo
//        MetodoPago efectivo = new MetodoEfectivo();
//        
//        // 3. Transferencia Bancaria
//        MetodoPago transferencia = new MetodoTransferencia("1234567890123456789012", "Banco Nación");
//        
//        
//        // Crear una factura
//        Factura factura = new Factura(cliente1, empleado1, carrito);
//
//// Realizar un pago parcial de $100
//        factura.realizarPagoParcial(100.0, tarjetaCredito);
//
//// Realizar otro pago parcial de $50
//        factura.realizarPagoParcial(50.0, efectivo);
//
//// Mostrar el estado actual
////        factura.mostrarDetalle();
//
//// Verificar saldo pendiente
//        factura.asociarPagoCompleto(efectivo);
//        System.out.println("\n\n\n\n");
//        factura.mostrarDetalle();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Gui().setVisible(true); // Reemplaza "NombreDeTuClase"
        }
    });
    }
}
