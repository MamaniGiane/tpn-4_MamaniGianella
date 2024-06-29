package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocente;
import ar.edu.unju.fi.model.docente;

@Controller
public class docenteController {

	@Autowired
	docente nuevoDocente = new docente();
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		//vista formDocente.html
		ModelAndView modelView = new ModelAndView("formDocente");
		
		modelView.addObject("nuevoDocente", nuevoDocente);
		
		return modelView;
	}
	
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute("nuevoDocente") docente docenteparaGuardar) {
		
		//guardar
		ListadoDocente.agregarDocente(docenteparaGuardar);
		
		//mostrar listado
		ModelAndView modelView = new ModelAndView("listadoDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());
		return modelView;
	}
	
	@GetMapping("/borrarDocente/{legajo}")
	public ModelAndView deleteDocenteDelListado(@PathVariable(name="legajo") String legajo) {
		//borrar
		ListadoDocente.eliminarDocente(legajo);
		
		//nuevo listado
		ModelAndView modelView = new ModelAndView("listadoDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView editDocente(@PathVariable(name="legajo") String legajo) {
		//buscar
		docente docenteParaModificar = ListadoDocente.buscarDocentePorLegajo(legajo);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevoDocente", docenteParaModificar);	
		modelView.addObject("band", true);
		return modelView;		
		}
	
	@PostMapping("/modificarDocente")
	public ModelAndView updateDocente(@ModelAttribute("nuevoDocente") docente docenteModificado) {
					
		//guardar
		ListadoDocente.modificarDocente(docenteModificado);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentes());	
		
		return modelView;		
	}
}
