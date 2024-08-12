package com.example.demo.model;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "detalle_pedidos")
public class DetallePedido {

    @EmbeddedId
    private DetallePedidoId id;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unidad", nullable = false)
    private BigDecimal precioUnidad;

    @Column(name = "numero_linea", nullable = false)
    private Short numeroLinea;

    public DetallePedido() {
    }

    // Constructor con parámetros
    public DetallePedido(DetallePedidoId id, Integer cantidad, BigDecimal precioUnidad, Short numeroLinea) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.numeroLinea = numeroLinea;
    }

    // Getters y Setters
    public DetallePedidoId getId() {
        return id;
    }

    public void setId(DetallePedidoId id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(BigDecimal precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Short getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(Short numeroLinea) {
        this.numeroLinea = numeroLinea;
    }




}
   