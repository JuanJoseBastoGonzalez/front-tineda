package com.jpa.proyecto.service;


import com.jpa.proyecto.model.GamaProducto;
import com.jpa.proyecto.repository.GamaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaProductoService {

    @Autowired
    private GamaProductoRepository gamaProductoRepository;

    public GamaProducto crearGamaProducto(GamaProducto gamaProducto) {
        return gamaProductoRepository.save(gamaProducto);
    }

    public List<GamaProducto> obtenerGamasProductos() {
        return gamaProductoRepository.findAll();
    }

    public Optional<GamaProducto> obtenerGamaProductoPorId(String id) {
        return gamaProductoRepository.findById(id);
    }

    public GamaProducto actualizarGamaProducto(String id, GamaProducto gamaProductoDetalles) {
        if (gamaProductoRepository.existsById(id)) {
            gamaProductoDetalles.setId(id);
            return gamaProductoRepository.save(gamaProductoDetalles);
        } else {
            return null; // O lanzar una excepción personalizada
        }
    }

    public void eliminarGamaProducto(String id) {
        gamaProductoRepository.deleteById(id);
    }
}