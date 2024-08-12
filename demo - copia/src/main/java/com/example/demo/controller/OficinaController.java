package com.example.demo.controller;

import com.example.demo.model.Oficina;
import com.example.demo.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oficinas")
public class OficinaController {

    @Autowired
    private OficinaRepository oficinaRepository;

    @GetMapping
    public List<Oficina> getAllOficinas() {
        return oficinaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Oficina getOficinaById(@PathVariable String id) {
        return oficinaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Oficina createOficina(@RequestBody Oficina oficina) {
        return oficinaRepository.save(oficina);
    }

    @PutMapping("/{id}")
    public Oficina updateOficina(@PathVariable String id, @RequestBody Oficina oficina) {
        if (oficinaRepository.existsById(id)) {
            oficina.setCodigoOficina(id);
            return oficinaRepository.save(oficina);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteOficina(@PathVariable String id) {
        oficinaRepository.deleteById(id);
    }
}