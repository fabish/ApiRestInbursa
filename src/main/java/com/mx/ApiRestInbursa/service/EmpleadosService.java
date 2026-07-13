package com.mx.ApiRestInbursa.service;

import java.util.List;

import com.mx.ApiRestInbursa.entity.Empleados;

public interface EmpleadosService {
	
    List<Empleados> mostrar();

    String guardar(Empleados empleado);

    Empleados buscar(Integer id);

    String editar(Empleados empleado);

    String eliminar(Integer id);

}
