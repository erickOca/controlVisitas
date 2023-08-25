package utrng.control.visitas.util;

import java.time.LocalDate;

public class PrestamoRequest {
    private String matriculaEst;
    private String tituloLibro;
    private String empleadoPresta;

    private String nombre;

    // Constructor, getters y setters

    public String getMatriculaEst() {
        return matriculaEst;
    }

    public void setMatriculaEst(String matriculaEst) {
        this.matriculaEst = matriculaEst;
    }

    public String getEmpleadoPresta() {
        return empleadoPresta;
    }

    public void setEmpleadoPresta(String empleadoPresta) {
        this.empleadoPresta = empleadoPresta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }
}
