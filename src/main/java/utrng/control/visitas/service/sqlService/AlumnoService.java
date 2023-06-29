package utrng.control.visitas.service.sqlService;

import utrng.control.visitas.model.entity.sqlserver.Alumno;

import java.util.Date;

public interface AlumnoService {

Alumno findByAlumno(String matriculaAlumno);

long visitasAlumno(Date fechaInicio, Date fechaFin);
}
