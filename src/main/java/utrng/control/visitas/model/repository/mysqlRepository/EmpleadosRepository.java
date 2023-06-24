package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import utrng.control.visitas.model.entity.mysql.Empleados;
import utrng.control.visitas.model.entity.mysql.Externovisita;

public interface EmpleadosRepository extends JpaRepository<Empleados, Integer> {

}
