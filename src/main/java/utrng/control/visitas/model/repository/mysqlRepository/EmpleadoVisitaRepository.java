package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import utrng.control.visitas.model.entity.mysql.EmpleadoVisita;

import java.util.Date;

public interface EmpleadoVisitaRepository extends JpaRepository<EmpleadoVisita, Integer> {

    @Query("SELECT COUNT(a) FROM EmpleadoVisita a WHERE a.horaEntrada BETWEEN :fechaInicio AND :fechaFin")
    Integer countByOpcionWhereFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);



}
