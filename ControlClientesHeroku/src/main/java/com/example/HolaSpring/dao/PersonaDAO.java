package com.example.HolaSpring.dao;

import com.example.HolaSpring.domain.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDAO extends CrudRepository<Persona, Long> {

	@Query("FROM Persona ORDER BY nombre DESC")
    List<Persona> ordenNombreDes();
    
    @Query("FROM Persona ORDER BY nombre ASC")
    List<Persona> ordenNombreAsc();
    
    @Query(value = "SELECT * FROM personas ORDER BY apellido",nativeQuery = true)
    List<Persona> ordenApellidoAsc();
}
