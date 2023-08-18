package utrng.control.visitas.util;

import java.time.LocalDate;

public class PrestamoRequest {
    private String matriculaEst;
    private int idLibro;
    private String numEmpleado;

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

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }
}
