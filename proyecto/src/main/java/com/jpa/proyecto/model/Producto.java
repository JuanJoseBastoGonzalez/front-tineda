package com.jpa.proyecto.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity
public class Producto {

    @Id
    @Column(length = 50)
    private String codigoProducto;

    @Column(length = 100)
    private String nombre;

    @Column(length = 50)
    private String gama;

    @Column(length = 100)
    private String dimensiones;

    @Column(length = 100)
    private String proveedor;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column
    private Short cantidadEnStock;

    @Column(precision = 10, scale = 2)
    private Double precioVenta;

    @Column(precision = 10, scale = 2)
    private Double precioProveedor;

    // Getters y Setters
    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(Short cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(Double precioProveedor) {
        this.precioProveedor = precioProveedor;
    }
}
