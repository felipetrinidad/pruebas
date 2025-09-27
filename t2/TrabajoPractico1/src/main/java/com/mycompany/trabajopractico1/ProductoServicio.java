/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopractico1;

/**
 *
 * @author felip
 */
public class ProductoServicio {
    //Atributos
    private String codigo;
    private String nombre;
    private double precio;
    private Tipo tipo;
    private String categoria;
    private Proveedor proveedor;
    
    //enum
    public enum Tipo{
        PRODUCTO,
        SERVICIO
    }
    
    //Constructor
    public ProductoServicio(String codigo, String nombre, double precio, Tipo tipo, String categoria, Proveedor proveedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }
    
    //getters y setters
    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}

    public Tipo getTipo() {return tipo;}
    public void setTipo(Tipo tipo) {this.tipo = tipo;}

    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}

    public Proveedor getProveedor() {return proveedor;}
    public void setProveedor(Proveedor proveedor) {this.proveedor = proveedor;}
    
    
    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Nombre: " + nombre + ", Precio: $" +
                precio + ", Tipo: " + tipo + ", Categoria: " + categoria;
    }
    
}
