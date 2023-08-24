package utrng.control.visitas.service.mySqlService;


import utrng.control.visitas.model.entity.mysql.EmpleadoVisita;
import utrng.control.visitas.util.EmpleadoRequest;
import utrng.control.visitas.util.response.AreaPersonalResponse;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmpleadoVisitaService {

     EmpleadoVisita registroEntraEmpleado(EmpleadoRequest request);
     long visitasEmpleado(Date fechaInicio, Date fechaFin);

     List<AreaPersonalResponse> contarPersonalArea(Date fechaInicio, Date fechaFin);
}
