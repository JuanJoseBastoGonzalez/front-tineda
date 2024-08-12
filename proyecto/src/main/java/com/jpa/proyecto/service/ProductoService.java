package com.jpa.proyecto.service;



import com.jpa.proyecto.model.Producto;
import com.jpa.proyecto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerProductoPorCodigo(String codigoProducto) {
        return productoRepository.findById(codigoProducto);
    }

    public Producto actualizarProducto(String codigoProducto, Producto productoDetalles) {
        if (productoRepository.existsById(codigoProducto)) {
            productoDetalles.setCodigoProducto(codigoProducto);
            return productoRepository.save(productoDetalles);
        } else {
            return null; // O lanzar una excepción personalizada
        }
    }

    public void eliminarProducto(String codigoProducto) {
        productoRepository.deleteById(codigoProducto);
    }
}
