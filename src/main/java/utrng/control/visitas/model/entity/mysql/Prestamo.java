package utrng.control.visitas.model.entity.mysql;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrestamo")
    private int idPrestamo;

    @Column(name = "matriculaEst")
    private String matriculaEst;

    @Column(name = "fechaPrestamo")
    private LocalDate fechaPrestamo;

    @Column(name = "fechaDevolucion")
    private LocalDate fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "idLibro")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "numEmpleado")
    private Empleado empleado;

    // Getters y setters
}
