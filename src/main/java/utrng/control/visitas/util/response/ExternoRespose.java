package utrng.control.visitas.util.response;

public class ExternoRespose {
    String nombre;

    Long visitas;

    public ExternoRespose(String nombre, Long visitas) {
        this.nombre = nombre;
        this.visitas = visitas;
    }

    public ExternoRespose() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getVisitas() {
        return visitas;
    }

    public void setVisitas(Long visitas) {
        this.visitas = visitas;
    }
}
