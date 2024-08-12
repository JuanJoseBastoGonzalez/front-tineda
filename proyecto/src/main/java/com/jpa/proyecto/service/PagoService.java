package com.jpa.proyecto.service;



import com.jpa.proyecto.model.Pago;
import com.jpa.proyecto.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public Pago crearPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public List<Pago> obtenerPagos() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> obtenerPagoPorCodigo(Integer codigoCliente) {
        return pagoRepository.findById(codigoCliente);
    }

    public Pago actualizarPago(Integer codigoCliente, Pago pagoDetalles) {
        if (pagoRepository.existsById(codigoCliente)) {
            pagoDetalles.setCodigoCliente(codigoCliente);
            return pagoRepository.save(pagoDetalles);
        } else {
            return null; // O lanzar una excepción personalizada
        }
    }

    public void eliminarPago(Integer codigoCliente) {
        pagoRepository.deleteById(codigoCliente);
    }
}
