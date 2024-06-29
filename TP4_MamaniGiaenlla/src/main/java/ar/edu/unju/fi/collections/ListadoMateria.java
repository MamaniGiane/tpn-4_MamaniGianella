package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.materia;

public class ListadoMateria {

	
public static List<materia> materias = new ArrayList<materia>();
	
	// Listar materias
		  public static List<materia> listarMateria() {
		    return materias;
		  }

		  // Buscar materia
		  public static materia buscarMateria(String codigo) {
		    for (materia m : materias) {
		      if (m.getCodigo().equals(codigo)) {
		        return m;
		      }
		    }
		    return null;
		  }

		  // agregar materia
		  public static void agregarMateria(materia m) {
			// estado
			m.setEstado(true);
		    materias.add(m);
		  }

		  // modificar materia
		  public static void modificarMateria(materia materiaModificada) {
		    for (int i = 0; i < materias.size(); i++) {
		      materia materia = materias.get(i);
		      if (materia.getCodigo().equals(materiaModificada.getCodigo())) {
		        materias.set(i, materiaModificada);
		        break;
		      }
		    }
		  }

		  // eliminar materia
		  public static void eliminarMateria(String codigo) {
		    materias.removeIf(materia -> materia.getCodigo().equals(codigo));
		  }
}
