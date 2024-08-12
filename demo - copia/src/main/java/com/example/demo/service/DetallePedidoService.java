package com.example.demo.service;

import com.example.demo.model.DetallePedido;
import com.example.demo.model.DetallePedidoId;

import java.util.List;
import java.util.Optional;

public interface DetallePedidoService {
    List<DetallePedido> findAll();
    Optional<DetallePedido> findById(DetallePedido id);
    DetallePedido save(DetallePedido detallePedido);
    Optional<DetallePedido> deleteById(DetallePedidoId id);
    Optional<DetallePedido> update(DetallePedidoId id, DetallePedido detallePedido);
}
