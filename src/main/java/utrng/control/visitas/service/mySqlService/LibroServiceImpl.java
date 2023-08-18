package utrng.control.visitas.service.mySqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utrng.control.visitas.model.entity.mysql.Libro;
import utrng.control.visitas.model.repository.mysqlRepository.LibroRepository;
import utrng.control.visitas.util.LibrosRequest;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService{

    @Autowired
    LibroRepository libroRepository;

    @Override
    public Libro nuevoLibro(LibrosRequest request) {
        byte b = 1;
        Libro libro = new Libro(request.getTitulo(), request.getFechaIngreso(), request.getAutor(), request.getCategoria(),b);
        libroRepository.save(libro);
        return libro;
    }

    @Override
    public List<Libro> todosLosLibros() {
        List<Libro> libros = libroRepository.findAll();

        return libros;
    }
    @Override
    public Libro actualizarLibro(int idLibro,byte status, LibrosRequest request) {
        Optional<Libro> optionalLibro = libroRepository.findById(idLibro);
        Libro libro = new Libro();

        if (optionalLibro.isPresent()) {
            libro = optionalLibro.get();
            libro.setTitulo(request.getTitulo());
            libro.setFechaIngreso(request.getFechaIngreso());
            libro.setAutor(request.getAutor());
            libro.setCategoria(request.getCategoria());
            libro.setStatus(status);
            libroRepository.save(libro);

        } else {
            System.out.println("Libro no encontrado con ID: " + idLibro);
        }
        return libro;
    }

    @Override
    public Optional<Libro> borrarLibro(int idLibro) {
        Optional<Libro> optionalLibro = libroRepository.findById(idLibro);

        if (optionalLibro.isPresent()) {
            Libro libro = optionalLibro.get();
            libroRepository.delete(libro);
        } else {
            System.out.println("Libro no encontrado con ID: " + idLibro);
        }
        return optionalLibro;
    }


}
