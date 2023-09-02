package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.TO.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public void guardar(EstudianteTO estudianteTO) {
		// TODO Auto-generated method stub
		this.estudianteRepo.create(this.convertirEstudiante(estudianteTO));
	}
	
	private Estudiante convertirEstudiante(EstudianteTO estudianteTO) {
		Estudiante estu=new Estudiante();
		estu.setApellido(estudianteTO.getApellido());
		estu.setCedula(estudianteTO.getCedula());
		estu.setId(estudianteTO.getId());
		estu.setNombre(estudianteTO.getNombre());
		return estu;
	}

}
