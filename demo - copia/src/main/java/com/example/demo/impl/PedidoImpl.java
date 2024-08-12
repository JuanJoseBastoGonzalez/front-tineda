package com.example.demo.impl;


import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoImpl implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Transactional
    @Override
    public List<Pedido> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Pedido> findById(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Pedido save(Pedido pedido) {
        return repository.save(pedido);
    }

    @Transactional
    @Override
    public Optional<Pedido> update(Integer id, Pedido pedido) {
        Optional<Pedido> pedidoOpt = repository.findById(id);
        if (pedidoOpt.isPresent()) {
            Pedido pedidoItem = pedidoOpt.get();
            pedidoItem.setFechaPedido(pedido.getFechaPedido());
            pedidoItem.setFechaEsperada(pedido.getFechaEsperada());
            pedidoItem.setFechaEntrega(pedido.getFechaEntrega());
            pedidoItem.setEstado(pedido.getEstado());
            pedidoItem.setComentarios(pedido.getComentarios());
            pedidoItem.setCodigoCliente(pedido.getCodigoCliente());
            return Optional.of(repository.save(pedidoItem));
        }
        return pedidoOpt;
    }

    @Transactional
    @Override
    public Optional<Pedido> delete(Integer id) {
        Optional<Pedido> pedidoOpt = repository.findById(id);
        pedidoOpt.ifPresent(pedidoItem -> repository.delete(pedidoItem));
        return pedidoOpt;
    }
}
