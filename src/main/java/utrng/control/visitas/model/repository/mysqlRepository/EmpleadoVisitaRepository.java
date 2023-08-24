package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utrng.control.visitas.model.entity.mysql.EmpleadoVisita;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface EmpleadoVisitaRepository extends JpaRepository<EmpleadoVisita, Integer> {

    @Query("SELECT COUNT(a) FROM EmpleadoVisita a WHERE a.horaEntrada BETWEEN :fechaInicio AND :fechaFin")
    Integer countByOpcionWhereFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query("SELECT ev.area, COUNT(ev) FROM EmpleadoVisita ev WHERE ev.horaEntrada BETWEEN :fechaInicio AND :fechaFin GROUP BY ev.area")
    List<Object[]> countVisitasByAreaAndFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);



}
