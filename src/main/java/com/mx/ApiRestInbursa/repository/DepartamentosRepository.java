package com.mx.ApiRestInbursa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ApiRestInbursa.entity.Departamentos;

public interface DepartamentosRepository  extends JpaRepository<Departamentos, Integer>{
	
    Departamentos findByNombre(String nombre);

}
