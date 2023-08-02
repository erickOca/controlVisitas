package utrng.control.visitas.service.mySqlService;

import utrng.control.visitas.model.entity.mysql.ExternoVisita;
import utrng.control.visitas.util.ExternoRequest;
import utrng.control.visitas.util.response.ExternoRespose;

import java.util.Date;

public interface ExternoService {

    public ExternoVisita saveExterno(ExternoRequest request);

    public ExternoVisita findAllInstitucion();

    public ExternoRespose ContarVisitasPorExternoInstitucion(Date fechaInicio, Date fechaFin);
}
