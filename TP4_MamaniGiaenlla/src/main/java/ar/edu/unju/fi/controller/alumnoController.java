package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.model.alumno;

@Controller
public class alumnoController {

	
	@Autowired
	alumno nuevoAlumno = new alumno();
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		//vista formAlumno.html
		ModelAndView modelView = new ModelAndView("formAlumno");
		
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		
		return modelView;
	}
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") alumno alumnoparaGuardar) {
		
		//guardar
		ListadoAlumnos.agregarAlumno(alumnoparaGuardar);
		
		//mostrar listado
		ModelAndView modelView = new ModelAndView("listadoDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());
		return modelView;
	}
	
	@GetMapping("/borrarAlumno/{LU}")
	public ModelAndView deleteAlumnoDelListado(@PathVariable(name="LU") String LU) {
		//borrar
		ListadoAlumnos.eliminarAlumno(LU);
		
		//nuevo listado
		ModelAndView modelView = new ModelAndView("listadoDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarAlumnos/{LU}")
	public ModelAndView editAlumno(@PathVariable(name="LU") String LU) {
		//buscar
		alumno alumnoParaModificar = ListadoAlumnos.buscarAlumnoPorLU(LU);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", alumnoParaModificar);	
		modelView.addObject("band", true);
		return modelView;		
		}
	
	@PostMapping("/modificarAlumno")
	public ModelAndView updateAlumno(@ModelAttribute("nuevoAlumno") alumno alumnoModificado) {
					
		//guardar
		ListadoAlumnos.modificarAlumno(alumnoModificado);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
		
		return modelView;		
	}
}
