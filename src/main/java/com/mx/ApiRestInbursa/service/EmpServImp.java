package com.mx.ApiRestInbursa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestInbursa.entity.Departamentos;
import com.mx.ApiRestInbursa.entity.Empleados;
import com.mx.ApiRestInbursa.repository.DepartamentosRepository;
import com.mx.ApiRestInbursa.repository.EmpleadosRepository;

@Service
public class EmpServImp implements EmpleadosService{
	
	@Autowired
	private EmpleadosRepository empleadosRepository;
	
	@Autowired
	private DepartamentosRepository departamentosRepository;
	
	@Transactional
	@Override
	public String guardar(Empleados empleado) {

	    Empleados empId=
	            empleadosRepository.findById(empleado.getIdEmpleado()).orElse(null);

	    Empleados empNombre=
	            empleadosRepository.findByNombreAndApp(
	                    empleado.getNombre(),
	                    empleado.getApp());

	    Departamentos dep=
	            departamentosRepository.findById(
	                    empleado.getDepartamento().getIdDepartamento())
	                    .orElse(null);

	    if(empId!=null) {

	        return "idExiste";

	    }

	    if(empNombre!=null) {

	        return "nombreExiste";

	    }

	    if(dep==null) {

	        return "departamentoNoExiste";

	    }

	    empleado.setDepartamento(dep);

	    empleadosRepository.save(empleado);

	    return "guardado";

	}
	
	@Transactional
	@Override
	public String editar(Empleados empleado) {

	    Empleados emp=
	            empleadosRepository.findById(empleado.getIdEmpleado()).orElse(null);

	    if(emp==null) {

	        return "empleadoNoExiste";

	    }

	    Departamentos dep=
	            departamentosRepository.findById(
	                    empleado.getDepartamento().getIdDepartamento())
	                    .orElse(null);

	    if(dep==null) {

	        return "departamentoNoExiste";

	    }

	    empleado.setDepartamento(dep);

	    empleadosRepository.save(empleado);

	    return "editado";

	}
	
	@Override
	public String eliminar(Integer id) {

	    Empleados emp=
	            empleadosRepository.findById(id).orElse(null);

	    if(emp==null) {

	        return "noExiste";

	    }

	    empleadosRepository.deleteById(id);

	    return "eliminado";

	}

	@Override
	public List<Empleados> mostrar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleados buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
