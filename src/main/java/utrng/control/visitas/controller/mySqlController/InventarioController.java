package utrng.control.visitas.controller.mySqlController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utrng.control.visitas.model.entity.mysql.InventarioLibros;
import utrng.control.visitas.model.repository.mysqlRepository.InventarioLibrosRepository;

import java.util.List;

@RestController
@RequestMapping("/libros")
@CrossOrigin("*")
public class InventarioController {

    @Autowired
    private InventarioLibrosRepository libroRepository;

    @GetMapping
    public List<InventarioLibros> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

   @GetMapping("/buscar")
    public List<InventarioLibros> buscarLibrosPorNombre(@RequestParam String Titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(Titulo);
    }
}
