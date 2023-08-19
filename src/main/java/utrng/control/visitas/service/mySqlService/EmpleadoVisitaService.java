package utrng.control.visitas.service.mySqlService;


import utrng.control.visitas.model.entity.mysql.EmpleadoVisita;
import utrng.control.visitas.util.EmpleadoRequest;
import utrng.control.visitas.util.EntradaRequest;

import java.util.Date;

public interface EmpleadoVisitaService {

     EmpleadoVisita registroEntraEmpleado(EmpleadoRequest request);
     long visitasEmpleado(Date fechaInicio, Date fechaFin);
}
