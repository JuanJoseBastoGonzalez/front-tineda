package com.example.demo.service;

import java.util.*;

import com.example.demo.model.Empleado;

public interface EmpleadoService {
    Optional<Empleado> findById(Integer codigoEmpleado);
    List<Empleado> findAll();
    Empleado save(Empleado empleado);
    Optional<Empleado> deleteById(Integer codigoEmpleado);
    Optional<Empleado> update(Integer codigoEmpleado, Empleado empleado);
}
