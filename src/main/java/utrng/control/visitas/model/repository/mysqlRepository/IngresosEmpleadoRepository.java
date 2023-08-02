package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import utrng.control.visitas.model.entity.mysql.Empleadovisita;

import java.util.Date;

public interface IngresosEmpleadoRepository extends JpaRepository<Empleadovisita, Integer> {

    @Query("SELECT COUNT(a) FROM Empleadovisita a WHERE a.horaEntrada BETWEEN :fechaInicio AND :fechaFin")
    Integer countByOpcionWhereFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);



}
