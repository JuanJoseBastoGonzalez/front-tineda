package com.jpa.proyecto.service;



import com.jpa.proyecto.model.DetallePedido;
import com.jpa.proyecto.model.DetallePedidoId;
import com.jpa.proyecto.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedido crearDetallePedido(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    public List<DetallePedido> obtenerDetallesPedidos() {
        return detallePedidoRepository.findAll();
    }

    public Optional<DetallePedido> obtenerDetallePedidoPorId(DetallePedidoId id) {
        return detallePedidoRepository.findById(id);
    }

    public DetallePedido actualizarDetallePedido(DetallePedidoId id, DetallePedido detallePedidoDetalles) {
        if (detallePedidoRepository.existsById(id)) {
            detallePedidoDetalles.setCodigoProducto(id.getCodigoProducto());
            detallePedidoDetalles.setNumeroLinea(id.getNumeroLinea());
            return detallePedidoRepository.save(detallePedidoDetalles);
        } else {
            return null; // O lanzar una excepción personalizada
        }
    }

    public void eliminarDetallePedido(DetallePedidoId id) {
        detallePedidoRepository.deleteById(id);
    }
}
