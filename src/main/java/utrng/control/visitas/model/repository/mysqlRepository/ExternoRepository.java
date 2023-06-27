package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import utrng.control.visitas.model.entity.mysql.Externovisita;

import java.util.Date;

@Repository
public interface ExternoRepository extends JpaRepository<Externovisita, Integer> {

    Long countByOpcion(String opcion);

  /*  @Query("SELECT c FROM Externovisita c WHERE c.fecha BETWEEN :fechaInicio AND :fechaFin")
    Long countByOpcionWhereFecha(String opcion, Date fechaInicio, Date fechaFin);
   */
}
