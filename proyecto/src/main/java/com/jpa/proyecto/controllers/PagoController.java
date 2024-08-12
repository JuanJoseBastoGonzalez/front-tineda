package com.jpa.proyecto.controllers;



import com.jpa.proyecto.model.Pago;
import com.jpa.proyecto.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping
    public ResponseEntity<Pago> crearPago(@RequestBody Pago pago) {
        Pago nuevoPago = pagoService.crearPago(pago);
        return ResponseEntity.ok(nuevoPago);
    }

    @GetMapping
    public ResponseEntity<List<Pago>> obtenerPagos() {
        List<Pago> pagos = pagoService.obtenerPagos();
        return ResponseEntity.ok(pagos);
    }

    @GetMapping("/{codigoCliente}")
    public ResponseEntity<Pago> obtenerPagoPorCodigo(@PathVariable Integer codigoCliente) {
        Optional<Pago> pago = pagoService.obtenerPagoPorCodigo(codigoCliente);
        return pago.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{codigoCliente}")
    public ResponseEntity<Pago> actualizarPago(@PathVariable Integer codigoCliente, @RequestBody Pago pagoDetalles) {
        Pago pagoActualizado = pagoService.actualizarPago(codigoCliente, pagoDetalles);
        if (pagoActualizado != null) {
            return ResponseEntity.ok(pagoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigoCliente}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Integer codigoCliente) {
        if (pagoService.obtenerPagoPorCodigo(codigoCliente).isPresent()) {
            pagoService.eliminarPago(codigoCliente);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
