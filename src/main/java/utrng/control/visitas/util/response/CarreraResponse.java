package utrng.control.visitas.util.response;

public class CarreraResponse {
    String nombreCarrera;

    long visitas;


    public CarreraResponse() {
    }

    public CarreraResponse(String nombreCarrera, long visitas) {
        this.nombreCarrera = nombreCarrera;
        this.visitas = visitas;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public long getVisitas() {
        return visitas;
    }

    public void setVisitas(long visitas) {
        this.visitas = visitas;
    }

}
