package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DetallePedido;
import com.example.demo.model.DetallePedidoId;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido,DetallePedidoId> {
}