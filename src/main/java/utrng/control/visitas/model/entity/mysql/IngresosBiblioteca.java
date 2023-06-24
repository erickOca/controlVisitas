package utrng.control.visitas.model.entity.mysql;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ingresos_biblioteca")
public class IngresosBiblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIngreso",nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleados idEmpleado;

    @Column(name = "hora_entrada",nullable = false)
    private Timestamp horaEntrada;

    @Column(name = "area_visitada",nullable = false)
    private String areaVisitada;

    // Constructor, getters y setters

    // Otros métodos si los necesitas
}
