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

    @Column(name = "nombreEmpleado")
    private String nombreEmpleado;

    // Getters y setters


    public Prestamo() {
    }

    public Prestamo(String matriculaEst, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Libro libro, String nombreEmpleado) {
        this.matriculaEst = matriculaEst;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
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

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
}
