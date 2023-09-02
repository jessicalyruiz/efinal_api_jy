package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IEstudianteService;
import com.example.demo.service.TO.EstudianteTO;

@RestController
@RequestMapping(path = "/estudiantes")
@CrossOrigin
public class EstudianteRestFullController {

	
	@Autowired
	private IEstudianteService estudianteService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardarEstu( EstudianteTO estudianteTO) {
		this.estudianteService.guardar(estudianteTO);
	}
	
}
