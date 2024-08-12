package com.jpa.proyecto.repository;


import com.jpa.proyecto.model.GamaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamaProductoRepository extends JpaRepository<GamaProducto, String> {
}