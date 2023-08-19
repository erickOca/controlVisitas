package utrng.control.visitas.util;

import java.time.LocalDate;

public class PrestamoRequest {
    private String matriculaEst;
    private int idLibro;
    private String nombreEmpleado;

    // Constructor, getters y setters


    public String getMatriculaEst() {
        return matriculaEst;
    }

    public void setMatriculaEst(String matriculaEst) {
        this.matriculaEst = matriculaEst;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
}
