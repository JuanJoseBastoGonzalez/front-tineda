package com.jpa.proyecto.service;



import com.jpa.proyecto.model.Empleado;
import com.jpa.proyecto.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado crearEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public List<Empleado> obtenerEmpleados() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> obtenerEmpleadoPorCodigo(Integer codigoEmpleado) {
        return empleadoRepository.findById(codigoEmpleado);
    }

    public Empleado actualizarEmpleado(Integer codigoEmpleado, Empleado empleadoDetalles) {
        if (empleadoRepository.existsById(codigoEmpleado)) {
            empleadoDetalles.setCodigoEmpleado(codigoEmpleado);
            return empleadoRepository.save(empleadoDetalles);
        } else {
            return null; // O lanzar una excepción personalizada
        }
    }

    public void eliminarEmpleado(Integer codigoEmpleado) {
        empleadoRepository.deleteById(codigoEmpleado);
    }
}
