package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarrera;
import ar.edu.unju.fi.model.carrera;

@Controller
public class carreraController {
	
	
	@Autowired
	carrera nuevaCarrera = new carrera();
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormcarrera() {
		//vista fomCarrera.html
		ModelAndView modelView = new ModelAndView("formCarrera");
		//agrega el objeto
		modelView.addObject("nuevaCarrera", nuevaCarrera);
		
		return modelView;
	}
	
	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") carrera carreraparaGuardar) {
		
		//guardar
		ListadoCarrera.agregarCarrera(carreraparaGuardar);
		
		//mostrar listado
		ModelAndView modelView = new ModelAndView("listadoDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarrera.listarCarreras());
		return modelView;
	}
	
	@GetMapping("/borrarCarrera/{codigo}")
	public ModelAndView deleteCarreraDelListado(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoCarrera.eliminarCarrera(codigo);
		
		//nuevo listado
		ModelAndView modelView = new ModelAndView("listadoDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarrera.listarCarreras());	
		
		return modelView;		
		}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView editCarrera(@PathVariable(name="codigo") String codigo) {
		//buscar
		carrera carreraParaModificar = ListadoCarrera.buscarCarreraCodigo(codigo);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", carreraParaModificar);	
		modelView.addObject("band", true);
		return modelView;		
		}
	
	@PostMapping("/modificarCarrera")
	public ModelAndView updateCarrera(@ModelAttribute("nuevaCarrera") carrera carreraModificada) {
					
		//guardar
		ListadoCarrera.modificarCarrera(carreraModificada);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarrera.listarCarreras());	
		
		return modelView;		
	}
}
