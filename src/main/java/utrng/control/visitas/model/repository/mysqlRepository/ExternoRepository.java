package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utrng.control.visitas.model.entity.mysql.Alumnovisita;
import utrng.control.visitas.model.entity.mysql.Externovisita;

import java.util.Date;
import java.util.List;

@Repository
public interface ExternoRepository extends JpaRepository<Externovisita, Integer> {

    Long countByOpcion(String opcion);

   @Query("SELECT COUNT(a) FROM Externovisita a WHERE a.fecha BETWEEN :fechaInicio AND :fechaFin")
    Integer countByOpcionWhereFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query("SELECT a.opcion, COUNT(*) AS cantidad FROM Externovisita a GROUP BY a.opcion")
    List<Object[]> countByOpcion();

    @Query("SELECT a.nombreInstitucion, COUNT(*) AS cantidad FROM Externovisita a GROUP BY a.nombreInstitucion")
    List<Object[]> countByNombreInstitucion();

}
