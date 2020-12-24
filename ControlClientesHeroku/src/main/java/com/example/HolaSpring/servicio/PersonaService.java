package com.example.HolaSpring.servicio;

import com.example.HolaSpring.domain.Persona;
import java.util.List;

public interface PersonaService {

	public List<Persona> listarpersonas();

	public void guardar(Persona persona);

	public void eliminar(Persona persona);

	public Persona findById(Long id);

}
