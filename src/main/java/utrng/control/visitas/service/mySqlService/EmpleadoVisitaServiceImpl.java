package utrng.control.visitas.service.mySqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utrng.control.visitas.model.entity.mysql.Empleado;
import utrng.control.visitas.model.entity.mysql.EmpleadoVisita;
import utrng.control.visitas.model.repository.mysqlRepository.EmpleadoRepository;
import utrng.control.visitas.model.repository.mysqlRepository.EmpleadoVisitaRepository;
import utrng.control.visitas.util.EntradaRequest;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class EmpleadoVisitaServiceImpl implements EmpleadoVisitaService {

    @Autowired
    EmpleadoVisitaRepository ingresosEmpleadoRepository;
    @Autowired
    EmpleadoRepository empleadoRepository;
    @Override
    public void registroEntraEmpleado(EntradaRequest request) {
       Empleado byNumEmpleado = empleadoRepository.findByNumEmpleado(request.getNumEmpleado());

        Date fecha = new Date();
        if (notnull(byNumEmpleado, fecha,request.getAreaVisitada())){
            EmpleadoVisita empleado = new EmpleadoVisita(byNumEmpleado, fecha , request.getAreaVisitada(), request.getMotivo());
            ingresosEmpleadoRepository.save(empleado);
            System.out.println("Se registro nueva visita " + empleado.toString());
        }else{
            System.out.println("No se pudo registrar visita");
        }


    }

    @Override
    public long visitasEmpleado(Date fechaInicio, Date fechaFin) {
        long a = ingresosEmpleadoRepository.countByOpcionWhereFecha(fechaInicio, fechaFin);
        System.out.println("El numero de empleados son: " + a);

        return a;
    }


    public boolean notnull(Empleado empleado, Date fecha, String areaVisitada){
        if (empleado == null){
            return false;
        }
        if (fecha == null){
            return false;
        }
        if (areaVisitada == null){
            return false;
        }
        return true;
    }
}
