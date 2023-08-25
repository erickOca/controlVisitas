package utrng.control.visitas.model.entity.mysql;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrestamo")
    private Integer idPrestamo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "matriculaEst")
    private String matriculaEst;

    @Column(name = "fechaPrestamo")
    private LocalDate fechaPrestamo;

    @Column(name = "fechaDevolucion")
    private LocalDate fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "idLibro")
    private Libro libro;

    @Column(name = "empleadoPresta")
    private String empleadoPresta;

    // Getters y setters

    public Prestamo() {
    }

    public Prestamo(Integer idPrestamo, String nombre, String matriculaEst, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Libro libro, String empleadoPresta) {
        this.idPrestamo = idPrestamo;
        this.nombre = nombre;
        this.matriculaEst = matriculaEst;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.empleadoPresta = empleadoPresta;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatriculaEst() {
        return matriculaEst;
    }

    public void setMatriculaEst(String matriculaEst) {
        this.matriculaEst = matriculaEst;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getEmpleadoPresta() {
        return empleadoPresta;
    }

    public void setEmpleadoPresta(String empleadoPresta) {
        this.empleadoPresta = empleadoPresta;
    }
}
