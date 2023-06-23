package utrng.control.visitas.service.mySqlService;

import utrng.control.visitas.model.entity.mysql.Externovisita;
import utrng.control.visitas.util.ExternoRequest;

public interface ExternoService {

    public Externovisita saveExterno(ExternoRequest request);

    public Externovisita findAllInstitucion();
}
