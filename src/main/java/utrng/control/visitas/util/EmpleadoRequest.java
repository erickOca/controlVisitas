package utrng.control.visitas.util;

import java.util.Date;

public class EmpleadoRequest {

    private String nombres;
    private String apellidos;
    private Date horaEntrada;
    private String areaVisitada;
    private String motivo;
    private String area;

    // Constructor vacío (necesario para deserialización)
    public EmpleadoRequest() {
    }

    // Constructor con parámetros
    public EmpleadoRequest(String nombres, String apellidos, Date horaEntrada,
                                 String areaVisitada, String motivo, String area) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horaEntrada = horaEntrada;
        this.areaVisitada = areaVisitada;
        this.motivo = motivo;
        this.area = area;
    }

    // Getters y setters
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getAreaVisitada() {
        return areaVisitada;
    }

    public void setAreaVisitada(String areaVisitada) {
        this.areaVisitada = areaVisitada;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

