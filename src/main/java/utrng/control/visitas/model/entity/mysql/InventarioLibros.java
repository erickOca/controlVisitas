package utrng.control.visitas.model.entity.mysql;

import javax.persistence.*;

@Entity
@Table(name = "inventario")
public class InventarioLibros {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Ficha_No")
    private int fichaNo;
    @Id
    @Basic(optional = false)
    @Column(name = "NumAdqui")
    private String numAdqui;
    @Column(name = "Biblioteca")
    private Short biblioteca;
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Autor")
    private String autor;
    @Column(name = "Clasificacion")
    private String clasificacion;
    @Column(name = "Prestado")
    private String prestado;
    @Column(name = "Borrado")
    private Boolean borrado;

    public int getFichaNo() {
        return fichaNo;
    }

    public void setFichaNo(int fichaNo) {
        this.fichaNo = fichaNo;
    }

    public String getNumAdqui() {
        return numAdqui;
    }

    public void setNumAdqui(String numAdqui) {
        this.numAdqui = numAdqui;
    }

    public Short getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Short biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getPrestado() {
        return prestado;
    }

    public void setPrestado(String prestado) {
        this.prestado = prestado;
    }

    public Boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(Boolean borrado) {
        this.borrado = borrado;
    }
}
