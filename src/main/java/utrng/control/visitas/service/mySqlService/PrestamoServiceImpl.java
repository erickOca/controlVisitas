package utrng.control.visitas.service.mySqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utrng.control.visitas.model.entity.mysql.Empleado;
import utrng.control.visitas.model.entity.mysql.Libro;
import utrng.control.visitas.model.entity.mysql.Prestamo;
import utrng.control.visitas.model.entity.sqlserver.Alumno;
import utrng.control.visitas.model.repository.mysqlRepository.EmpleadoRepository;
import utrng.control.visitas.model.repository.mysqlRepository.LibroRepository;
import utrng.control.visitas.model.repository.mysqlRepository.PrestamoRepository;
import utrng.control.visitas.model.repository.sqlRepository.AlumnoRepository;
import utrng.control.visitas.util.PrestamoRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoRepository prestamoRepository;

    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    LibroRepository libroRepository;

    @Override
    public List<Prestamo> todosLosPrestamos() {
        List<Prestamo> prestamoList = prestamoRepository.findAll();

        return prestamoList;
    }

    @Override
    public Prestamo nuevoPrestamo(PrestamoRequest prestamoRequest) {
        Libro libro = libroRepository.findById(prestamoRequest.getIdLibro()).orElse(null);
        Empleado empleado = empleadoRepository.findByNumEmpleado(prestamoRequest.getNumEmpleado());
        Alumno alumno = alumnoRepository.findAlumnoByMatricula(prestamoRequest.getMatriculaEst());

        if (libro == null) {
            throw new IllegalArgumentException("Libro no encontrado");
        }

        if (alumno != null || empleado != null) {
            Prestamo prestamo = new Prestamo();
            prestamo.setFechaPrestamo(LocalDate.now()); // Establecer la fecha actual
            prestamo.setLibro(libro);

            if (alumno != null) {
                prestamo.setMatriculaEst(prestamoRequest.getMatriculaEst());
            } else if (empleado != null) {
                prestamo.setEmpleado(empleado);
            }

            prestamoRepository.save(prestamo);
            return prestamo;
        } else {
            throw new IllegalArgumentException("No se encontró ni alumno ni empleado");
        }
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
    public Prestamo devolucionDePrestamo(int idPrestamo, LocalDate fechaDevolucion) {
        Optional<Prestamo> optionalPrestamo = prestamoRepository.findById(idPrestamo);

        if (optionalPrestamo.isPresent()) {
            Prestamo prestamo = optionalPrestamo.get();
            prestamo.setFechaDevolucion(fechaDevolucion);

            // Realizar otras acciones necesarias

            prestamoRepository.save(prestamo);

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
    public List<Prestamo> buscarPorNumEmpleado(String numEmpleado) {
        List<Prestamo> prestamoList = prestamoRepository.findByEmpleado_NumEmpleado(numEmpleado);

        return prestamoList;
    }

}