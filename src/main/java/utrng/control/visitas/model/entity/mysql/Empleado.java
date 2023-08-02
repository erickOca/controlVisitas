package utrng.control.visitas.model.entity.mysql;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado",nullable = false)
    private Integer idEmpleado;

    @Size(max = 50)
    @Column(name = "numEmpleado", nullable = false)
    private String numEmpleado;

    @Size(max = 200)
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Size(max = 200)
    @Column(name = "puesto", nullable = false)
    private String puesto;

    @Size(max = 200)
    @Column(name = "area", nullable = false)
    private String area;

    public Empleado() {
    }

    public Empleado( String numEmpleado, String nombre, String puesto, String area) {
        this.numEmpleado = numEmpleado;
        this.nombre = nombre;
        this.puesto = puesto;
        this.area = area;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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
