package com.jpa.proyecto.controllers;

import com.jpa.proyecto.model.Producto;
import com.jpa.proyecto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.crearProducto(producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerProductos() {
        List<Producto> productos = productoService.obtenerProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{codigoProducto}")
    public ResponseEntity<Producto> obtenerProductoPorCodigo(@PathVariable String codigoProducto) {
        Optional<Producto> producto = productoService.obtenerProductoPorCodigo(codigoProducto);
        return producto.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{codigoProducto}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable String codigoProducto, @RequestBody Producto productoDetalles) {
        Producto productoActualizado = productoService.actualizarProducto(codigoProducto, productoDetalles);
        if (productoActualizado != null) {
            return ResponseEntity.ok(productoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigoProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable String codigoProducto) {
        if (productoService.obtenerProductoPorCodigo(codigoProducto).isPresent()) {
            productoService.eliminarProducto(codigoProducto);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
