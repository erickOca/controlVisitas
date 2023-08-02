package utrng.control.visitas.util;

public class EmpleadoRequest {
    String numEmpleado;

    String nombre;

    String puesto;

    String area;

    public EmpleadoRequest() {
    }

    public EmpleadoRequest(String numEmpleado, String nombre, String puesto, String area) {
        this.numEmpleado = numEmpleado;
        this.nombre = nombre;
        this.puesto = puesto;
        this.area = area;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
