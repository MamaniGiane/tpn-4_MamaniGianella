package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoMateria;
import ar.edu.unju.fi.model.materia;

@Controller
public class materiaController {

	@Autowired
	materia nuevaMateria = new materia();
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		//vista formMateria.html
		ModelAndView modelView = new ModelAndView("formMateria");
		
		//agrega el objeto
		modelView.addObject("nuevaMateria", nuevaMateria);
		
		return modelView;
	}
	
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") materia materiaparaGuardar) {
		
		//guardar
		ListadoMateria.agregarMateria(materiaparaGuardar);
		
		//mostrar listado
		ModelAndView modelView = new ModelAndView("listadoDeCarreras");
		modelView.addObject("listadoMateria", ListadoMateria.listarMateria());
		return modelView;
	}
	
	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView deleteMateriaDelListado(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoMateria.eliminarMateria(codigo);
		
		//nuevo listado
		ModelAndView modelView = new ModelAndView("listadoDeMaterias");
		modelView.addObject("listadoMateria", ListadoMateria.listarMateria());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView editMateria(@PathVariable(name="codigo") String codigo) {
		//buscar
		materia materiaParaModificar = ListadoMateria.buscarMateria(codigo);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaMateria", materiaParaModificar);	
		modelView.addObject("band", true);
		return modelView;		
		}
	
	@PostMapping("/modificarMateria")
	public ModelAndView updateMateria(@ModelAttribute("nuevaMateria") materia materiaModificada) {
					
		//guardar
		ListadoMateria.modificarMateria(materiaModificada);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias", ListadoMateria.listarMateria());	
		
		return modelView;		
	}
}
