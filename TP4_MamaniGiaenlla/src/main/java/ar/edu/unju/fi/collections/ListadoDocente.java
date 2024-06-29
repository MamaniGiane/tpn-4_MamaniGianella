package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.docente;


public class ListadoDocente {
	
	public static List<docente> docentes = new ArrayList<docente>();
	
	// Listar docentes
		  public static List<docente> listarDocentes() {
		    return docentes;
		  }

		  // Buscar docente por legajo
		  public static docente buscarDocentePorLegajo(String leg) {
		    for (docente d : docentes) {
		      if (d.getLegajo().equals(leg)) {
		        return d;
		      }
		    }
		    return null;
		  }

		  // agregar docente
		  public static void agregarDocente(docente d) {
			//estado
			d.setEstado(true);
		    docentes.add(d);
		  }

		  // modificar docente
		  public static void modificarDocente(docente docenteModificado) {
		    for (int i = 0; i < docentes.size(); i++) {
		      docente docente = docentes.get(i);
		      if (docente.getLegajo().equals(docenteModificado.getLegajo())) {
		        docentes.set(i, docenteModificado);
		        break;
		      }
		    }
		  }

		  // eliminar docente
		  public static void eliminarDocente(String legajo) {
		    docentes.removeIf(docente -> docente.getLegajo().equals(legajo));
		  }
}
