package com.jpa.proyecto.controllers;



import com.jpa.proyecto.model.Empleado;
import com.jpa.proyecto.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = empleadoService.crearEmpleado(empleado);
        return ResponseEntity.ok(nuevoEmpleado);
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> obtenerEmpleados() {
        List<Empleado> empleados = empleadoService.obtenerEmpleados();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{codigoEmpleado}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorCodigo(@PathVariable Integer codigoEmpleado) {
        Optional<Empleado> empleado = empleadoService.obtenerEmpleadoPorCodigo(codigoEmpleado);
        return empleado.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{codigoEmpleado}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer codigoEmpleado, @RequestBody Empleado empleadoDetalles) {
        Empleado empleadoActualizado = empleadoService.actualizarEmpleado(codigoEmpleado, empleadoDetalles);
        if (empleadoActualizado != null) {
            return ResponseEntity.ok(empleadoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigoEmpleado}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Integer codigoEmpleado) {
        if (empleadoService.obtenerEmpleadoPorCodigo(codigoEmpleado).isPresent()) {
            empleadoService.eliminarEmpleado(codigoEmpleado);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
