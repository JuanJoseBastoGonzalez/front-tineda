package com.example.demo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.service.EmpleadoService;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    @Transactional
    @Override
    public List<Empleado> findAll() {
        return (List<Empleado>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Empleado> findById(Integer codigoEmpleado) {
        return repository.findById(codigoEmpleado);
    }

    @Transactional
    @Override
    public Empleado save(Empleado empleado) {
        return repository.save(empleado);
    }

    @Transactional
    @Override
    public Optional<Empleado> update(Integer codigoEmpleado, Empleado empleado) {
        Optional<Empleado> empleadoOpt = repository.findById(codigoEmpleado);
        if (empleadoOpt.isPresent()) {
            Empleado empleadoItem = empleadoOpt.orElseThrow();
            empleadoItem.setNombre(empleado.getNombre());
            empleadoItem.setApellido1(empleado.getApellido1());
            empleadoItem.setApellido2(empleado.getApellido2());
            empleadoItem.setExtension(empleado.getExtension());
            empleadoItem.setEmail(empleado.getEmail());
            empleadoItem.setCodigoOficina(empleado.getCodigoOficina());
            empleadoItem.setCodigoJefe(empleado.getCodigoJefe());
            empleadoItem.setPuesto(empleado.getPuesto());
            return Optional.of(repository.save(empleadoItem));
        }
        return empleadoOpt;
    }

    @Transactional
    @Override
    public Optional<Empleado> deleteById(Integer codigoEmpleado) {
        Optional<Empleado> empleadoOpt = repository.findById(codigoEmpleado);
        empleadoOpt.ifPresent(empleadoItem -> {
            repository.delete(empleadoItem);
        });
        return empleadoOpt;
    }
}
