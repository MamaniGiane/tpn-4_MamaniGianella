package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.carrera;

public class ListadoCarrera {
	
	public static List<carrera> carreras = new ArrayList<carrera>();
	
	// Listar carreras
		  public static List<carrera> listarCarreras() {
		    return carreras;
		  }

		  // buscar carrera por codigo
		  public static carrera buscarCarreraCodigo(String cod) {
		    for (carrera c : carreras) {
		      if (c.getCodigo().equals(cod)) {
		        return c;
		      }
		    }
		    return null;
		  }

		  // agregar carrera
		  public static void agregarCarrera(carrera c) {
			//estado
			c.setEstado(true);
		    carreras.add(c);
		  }

		  // modificar carrera
		  public static void modificarCarrera(carrera carreraModificada) {
		    for (int i = 0; i < carreras.size(); i++) {
		      carrera carrera = carreras.get(i);
		      if (carrera.getCodigo().equals(carreraModificada.getCodigo())) {
		        carreras.set(i, carreraModificada);
		        break;
		      }
		    }
		  }

		  
		  // borrar carrera
		  public static void eliminarCarrera(String codigo) {
			  
			  carreras.removeIf(carrera -> carrera.getCodigo().equals(codigo));
		  }
}
