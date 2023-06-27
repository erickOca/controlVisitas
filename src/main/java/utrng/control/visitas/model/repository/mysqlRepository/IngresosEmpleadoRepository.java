package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import utrng.control.visitas.model.entity.mysql.IngresosEmpleado;

import java.util.Date;

public interface IngresosEmpleadoRepository extends JpaRepository<IngresosEmpleado, Integer> {

  /*  @Query("SELECT c FROM IngresosEmpleado c WHERE c.horaEntrada BETWEEN :fechaInicio AND :fechaFin")
    Long countByOpcionWhereFecha(String opcion, Date fechaInicio, Date fechaFin);
   */
}
