package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class materia {
	
	private String codigo;
	private String nombre;
	private docente docente;
	private String curso;
	private int cantHoras;
	private String modalidad;
	private carrera carrera;
	private Boolean estado;
	
	public materia() {
		// TODO Auto-generated constructor stub
	}

	public materia(String codigo, String nombre, ar.edu.unju.fi.model.docente docente, String curso, int cantHoras,
			String modalidad, ar.edu.unju.fi.model.carrera carrera, Boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.docente = docente;
		this.curso = curso;
		this.cantHoras = cantHoras;
		this.modalidad = modalidad;
		this.carrera = carrera;
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

	public docente getDocente() {
		return docente;
	}

	public void setDocente(docente docente) {
		this.docente = docente;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(carrera carrera) {
		this.carrera = carrera;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
