package com.example.demo.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.service.DetallePedidoService;
import com.example.demo.repository.DetallePedidoRepository;
import com.example.demo.model.DetallePedido;
import com.example.demo.model.DetallePedidoId;
import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoImpl implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository repository;

    @Transactional
    @Override
    public List<DetallePedido> findAll() {
        return (List<DetallePedido>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<DetallePedido> findById(DetallePedido id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public DetallePedido save(DetallePedido detallePedido) {
        return repository.save(detallePedido);
    }

    @Transactional
    @Override
    public Optional<DetallePedido> update(DetallePedidoId id, DetallePedido detallePedido) {
        Optional<DetallePedido> detallePedidoOpt = repository.findById(id);
        if (detallePedidoOpt.isPresent()) {
            DetallePedido detallePedidoItem = detallePedidoOpt.orElseThrow();
            detallePedidoItem.setCantidad(detallePedido.getCantidad());
            detallePedidoItem.setPrecioUnidad(detallePedido.getPrecioUnidad());
            detallePedidoItem.setNumeroLinea(detallePedido.getNumeroLinea());
            return Optional.of(repository.save(detallePedidoItem));
        }
        return detallePedidoOpt;
    }

    @Transactional
    @Override
    public Optional<DetallePedido> deleteById(DetallePedidoId id) {
        Optional<DetallePedido> detallePedidoOpt = repository.findById(id);
        detallePedidoOpt.ifPresent(detallePedidoItem -> {
            repository.delete(detallePedidoItem);
        });
        return detallePedidoOpt;
    }
}
