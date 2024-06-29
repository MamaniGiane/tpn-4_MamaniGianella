package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class carrera {
	private String codigo;
	private String nombre;
	private Integer cantAnios;
	private Boolean estado;
	
	public carrera() {
		// TODO Auto-generated constructor stub
	}

	public carrera(String codigo, String nombre, Integer cantAnios, Boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantAnios = cantAnios;
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantAnios() {
		return cantAnios;
	}

	public void setCantAnios(Integer cantAnios) {
		this.cantAnios = cantAnios;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}