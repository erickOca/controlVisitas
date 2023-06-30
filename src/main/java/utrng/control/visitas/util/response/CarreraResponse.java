package utrng.control.visitas.util.response;

public class CarreraResponse {
    String nombreCarrera;

    Long visitas;


    public CarreraResponse() {
    }

    public CarreraResponse(String nombreCarrera, Long visitas) {
        this.nombreCarrera = nombreCarrera;
        this.visitas = visitas;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Long getVisitas() {
        return visitas;
    }

    public void setVisitas(Long visitas) {
        this.visitas = visitas;
    }
}
