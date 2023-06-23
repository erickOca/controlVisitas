package utrng.control.visitas.model.repository.sqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utrng.control.visitas.model.entity.sqlserver.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer > {

    @Query("SELECT a, a.carrerasCgut FROM Alumno a JOIN FETCH a.carrerasCgut c WHERE a.matricula = :matriculaAlumno")
    Alumno findAlumnoByMatricula(@Param("matriculaAlumno") String matriculaAlumno);
}
