package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Embeddable
public class DetallePedidoId implements Serializable {

    @Column(name = "codigo_producto")
    private String codigoProducto;

    @Column(name = "codigo_pedido")
    private Integer codigoPedido;

     public DetallePedidoId() {
    }

    // Constructor con parámetros
    public DetallePedidoId(String codigoProducto, Integer codigoPedido) {
        this.codigoProducto = codigoProducto;
        this.codigoPedido = codigoPedido;
    }

    // Getters y Setters
    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }
}
