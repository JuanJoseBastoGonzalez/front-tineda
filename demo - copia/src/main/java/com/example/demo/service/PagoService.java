package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Pago;

public interface PagoService {
    Pago findById(Integer id);
    List<Pago> findAll();
    Pago save(Pago pago);
    void deleteById(Integer id);
}
