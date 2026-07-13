package com.mx.ApiRestInbursa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ApiRestInbursa.entity.Empleados;

public interface EmpleadosRepository extends JpaRepository<Empleados, Integer>{
	
	Empleados findByNombreAndApp(String nombre,String app);

}
