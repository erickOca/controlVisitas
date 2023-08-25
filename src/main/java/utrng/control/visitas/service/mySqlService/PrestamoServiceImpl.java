package utrng.control.visitas.service.mySqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import utrng.control.visitas.model.entity.mysql.Libro;
import utrng.control.visitas.model.entity.mysql.Prestamo;
import utrng.control.visitas.model.entity.sqlserver.Alumno;
import utrng.control.visitas.model.repository.mysqlRepository.LibroRepository;
import utrng.control.visitas.model.repository.mysqlRepository.PrestamoRepository;
import utrng.control.visitas.model.repository.sqlRepository.AlumnoRepository;
import utrng.control.visitas.util.PrestamoRequest;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoRepository prestamoRepository;

    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    LibroRepository libroRepository;

    @Override
    public List<Prestamo> todosLosPrestamos() {
        List<Prestamo> prestamoList = prestamoRepository.findAll();

        return prestamoList;
    }

    @Override
    public Prestamo nuevoPrestamo(PrestamoRequest prestamoRequest) {
        Libro libro =  libroRepository.findByTitulo(prestamoRequest.getTituloLibro());

        if (libro.getStatus() != 1) {
            throw new IllegalStateException("Book is not available for loan");
        }

        libro.setStatus((byte) 0);
        libroRepository.save(libro);

        Prestamo prestamo = new Prestamo();
        prestamo.setNombre(prestamoRequest.getNombre());
        prestamo.setMatriculaEst(prestamoRequest.getMatriculaEst());
        prestamo.setFechaPrestamo(LocalDate.now());

        // Calculate return date as 15 days after the loan issuance
        prestamo.setFechaDevolucion(prestamo.getFechaPrestamo().plusDays(15));

        prestamo.setLibro(libro);
        prestamo.setEmpleadoPresta(prestamoRequest.getEmpleadoPresta());

        return prestamoRepository.save(prestamo);
    }


    @Override
    public List<Prestamo> buscarPorMatricula(String matricula) {
        Alumno alumno = alumnoRepository.findAlumnoByMatricula(matricula);
        List<Prestamo> prestamos = prestamoRepository.findByMatriculaEst(matricula);
        List<Prestamo> prestamosPendientes = new ArrayList<>();

        if (alumno != null) {
            for (Prestamo prestamo : prestamos) {
                if (prestamo.getFechaDevolucion() == null) {
                    prestamosPendientes.add(prestamo);
                }
            }
        }

        return prestamosPendientes;
    }

    @Override
    public Prestamo devolucionDePrestamo(int idPrestamo) {
        Optional<Prestamo> optionalPrestamo = prestamoRepository.findById(idPrestamo);
        LocalDate fechaDevolucion = LocalDate.now(); // Obtén la fecha actual
        if (optionalPrestamo.isPresent()) {
            Prestamo prestamo = optionalPrestamo.get();
            prestamo.setFechaDevolucion(fechaDevolucion);

            Libro libro = prestamo.getLibro(); // Obtiene el libro del préstamo
            libro.setStatus((byte) 1); // Actualiza el estado del libro (supongo que 1 representa "devuelto")

            prestamoRepository.save(prestamo);
            libroRepository.save(libro);

            return prestamo;
        } else {
            // Manejar el caso en que no se encuentre el préstamo con el ID dado
            throw new IllegalArgumentException("No se encontró ningún préstamo con el ID proporcionado.");
        }
    }


    @Override
    public List<Prestamo> todosLosPrestamosPorDevolver() {
        List<Prestamo> prestamoList = prestamoRepository.findAll();
        List<Prestamo> prestamosPendientes =  new ArrayList<>();
        for (Prestamo prestamo : prestamoList) {
            if (prestamo.getFechaDevolucion() == null) {
                prestamosPendientes.add(prestamo);
            }
        }
        return prestamosPendientes;
    }

    @Override
    public List<Prestamo> buscarPorNumEmpleado(String nombreEmpleado) {
        List<Prestamo> prestamoList = prestamoRepository.findByNombre(nombreEmpleado);

        return prestamoList;
    }
    public void eliminarPrestamo(Integer idPrestamo) {
        Prestamo prestamo = prestamoRepository.findById(idPrestamo)
                .orElseThrow(() -> new NotFoundException("Prestamo no encontrado"));

        prestamoRepository.delete(prestamo);

        // Cambiar el estado del libro a disponible (status = 1)
        Libro libro = prestamo.getLibro();
        libro.setStatus((byte) 1);
        libroRepository.save(libro);
    }
}
