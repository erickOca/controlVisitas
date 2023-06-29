package utrng.control.visitas.util.response;

public class TurnosResponse {

    String Nombre;
    Long vistas;

    public TurnosResponse() {
    }

    public TurnosResponse(String nombre, Long vistas) {
        Nombre = nombre;
        this.vistas = vistas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Long getVistas() {
        return vistas;
    }

    public void setVistas(Long vistas) {
        this.vistas = vistas;
    }
}
