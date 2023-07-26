package utrng.control.visitas.service.mySqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utrng.control.visitas.model.entity.mysql.Externovisita;
import utrng.control.visitas.model.repository.mysqlRepository.ExternoRepository;
import utrng.control.visitas.util.ExternoRequest;
import utrng.control.visitas.util.response.ExternoRespose;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public ExternoRespose ContarVisitasPorExternoInstitucion() {
       // List<Object[]>
        List<Object[]> list = new ArrayList<>();

        list = externoRepository.countByNombreInstitucion();
        Long total = 0l;
        for (Object[] result : list) {
            ExternoRespose externoRespose = new ExternoRespose();
            String opcion = (String) result[0];
            Long count = (Long) result[1];
            System.out.println("Opción: " + opcion + " - Count: " + count);
         //   externoRespose
            total += count;
        }
        System.out.println("Total es: " + total);
        return null;
    }
}


