package utrng.control.visitas.util;

import java.sql.Timestamp;
import java.util.Date;

public class EntradaRequest {
    Integer idEmpleado;

    Timestamp fechaEntrada;

    String areaVisitada;

    String motivo;


    public EntradaRequest() {
    }

    public EntradaRequest(Timestamp fechaEntrada, String areaVisitada, String motivo) {
        this.fechaEntrada = fechaEntrada;
        this.areaVisitada = areaVisitada;
        this.motivo = motivo;
    }

    public Timestamp getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Timestamp fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
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

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
