package com.jpa.proyecto.controllers;
import com.jpa.proyecto.model.GamaProducto;
import com.jpa.proyecto.service.GamaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gamaproductos")
public class GamaProductoController {

    @Autowired
    private GamaProductoService gamaProductoService;

    @PostMapping
    public ResponseEntity<GamaProducto> crearGamaProducto(@RequestBody GamaProducto gamaProducto) {
        GamaProducto nuevoGamaProducto = gamaProductoService.crearGamaProducto(gamaProducto);
        return ResponseEntity.ok(nuevoGamaProducto);
    }

    @GetMapping
    public ResponseEntity<List<GamaProducto>> obtenerGamasProductos() {
        List<GamaProducto> gamasProductos = gamaProductoService.obtenerGamasProductos();
        return ResponseEntity.ok(gamasProductos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GamaProducto> obtenerGamaProductoPorId(@PathVariable String id) {
        Optional<GamaProducto> gamaProducto = gamaProductoService.obtenerGamaProductoPorId(id);
        return gamaProducto.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GamaProducto> actualizarGamaProducto(@PathVariable String id, @RequestBody GamaProducto gamaProductoDetalles) {
        GamaProducto gamaProductoActualizado = gamaProductoService.actualizarGamaProducto(id, gamaProductoDetalles);
        if (gamaProductoActualizado != null) {
            return ResponseEntity.ok(gamaProductoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGamaProducto(@PathVariable String id) {
        if (gamaProductoService.obtenerGamaProductoPorId(id).isPresent()) {
            gamaProductoService.eliminarGamaProducto(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}