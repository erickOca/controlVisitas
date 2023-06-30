package utrng.control.visitas.util.response;

public class NivelResponse {

    String nombre;

    Long VisitasPorCarreta;

    public NivelResponse() {
    }

    public NivelResponse(String nombre, Long visitasPorCarreta) {
        this.nombre = nombre;
        VisitasPorCarreta = visitasPorCarreta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getVisitasPorCarreta() {
        return VisitasPorCarreta;
    }

    public void setVisitasPorCarreta(Long visitasPorCarreta) {
        VisitasPorCarreta = visitasPorCarreta;
    }
}
