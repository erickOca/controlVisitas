package utrng.control.visitas.model.entity.mysql;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ingresos_empleado")
public class IngresosEmpleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIngreso",nullable = false)
    private int id;

  /*  @ManyToOne
    @JoinColumn(name = "idEmpleado")
     */
  @Column(name = "empleado_id",nullable = false)
    private Integer idEmpleado;



    @Column(name = "hora_entrada",nullable = false)
    private Timestamp horaEntrada;

    @Column(name = "area_visitada",nullable = false)
    private String areaVisitada;

    @Column(name = "motivo",nullable = false)
    private String motivo;

    // Constructor, getters y setters

    public IngresosEmpleado() {
    }

    public IngresosEmpleado(Integer idEmpleado, Timestamp horaEntrada, String areaVisitada, String motivo) {
        this.idEmpleado = idEmpleado;
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
                "idEmpleado=" + idEmpleado +
                ", horaEntrada=" + horaEntrada +
                ", areaVisitada='" + areaVisitada + '\'' +
                '}';
    }
}
