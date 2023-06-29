package utrng.control.visitas.service.mySqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utrng.control.visitas.model.entity.mysql.IngresosEmpleado;
import utrng.control.visitas.model.repository.mysqlRepository.IngresosEmpleadoRepository;
import utrng.control.visitas.util.EntradaRequest;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class IngresosEmpleadoServiceImpl implements IngresosEmpleadoService{

    @Autowired
    IngresosEmpleadoRepository ingresosEmpleadoRepository;
    @Override
    public void registroEntraEmpleado(EntradaRequest request) {
        if (notnull(request.getIdEmpleado(),request.getFechaEntrada(),request.getAreaVisitada())){
            IngresosEmpleado empleado = new IngresosEmpleado(request.getIdEmpleado(), request.getFechaEntrada(), request.getAreaVisitada(), request.getMotivo());
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


    public boolean notnull(Integer empleadoId, Timestamp hora, String areaVisitada){
        if (empleadoId == null){
            return false;
        }
        if (hora == null){
            return false;
        }
        if (areaVisitada == null){
            return false;
        }
        return true;
    }
}
