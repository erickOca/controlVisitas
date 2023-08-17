package utrng.control.visitas.controller.mySqlController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utrng.control.visitas.model.entity.mysql.ExternoVisita;
import utrng.control.visitas.model.entity.mysql.Libro;
import utrng.control.visitas.model.repository.mysqlRepository.LibroRepository;
import utrng.control.visitas.service.mySqlService.ExternoService;
import utrng.control.visitas.service.mySqlService.LibroService;
import utrng.control.visitas.util.ExternoRequest;
import utrng.control.visitas.util.LibrosRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Libro")
@CrossOrigin(origins = "*")
public class LibrosController {



    @Autowired
    private LibroService libroService;

    @GetMapping("/listLibro")
    public ResponseEntity<List<Libro>> todosLosLibros() {
        List<Libro> libros = libroService.todosLosLibros();

        return new ResponseEntity<>(libros, HttpStatus.OK);
    }
    @PostMapping("/nuevolibro")
    public ResponseEntity<Libro> nuevoLibro(@RequestBody LibrosRequest librosRequest){
       Libro nuevoLibro = libroService.nuevoLibro(librosRequest);

        return new ResponseEntity<>(nuevoLibro, HttpStatus.OK);
    }

    @DeleteMapping("/borrarLibro")
    public ResponseEntity<Optional<Libro>>  borrarLibro(int idLibro){
        Optional<Libro> optionalLibro = libroService.borrarLibro(idLibro);

        return new ResponseEntity<>(optionalLibro, HttpStatus.OK);

    }
    @PutMapping("/actualizarlibro")
    public ResponseEntity<Libro> actualizarLibro( int idLibro, @RequestBody LibrosRequest request){
        Libro libro = libroService.actualizarLibro(idLibro, request);

        return new ResponseEntity<>(libro, HttpStatus.OK);

    }

}
