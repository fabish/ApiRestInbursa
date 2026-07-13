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

import com.mx.ApiRestInbursa.entity.Departamentos;
import com.mx.ApiRestInbursa.service.DepServImp;

@RestController
@RequestMapping("/departamentos")
public class DepartamentosController {
	
	@Autowired
	private DepServImp departamentoServImp;
	
	 @GetMapping("/mostrar")
	    public List<Departamentos> mostrar(){

	        return departamentoServImp.mostrar();

	    }

	    @PostMapping("/guardar")
	    public ResponseEntity<?> guardar(@RequestBody Departamentos departamento){

	        String respuesta=departamentoServImp.guardar(departamento);

	        if(respuesta.equals("idExiste")) {

	            return new ResponseEntity<>("El id ya existe",HttpStatus.OK);

	        }

	        if(respuesta.equals("nombreExiste")) {

	            return new ResponseEntity<>("El nombre ya existe",HttpStatus.OK);

	        }

	        return new ResponseEntity<>("Guardado correctamente",HttpStatus.CREATED);

	    }
	

}
