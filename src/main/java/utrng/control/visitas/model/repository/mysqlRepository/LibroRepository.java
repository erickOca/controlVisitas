package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import utrng.control.visitas.model.entity.mysql.Alumnovisita;
import utrng.control.visitas.model.entity.mysql.Libro;

public interface LibroRepository extends JpaRepository<Libro,Integer> {
}
