package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utrng.control.visitas.model.entity.mysql.Libro;
import utrng.control.visitas.model.entity.mysql.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo,Integer> {
}
