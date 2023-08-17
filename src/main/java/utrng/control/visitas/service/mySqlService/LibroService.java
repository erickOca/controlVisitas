package utrng.control.visitas.service.mySqlService;

import utrng.control.visitas.model.entity.mysql.Libro;
import utrng.control.visitas.util.LibrosRequest;

import java.util.List;
import java.util.Optional;

public interface LibroService {

    public Libro nuevoLibro(LibrosRequest request);

    public List<Libro> todosLosLibros();

    public Libro actualizarLibro(int idLibro, LibrosRequest request);

    public Optional<Libro> borrarLibro(int idLibro);
}
