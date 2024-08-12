package com.jpa.proyecto.model;



import java.io.Serializable;
import java.util.Objects;

public class DetallePedidoId implements Serializable {

    private String codigoProducto;
    private Integer numeroLinea;

    // Getters, Setters, hashCode y equals
    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(Integer numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetallePedidoId that = (DetallePedidoId) o;
        return Objects.equals(codigoProducto, that.codigoProducto) &&
               Objects.equals(numeroLinea, that.numeroLinea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoProducto, numeroLinea);
    }
}
