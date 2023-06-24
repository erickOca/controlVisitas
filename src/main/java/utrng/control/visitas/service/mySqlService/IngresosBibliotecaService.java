package utrng.control.visitas.service.mySqlService;

import org.springframework.beans.factory.annotation.Autowired;
import utrng.control.visitas.model.entity.mysql.Empleados;
import utrng.control.visitas.model.entity.mysql.IngresosBiblioteca;
import utrng.control.visitas.model.repository.mysqlRepository.IngresosBibliotecaRepository;

import java.sql.Timestamp;

public interface IngresosBibliotecaService {

    public IngresosBiblioteca ingresoBibliotecaEmpleago();

}
