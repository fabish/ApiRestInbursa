package com.mx.ApiRestInbursa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestInbursa.entity.Departamentos;
import com.mx.ApiRestInbursa.repository.DepartamentosRepository;


@Service
public class DepServImp implements DepartamentosService{
	@Autowired
	private DepartamentosRepository departamentosRepository;
	
	
	@Transactional(readOnly =  true)
	@Override
	public List<Departamentos> mostrar() {
	    return departamentosRepository.findAll();
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public Departamentos buscar(Integer id) {

	    return departamentosRepository.findById(id).orElse(null);

	}
	
	
	@Transactional
	@Override
	public String guardar(Departamentos departamento) {

	    Departamentos depId=
	            departamentosRepository.findById(departamento.getIdDepartamento()).orElse(null);

	    Departamentos depNombre=
	            departamentosRepository.findByNombre(departamento.getNombre());

	    if(depId!=null) {

	        return "idExiste";

	    }else if(depNombre!=null){

	        return "nombreExiste";

	    }

	    departamentosRepository.save(departamento);

	    return "guardado";

	}
	
	
	@Transactional
	@Override
	public String editar(Departamentos departamento) {

	    Departamentos dep=
	            departamentosRepository.findById(departamento.getIdDepartamento()).orElse(null);

	    if(dep==null) {

	        return "noExiste";

	    }

	    departamentosRepository.save(departamento);

	    return "editado";

	}
	
	@Override
	public String eliminar(Integer id) {

	    Departamentos dep=
	            departamentosRepository.findById(id).orElse(null);

	    if(dep==null) {

	        return "noExiste";

	    }

	    departamentosRepository.deleteById(id);

	    return "eliminado";

	}

}
