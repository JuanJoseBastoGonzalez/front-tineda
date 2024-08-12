package com.jpa.proyecto.service;



import com.jpa.proyecto.model.Pedido;
import com.jpa.proyecto.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obtenerPedidoPorCodigo(Integer codigoPedido) {
        return pedidoRepository.findById(codigoPedido);
    }

    public Pedido actualizarPedido(Integer codigoPedido, Pedido pedidoDetalles) {
        if (pedidoRepository.existsById(codigoPedido)) {
            pedidoDetalles.setCodigoPedido(codigoPedido);
            return pedidoRepository.save(pedidoDetalles);
        } else {
            return null; // O lanzar una excepción personalizada
        }
    }

    public void eliminarPedido(Integer codigoPedido) {
        pedidoRepository.deleteById(codigoPedido);
    }
}
