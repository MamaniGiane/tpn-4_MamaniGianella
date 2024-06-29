package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.alumno;


public class ListadoAlumnos {

		public static List<alumno> alumnos = new ArrayList<alumno>();
	
		// Listar alumno
		  public static List<alumno> listarAlumnos() {
		    return alumnos;
		  }

		  // Buscar alumno por LU
		  public static alumno buscarAlumnoPorLU(String LU) {
		    for (alumno a : alumnos) {
		      if (a.getLU().equals(LU)) {
		        return a;
		      }
		    }
		    return null;
		  }

		  // agregar alumno
		  public static void agregarAlumno(alumno d) {
		    alumnos.add(d);
		  }

		  // modificar alumno
		  public static void modificarAlumno(alumno alumnoModificado) {
		    for (int i = 0; i < alumnos.size(); i++) {
		      alumno alumno = alumnos.get(i);
		      if (alumno.getLU().equals(alumnoModificado.getLU())) {
		        alumnos.set(i, alumnoModificado);
		        break;
		      }
		    }
		  }

		  // eliminar alumno
		  public static void eliminarAlumno(String LU) {
		    alumnos.removeIf(alumno -> alumno.getLU().equals(LU));
		  }
	
	
}
