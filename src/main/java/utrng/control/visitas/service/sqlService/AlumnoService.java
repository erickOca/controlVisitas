package utrng.control.visitas.service.sqlService;

import utrng.control.visitas.model.entity.sqlserver.Alumno;

public interface AlumnoService {

Alumno findByAlumno(String matriculaAlumno);
}
