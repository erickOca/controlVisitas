package utrng.control.visitas.model.repository.sqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import utrng.control.visitas.model.entity.sqlserver.Alumno;
import utrng.control.visitas.model.entity.sqlserver.Persona;
import utrng.control.visitas.model.entity.sqlserver.TipoPersona;

public interface PersonaRepository extends JpaRepository<Persona,Integer > {
    Persona findByCvePersona(int cvePersona);
}
