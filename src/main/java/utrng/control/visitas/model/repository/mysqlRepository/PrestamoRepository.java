package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utrng.control.visitas.model.entity.mysql.Libro;
import utrng.control.visitas.model.entity.mysql.Prestamo;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo,Integer> {

    List<Prestamo> findByNombreEmpleado(String nombreEmpleado);

    @Query("SELECT p FROM Prestamo p WHERE p.matriculaEst = :matricula")
    List<Prestamo> findByMatriculaEst(@Param("matricula") String matricula);

}
