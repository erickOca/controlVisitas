package utrng.control.visitas.service.mySqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utrng.control.visitas.model.entity.mysql.Externovisita;
import utrng.control.visitas.model.repository.mysqlRepository.ExternoRepository;
import utrng.control.visitas.util.ExternoRequest;

import java.util.Date;

@Service
public class ExternoServiceImpl implements ExternoService{

    @Autowired
    private ExternoRepository externoRepository;

    @Override
    public Externovisita saveExterno(ExternoRequest request) {

    Externovisita externo = new Externovisita();
    Date fecha = new Date();

    externo.setNombreInstitucion(request.getNombreInstitucion());
    externo.setOpcion(request.getOpcion());
    externo.setMotivo(request.getMotivo());
    externo.setFecha(fecha);

        return externoRepository.save(externo);
    }

    @Override
    public Externovisita findAllInstitucion() {
        return null;
    }
}
