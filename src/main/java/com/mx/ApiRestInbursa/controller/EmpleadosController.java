package com.mx.ApiRestInbursa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestInbursa.entity.Empleados;
import com.mx.ApiRestInbursa.service.EmpServImp;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {
	
	@Autowired
	private EmpServImp empleadoServImp;
	
	 @GetMapping("/mostrar")
	    public List<Empleados> mostrar(){

	        return empleadoServImp.mostrar();

	    }

	    @PostMapping("/guardar")
	    public ResponseEntity<?> guardar(@RequestBody Empleados empleado){

	        String respuesta=empleadoServImp.guardar(empleado);

	        if(respuesta.equals("idExiste")) {

	            return new ResponseEntity<>("El id ya existe",HttpStatus.OK);

	        }

	        if(respuesta.equals("nombreExiste")) {

	            return new ResponseEntity<>("El empleado ya existe",HttpStatus.OK);

	        }

	        if(respuesta.equals("departamentoNoExiste")) {

	            return new ResponseEntity<>("El departamento no existe",HttpStatus.OK);

	        }

	        return new ResponseEntity<>("Guardado correctamente",HttpStatus.CREATED);

	    }

}
