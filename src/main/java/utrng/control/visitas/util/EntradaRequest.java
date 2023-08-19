package utrng.control.visitas.util;

import java.sql.Timestamp;
import java.util.Date;

public class EntradaRequest {


    String areaVisitada;

    String motivo;


    public EntradaRequest() {
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

}
