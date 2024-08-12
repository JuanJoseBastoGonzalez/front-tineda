package com.example.demo.impl;

import com.example.demo.service.ClienteService;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class ClienteImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Cliente> findById(Integer codigoCliente) {
        return repository.findById(codigoCliente);
    }

    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Transactional
    @Override
    public Optional<Cliente> update(Integer codigoCliente, Cliente cliente) {
        Optional<Cliente> clienteOpt = repository.findById(codigoCliente);
        if (clienteOpt.isPresent()) {
            Cliente clienteItem = clienteOpt.orElseThrow();
            clienteItem.setNombreCliente(cliente.getNombreCliente());
            clienteItem.setNombreContacto(cliente.getNombreContacto());
            clienteItem.setApellidoContacto(cliente.getApellidoContacto());
            clienteItem.setTelefono(cliente.getTelefono());
            clienteItem.setFax(cliente.getFax());
            clienteItem.setLineaDireccion1(cliente.getLineaDireccion1());
            clienteItem.setLineaDireccion2(cliente.getLineaDireccion2());
            clienteItem.setCiudad(cliente.getCiudad());
            clienteItem.setRegion(cliente.getRegion());
            clienteItem.setCodigoPostal(cliente.getCodigoPostal());
            clienteItem.setCodigoEmpleado(cliente.getCodigoEmpleado());
            clienteItem.setLimiteCredito(cliente.getLimiteCredito());
            return Optional.of(repository.save(clienteItem));
        }
        return clienteOpt;
    }

    @Transactional
    @Override
    public Optional<Cliente> deleteById(Integer codigoCliente) {
        Optional<Cliente> clienteOpt = repository.findById(codigoCliente);
        clienteOpt.ifPresent(clienteItem -> {
            repository.delete(clienteItem);
        });
        return clienteOpt;
    }
}
