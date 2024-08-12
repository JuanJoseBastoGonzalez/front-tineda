package com.jpa.proyecto.repository;



import com.jpa.proyecto.model.DetallePedido;
import com.jpa.proyecto.model.DetallePedidoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, DetallePedidoId> {
}
