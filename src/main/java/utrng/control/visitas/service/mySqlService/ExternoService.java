package utrng.control.visitas.service.mySqlService;

import utrng.control.visitas.model.entity.mysql.Externovisita;
import utrng.control.visitas.util.ExternoRequest;
import utrng.control.visitas.util.response.ExternoRespose;

import java.util.Date;

public interface ExternoService {

    public Externovisita saveExterno(ExternoRequest request);

    public Externovisita findAllInstitucion();

    public ExternoRespose ContarVisitasPorExternoInstitucion(Date fechaInicio, Date fechaFin);
}
