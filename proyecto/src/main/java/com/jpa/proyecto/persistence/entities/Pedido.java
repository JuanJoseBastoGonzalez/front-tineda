package com.jpa.proyecto.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    private Integer codigoPedido;

    private java.sql.Date fechaPedido;
    private java.sql.Date fechaEsperada;
    private java.sql.Date fechaEntrega;
    private String estado;
    private String comentarios;
    private Integer codigoCliente;

    // Getters y Setters
    public Integer getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Integer codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public java.sql.Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(java.sql.Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public java.sql.Date getFechaEsperada() {
        return fechaEsperada;
    }

    public void setFechaEsperada(java.sql.Date fechaEsperada) {
        this.fechaEsperada = fechaEsperada;
    }

    public java.sql.Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(java.sql.Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
}
