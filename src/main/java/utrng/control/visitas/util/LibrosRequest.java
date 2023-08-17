package utrng.control.visitas.util;

import java.time.LocalDate;

public class LibrosRequest {
    private String titulo;
    private LocalDate fechaIngreso;
    private String autor;
    private String categoria;

    // Constructor
    public LibrosRequest(String titulo, LocalDate fechaIngreso, String autor, String categoria) {
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
        this.autor = autor;
        this.categoria = categoria;
    }

    // Getters y setters
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
