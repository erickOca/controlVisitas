package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utrng.control.visitas.model.entity.mysql.Alumnovisita;
import utrng.control.visitas.util.response.CarreraResponse;

import java.util.Date;
import java.util.List;

@Repository
public interface AlumnoVisitaRepository extends JpaRepository<Alumnovisita,Integer> {
    Long countByOpcion(String opcion);

    @Query("SELECT a FROM Alumnovisita a WHERE a.fecha BETWEEN :fechaInicio AND :fechaFin")
    List<Alumnovisita> findByAllWhereFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query("SELECT COUNT(a) FROM Alumnovisita a WHERE a.fecha BETWEEN :fechaInicio AND :fechaFin")
    Integer countByOpcionWhereFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query("SELECT av.nombreCarrera, COUNT(av) FROM Alumnovisita av WHERE av.fecha BETWEEN :fechaInicio AND :fechaFin GROUP BY av.nombreCarrera")
    List<Object[]> countByNombreCarreraAndFechaBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Query("SELECT COUNT(av) FROM Alumnovisita av WHERE DAYOFWEEK(av.fecha) = 7")
    Long findVisitasByDayOfWeek();

    @Query("SELECT COUNT(av) FROM Alumnovisita av WHERE DAYOFWEEK(av.fecha) BETWEEN 2 AND 6")
    Long countVisitasByWeekdays();



}
