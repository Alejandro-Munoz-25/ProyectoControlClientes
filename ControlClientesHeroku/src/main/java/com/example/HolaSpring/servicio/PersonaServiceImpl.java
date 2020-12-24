package com.example.HolaSpring.servicio;

import com.example.HolaSpring.dao.PersonaDAO;
import com.example.HolaSpring.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO personaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> listarpersonas() {
		return (List<Persona>) personaDAO.findAll();
	}

	@Override
	@Transactional
	public void guardar(Persona persona) {
		personaDAO.save(persona);
	}

	@Override
	@Transactional
	public void eliminar(Persona persona) {
		personaDAO.delete(persona);
	}

	@Override
	@Transactional(readOnly = true) 
	public Persona findById(Long id) {
		return personaDAO.findById(id).orElse(null);
	}

}
