package com.jpa.proyecto.service;



import com.jpa.proyecto.model.Oficina;
import com.jpa.proyecto.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OficinaService {

    @Autowired
    private OficinaRepository oficinaRepository;

    public Oficina crearOficina(Oficina oficina) {
        return oficinaRepository.save(oficina);
    }

    public List<Oficina> obtenerOficinas() {
        return oficinaRepository.findAll();
    }

    public Optional<Oficina> obtenerOficinaPorCodigo(String codigoOficina) {
        return oficinaRepository.findById(codigoOficina);
    }

    public Oficina actualizarOficina(String codigoOficina, Oficina oficinaDetalles) {
        if (oficinaRepository.existsById(codigoOficina)) {
            oficinaDetalles.setCodigoOficina(codigoOficina);
            return oficinaRepository.save(oficinaDetalles);
        } else {
            return null; // O lanzar una excepción personalizada
        }
    }

    public void eliminarOficina(String codigoOficina) {
        oficinaRepository.deleteById(codigoOficina);
    }
}
