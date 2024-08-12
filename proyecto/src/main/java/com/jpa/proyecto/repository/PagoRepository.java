package com.jpa.proyecto.repository;


import com.jpa.proyecto.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
