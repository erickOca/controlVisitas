package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import utrng.control.visitas.model.entity.mysql.Empleados;
import utrng.control.visitas.model.entity.mysql.IngresosBiblioteca;

public interface IngresosBibliotecaRepository extends JpaRepository<IngresosBiblioteca, Integer> {

}
