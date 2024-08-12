package com.example.demo.controller;

import com.example.demo.model.Pago;
import com.example.demo.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoRepository pagoRepository;

    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pago getPagoById(@PathVariable Integer id) {
        return pagoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Pago createPago(@RequestBody Pago pago) {
        return pagoRepository.save(pago);
    }

    @PutMapping("/{id}")
    public Pago updatePago(@PathVariable Integer id, @RequestBody Pago pago) {
        if (pagoRepository.existsById(id)) {
            pago.setId(id);
            return pagoRepository.save(pago);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePago(@PathVariable Integer id) {
        pagoRepository.deleteById(id);
    }
}