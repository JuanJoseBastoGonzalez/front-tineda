package com.jpa.proyecto.controllers;



import com.jpa.proyecto.model.Pedido;
import com.jpa.proyecto.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.crearPedido(pedido);
        return ResponseEntity.ok(nuevoPedido);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> obtenerPedidos() {
        List<Pedido> pedidos = pedidoService.obtenerPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{codigoPedido}")
    public ResponseEntity<Pedido> obtenerPedidoPorCodigo(@PathVariable Integer codigoPedido) {
        Optional<Pedido> pedido = pedidoService.obtenerPedidoPorCodigo(codigoPedido);
        return pedido.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{codigoPedido}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Integer codigoPedido, @RequestBody Pedido pedidoDetalles) {
        Pedido pedidoActualizado = pedidoService.actualizarPedido(codigoPedido, pedidoDetalles);
        if (pedidoActualizado != null) {
            return ResponseEntity.ok(pedidoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigoPedido}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer codigoPedido) {
        if (pedidoService.obtenerPedidoPorCodigo(codigoPedido).isPresent()) {
            pedidoService.eliminarPedido(codigoPedido);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
