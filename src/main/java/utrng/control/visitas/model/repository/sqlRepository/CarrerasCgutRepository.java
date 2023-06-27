package utrng.control.visitas.model.repository.sqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import utrng.control.visitas.model.entity.sqlserver.Alumno;
import utrng.control.visitas.model.entity.sqlserver.CarrerasCgut;

public interface CarrerasCgutRepository extends JpaRepository<CarrerasCgut,Integer > {

    CarrerasCgut findByNombre(String nombre);


}
