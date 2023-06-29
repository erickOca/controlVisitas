package utrng.control.visitas.service.mySqlService;


import utrng.control.visitas.util.EntradaRequest;

import java.sql.Timestamp;
import java.util.Date;

public interface IngresosEmpleadoService {

     void registroEntraEmpleado(EntradaRequest request);
     long visitasEmpleado(Date fechaInicio, Date fechaFin);
}
