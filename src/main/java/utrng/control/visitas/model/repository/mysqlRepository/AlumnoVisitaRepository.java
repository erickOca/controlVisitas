package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utrng.control.visitas.model.entity.mysql.Alumnovisita;

@Repository
public interface AlumnoVisitaRepository extends JpaRepository<Alumnovisita,Integer> {
    Long countByOpcion(String opcion);
}
