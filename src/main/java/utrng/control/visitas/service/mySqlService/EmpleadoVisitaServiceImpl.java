package utrng.control.visitas.service.mySqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utrng.control.visitas.model.entity.mysql.EmpleadoVisita;
import utrng.control.visitas.model.entity.mysql.ExternoVisita;
import utrng.control.visitas.model.repository.mysqlRepository.EmpleadoVisitaRepository;
import utrng.control.visitas.util.EmpleadoRequest;
import utrng.control.visitas.util.response.AreaPersonalResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmpleadoVisitaServiceImpl implements EmpleadoVisitaService {

    @Autowired
    EmpleadoVisitaRepository ingresosEmpleadoRepository;

    @Override
    public EmpleadoVisita registroEntraEmpleado(EmpleadoRequest request) {
        EmpleadoVisita empleadoVisita = new EmpleadoVisita();

        ExternoVisita externo = new ExternoVisita();
        Date fecha = new Date();

        empleadoVisita.setNombres(request.getNombres());
        empleadoVisita.setApellidos(request.getApellidos());
        empleadoVisita.setArea(request.getArea());
        empleadoVisita.setMotivo(request.getMotivo());
        empleadoVisita.setAreaVisitada(request.getAreaVisitada());
        empleadoVisita.setHoraEntrada(fecha);

        return ingresosEmpleadoRepository.save(empleadoVisita);
    }

    @Override
    public long visitasEmpleado(Date fechaInicio, Date fechaFin) {
        long a = ingresosEmpleadoRepository.countByOpcionWhereFecha(fechaInicio, fechaFin);
        System.out.println("El numero de empleados son: " + a);

        return a;
    }

    @Override
    public List<AreaPersonalResponse> contarPersonalArea(Date fechaInicio, Date fechaFin) {
        List<Object[]> results = ingresosEmpleadoRepository.countVisitasByAreaAndFecha(fechaInicio, fechaFin);

        List<AreaPersonalResponse> areaPersonalResponses = new ArrayList<>();
        long totalVisitas = 0;

        for (Object[] result : results) {
            String area = (String) result[0];
            Long count = (Long) result[1];

            AreaPersonalResponse response = new AreaPersonalResponse();
            response.setNombreArea(area);
            response.setVisitas(count);

            areaPersonalResponses.add(response);

            totalVisitas += count; // Agregar el valor al total de visitas
        }

        // Agregar la entrada para el total de visitas
        AreaPersonalResponse totalResponse = new AreaPersonalResponse();
        totalResponse.setNombreArea("Total");
        totalResponse.setVisitas(totalVisitas);
        areaPersonalResponses.add(totalResponse);

        return areaPersonalResponses;
    }

}
