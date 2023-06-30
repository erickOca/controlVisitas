package utrng.control.visitas.service.sqlService;

import utrng.control.visitas.model.entity.sqlserver.Alumno;
import utrng.control.visitas.util.response.CarreraResponse;
import utrng.control.visitas.util.response.NivelResponse;

import java.util.Date;
import java.util.List;

public interface AlumnoService {

Alumno findByAlumno(String matriculaAlumno);

long visitasAlumno(Date fechaInicio, Date fechaFin);


}
