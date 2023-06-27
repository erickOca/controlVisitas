package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import utrng.control.visitas.model.entity.mysql.Alumnovisita;

import java.util.Date;

@Repository
public interface AlumnoVisitaRepository extends JpaRepository<Alumnovisita,Integer> {
    Long countByOpcion(String opcion);

  /*  @Query("SELECT c FROM Alumnovisita c WHERE c.fecha BETWEEN :fechaInicio AND :fechaFin")
    Long countByOpcionWhereFecha(String opcion, Date fechaInicio, Date fechaFin);

   */

}
