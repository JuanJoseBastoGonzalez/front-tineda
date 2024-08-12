package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Oficina;

public interface OficinaService {
    Oficina findById(String codigoOficina);
    List<Oficina> findAll();
    Oficina save(Oficina oficina);
    void deleteById(String codigoOficina);
}
