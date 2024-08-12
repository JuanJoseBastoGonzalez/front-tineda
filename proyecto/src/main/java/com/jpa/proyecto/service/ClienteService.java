package com.jpa.proyecto.service;



import com.jpa.proyecto.model.Cliente;
import com.jpa.proyecto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorCodigo(Integer codigoCliente) {
        return clienteRepository.findById(codigoCliente);
    }

    public Cliente actualizarCliente(Integer codigoCliente, Cliente clienteDetalles) {
        if (clienteRepository.existsById(codigoCliente)) {
            clienteDetalles.setCodigoCliente(codigoCliente);
            return clienteRepository.save(clienteDetalles);
        } else {
            return null; // O lanzar una excepción personalizada
        }
    }

    public void eliminarCliente(Integer codigoCliente) {
        clienteRepository.deleteById(codigoCliente);
    }
}
