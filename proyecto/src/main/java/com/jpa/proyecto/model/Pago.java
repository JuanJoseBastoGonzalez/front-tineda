package com.jpa.proyecto.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Pago {

    @Id
    @Column
    private Integer codigoCliente;

    @Column(length = 50)
    private String formaPago;

    @Column(length = 100)
    private String idTransaccion;

    @Column
    private java.sql.Date fechaPago;

    @Column(precision = 10, scale = 2)
    private Double total;

    // Getters y Setters
    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public java.sql.Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(java.sql.Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
    
