package utrng.control.visitas.model.repository.sqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import utrng.control.visitas.model.entity.sqlserver.CarrerasCgut;
import utrng.control.visitas.model.entity.sqlserver.Turno;

public interface TurnoRepository extends JpaRepository<Turno,Integer > {


    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Turno t WHERE t.descripcion LIKE %:descripcion%")
    boolean checkTurnoDescripcionContainsTSU(@Param("descripcion") String descripcion);


}
