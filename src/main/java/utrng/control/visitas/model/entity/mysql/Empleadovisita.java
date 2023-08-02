package utrng.control.visitas.model.entity.mysql;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "empleadovisita")
public class Empleadovisita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIngreso",nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "empleado_id", referencedColumnName = "idEmpleado", nullable = false)
    private Empleado empleado;

    @Column(name = "hora_entrada",nullable = false)
    private Timestamp horaEntrada;

    @Column(name = "area_visitada",nullable = false)
    private String areaVisitada;

    @Column(name = "motivo",nullable = false)
    private String motivo;

    // Constructor, getters y setters

    public Empleadovisita() {
    }

    public Empleadovisita(Empleado empleado, Timestamp horaEntrada, String areaVisitada, String motivo) {
        this.empleado = empleado;
        this.horaEntrada = horaEntrada;
        this.areaVisitada = areaVisitada;
        this.motivo = motivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Timestamp horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getAreaVisitada() {
        return areaVisitada;
    }

    public void setAreaVisitada(String areaVisitada) {
        this.areaVisitada = areaVisitada;
    }

    // Otros métodos si los necesitas


    @Override
    public String toString() {
        return "Ingreso Empleado{" +
                "idEmpleado=" + empleado +
                ", horaEntrada=" + horaEntrada +
                ", areaVisitada='" + areaVisitada + '\'' +
                '}';
    }
}
