package utrng.control.visitas.model.repository.mysqlRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import utrng.control.visitas.model.entity.mysql.InventarioLibros;

import java.util.List;

public interface InventarioLibrosRepository  extends JpaRepository<InventarioLibros, Long> {


    List<InventarioLibros> findByTituloContainingIgnoreCase(String Titulo);


}
