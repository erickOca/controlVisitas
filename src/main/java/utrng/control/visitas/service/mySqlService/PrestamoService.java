package utrng.control.visitas.service.mySqlService;

import utrng.control.visitas.model.entity.mysql.Prestamo;
import utrng.control.visitas.util.PrestamoRequest;

import java.time.LocalDate;
import java.util.List;

public interface PrestamoService {
    public List<Prestamo> todosLosPrestamos();

    public Prestamo nuevoPrestamo(PrestamoRequest prestamoRequest);

    public List<Prestamo> buscarPorMatricula(String Matricula);

    public Prestamo devolucionDePrestamo(int idPrestamo, LocalDate fechaDevolucion);

    public List<Prestamo> todosLosPrestamosPorDevolver();

    public List<Prestamo> buscarPorNumEmpleado(String numEmpleado);
}
