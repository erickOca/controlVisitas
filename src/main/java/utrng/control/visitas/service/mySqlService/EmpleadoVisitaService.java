package utrng.control.visitas.service.mySqlService;


import utrng.control.visitas.util.EntradaRequest;

import java.util.Date;

public interface EmpleadoVisitaService {

     void registroEntraEmpleado(EntradaRequest request);
     long visitasEmpleado(Date fechaInicio, Date fechaFin);
}
