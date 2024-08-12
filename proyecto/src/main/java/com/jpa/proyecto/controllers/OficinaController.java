package com.jpa.proyecto.controllers;


import com.jpa.proyecto.model.Oficina;
import com.jpa.proyecto.service.OficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/oficinas")
public class OficinaController {

    @Autowired
    private OficinaService oficinaService;

    @PostMapping
    public ResponseEntity<Oficina> crearOficina(@RequestBody Oficina oficina) {
        Oficina nuevaOficina = oficinaService.crearOficina(oficina);
        return ResponseEntity.ok(nuevaOficina);
    }

    @GetMapping
    public ResponseEntity<List<Oficina>> obtenerOficinas() {
        List<Oficina> oficinas = oficinaService.obtenerOficinas();
        return ResponseEntity.ok(oficinas);
    }

    @GetMapping("/{codigoOficina}")
    public ResponseEntity<Oficina> obtenerOficinaPorCodigo(@PathVariable String codigoOficina) {
        Optional<Oficina> oficina = oficinaService.obtenerOficinaPorCodigo(codigoOficina);
        return oficina.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{codigoOficina}")
    public ResponseEntity<Oficina> actualizarOficina(@PathVariable String codigoOficina, @RequestBody Oficina oficinaDetalles) {
        Oficina oficinaActualizada = oficinaService.actualizarOficina(codigoOficina, oficinaDetalles);
        if (oficinaActualizada != null) {
            return ResponseEntity.ok(oficinaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigoOficina}")
    public ResponseEntity<Void> eliminarOficina(@PathVariable String codigoOficina) {
        if (oficinaService.obtenerOficinaPorCodigo(codigoOficina).isPresent()) {
            oficinaService.eliminarOficina(codigoOficina);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
