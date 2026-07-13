package com.mx.ApiRestInbursa.service;

import java.util.List;

import com.mx.ApiRestInbursa.entity.Departamentos;

public interface DepartamentosService {
	
    List<Departamentos> mostrar();

    String guardar(Departamentos departamento);

    Departamentos buscar(Integer id);

    String editar(Departamentos departamento);

    String eliminar(Integer id);

}
