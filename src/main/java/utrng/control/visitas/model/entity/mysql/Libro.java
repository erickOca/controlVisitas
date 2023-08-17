package utrng.control.visitas.model.entity.mysql;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLibro")
    private int idLibro;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fechaingreso")
    private LocalDate fechaIngreso;

    @Column(name = "Autor")
    private String autor;

    @Column(name = "categoria")
    private String categoria;

    // Getters y setters


    public Libro() {
    }

    public Libro( String titulo, LocalDate fechaIngreso, String autor, String categoria) {
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
        this.autor = autor;
        this.categoria = categoria;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

