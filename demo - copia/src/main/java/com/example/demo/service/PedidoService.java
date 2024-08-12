package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Pedido;

public interface PedidoService {
    Pedido findById(Integer codigoPedido);
    List<Pedido> findAll();
    Pedido save(Pedido pedido);
    void deleteById(Integer codigoPedido);
}
