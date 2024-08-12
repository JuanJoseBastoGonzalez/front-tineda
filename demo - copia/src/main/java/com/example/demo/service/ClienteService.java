package com.example.demo.service;

import java.util.*;

import com.example.demo.model.Cliente;

public interface ClienteService {
    Optional<Cliente> findById(Integer codigoCliente);
    List<Cliente> findAll();
    Cliente save(Cliente cliente);
    Optional<Cliente> deleteById(Integer codigoCliente);
    Optional<Cliente> update(Integer codigoCliente, Cliente cliente);
}
