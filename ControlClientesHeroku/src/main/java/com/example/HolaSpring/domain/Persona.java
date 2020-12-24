package com.example.HolaSpring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "personas")
public class Persona implements Serializable, Comparable<Persona> {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	@Email
	private String email;
	private String telefono;
	@NotNull
	private Double saldo;

	@Override
	public int compareTo(Persona o) {
		int salida;
		if (o.getNombre().compareToIgnoreCase(this.nombre) == 0) {
			if (o.getApellido().compareToIgnoreCase(this.apellido) > 0) {
				salida = -1;
			} else if (o.getApellido().compareToIgnoreCase(this.apellido) < 0) {
				salida = 1;
			} else {
				salida = 0;
			}
		}
		if (o.getNombre().compareToIgnoreCase(this.nombre) > 0) {
			salida = -1;
		} else {
			salida = 1;
		}
		return salida;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
