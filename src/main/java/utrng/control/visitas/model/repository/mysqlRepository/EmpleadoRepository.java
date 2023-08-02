package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utrng.control.visitas.model.entity.mysql.Alumnovisita;
import utrng.control.visitas.model.entity.mysql.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {

    Empleado findByNumEmpleado(String numEmpleado);

}
