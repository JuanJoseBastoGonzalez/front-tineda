package com.jpa.proyecto.controllers;


import com.jpa.proyecto.model.DetallePedido;
import com.jpa.proyecto.model.DetallePedidoId;
import com.jpa.proyecto.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalles-pedidos")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @PostMapping
    public ResponseEntity<DetallePedido> crearDetallePedido(@RequestBody DetallePedido detallePedido) {
        DetallePedido nuevoDetallePedido = detallePedidoService.crearDetallePedido(detallePedido);
        return ResponseEntity.ok(nuevoDetallePedido);
    }

    @GetMapping
    public ResponseEntity<List<DetallePedido>> obtenerDetallesPedidos() {
        List<DetallePedido> detallesPedidos = detallePedidoService.obtenerDetallesPedidos();
        return ResponseEntity.ok(detallesPedidos);
    }

    @GetMapping("/{codigoProducto}/{numeroLinea}")
    public ResponseEntity<DetallePedido> obtenerDetallePedidoPorId(
            @PathVariable String codigoProducto,
            @PathVariable Integer numeroLinea) {
        DetallePedidoId id = new DetallePedidoId();
        id.setCodigoProducto(codigoProducto);
        id.setNumeroLinea(numeroLinea);
        Optional<DetallePedido> detallePedido = detallePedidoService.obtenerDetallePedidoPorId(id);
        return detallePedido.map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{codigoProducto}/{numeroLinea}")
    public ResponseEntity<DetallePedido> actualizarDetallePedido(
            @PathVariable String codigoProducto,
            @PathVariable Integer numeroLinea,
            @RequestBody DetallePedido detallePedidoDetalles) {
        DetallePedidoId id = new DetallePedidoId();
        id.setCodigoProducto(codigoProducto);
        id.setNumeroLinea(numeroLinea);
        DetallePedido detallePedidoActualizado = detallePedidoService.actualizarDetallePedido(id, detallePedidoDetalles);
        if (detallePedidoActualizado != null) {
            return ResponseEntity.ok(detallePedidoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigoProducto}/{numeroLinea}")
    public ResponseEntity<Void> eliminarDetallePedido(
            @PathVariable String codigoProducto,
            @PathVariable Integer numeroLinea) {
        DetallePedidoId id = new DetallePedidoId();
        id.setCodigoProducto(codigoProducto);
        id.setNumeroLinea(numeroLinea);
        if (detallePedidoService.obtenerDetallePedidoPorId(id).isPresent()) {
            detallePedidoService.eliminarDetallePedido(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
