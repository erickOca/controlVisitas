package utrng.control.visitas.service.mySqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utrng.control.visitas.model.entity.mysql.ExternoVisita;
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
    public ExternoVisita saveExterno(ExternoRequest request) {

    ExternoVisita externo = new ExternoVisita();
    Date fecha = new Date();

    externo.setNombreInstitucion(request.getNombreInstitucion());
    externo.setOpcion(request.getOpcion());
    externo.setMotivo(request.getMotivo());
    externo.setFecha(fecha);

        return externoRepository.save(externo);
    }

    @Override
    public ExternoVisita findAllInstitucion() {
        return null;
    }

    @Override
    public ExternoRespose ContarVisitasPorExternoInstitucion(Date fechaInicio, Date fechaFin) {
       // List<Object[]>
        List<Object[]> list = new ArrayList<>();

        list = externoRepository.countByNombreInstitucion(fechaInicio, fechaFin);
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


