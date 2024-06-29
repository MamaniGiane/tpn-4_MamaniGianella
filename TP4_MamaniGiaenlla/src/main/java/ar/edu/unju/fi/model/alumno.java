package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class alumno {

	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	private LocalDate fecNac;
	private String domicilio;
	private String LU;
	private Boolean estado;
	
	
	public alumno() {
		// TODO Auto-generated constructor stub
	}


	public alumno(int dni, String nombre, String apellido, String email, int telefono, LocalDate fecNac,
			String domicilio, String LU, Boolean estado) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fecNac = fecNac;
		this.domicilio = domicilio;
		this.setLU(LU);
		this.estado = estado;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
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


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public LocalDate getFecNac() {
		return fecNac;
	}


	public void setFecNac(LocalDate fecNac) {
		this.fecNac = fecNac;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getLU() {
		return LU;
	}


	public void setLU(String lU) {
		LU = lU;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	
}