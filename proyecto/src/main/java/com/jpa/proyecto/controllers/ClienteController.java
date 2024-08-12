package com.jpa.proyecto.controllers;


import com.jpa.proyecto.model.Cliente;
import com.jpa.proyecto.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.crearCliente(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        List<Cliente> clientes = clienteService.obtenerClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{codigoCliente}")
    public ResponseEntity<Cliente> obtenerClientePorCodigo(@PathVariable Integer codigoCliente) {
        Optional<Cliente> cliente = clienteService.obtenerClientePorCodigo(codigoCliente);
        return cliente.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{codigoCliente}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer codigoCliente, @RequestBody Cliente clienteDetalles) {
        Cliente clienteActualizado = clienteService.actualizarCliente(codigoCliente, clienteDetalles);
        if (clienteActualizado != null) {
            return ResponseEntity.ok(clienteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigoCliente}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Integer codigoCliente) {
        if (clienteService.obtenerClientePorCodigo(codigoCliente).isPresent()) {
            clienteService.eliminarCliente(codigoCliente);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
