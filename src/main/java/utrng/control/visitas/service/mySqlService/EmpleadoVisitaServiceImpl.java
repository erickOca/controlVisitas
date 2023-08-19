package utrng.control.visitas.service.mySqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utrng.control.visitas.model.entity.mysql.EmpleadoVisita;
import utrng.control.visitas.model.entity.mysql.ExternoVisita;
import utrng.control.visitas.model.repository.mysqlRepository.EmpleadoVisitaRepository;
import utrng.control.visitas.util.EmpleadoRequest;

import java.util.Date;

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

}
