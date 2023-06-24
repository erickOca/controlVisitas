package utrng.control.visitas.model.entity.mysql;
import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado",nullable = false)
    private int id;
    @Column(name = "idVisita",nullable = false)
    private String nombre;
    @Column(name = "area",nullable = false)
    private String area;

    // Constructor, getters y setters

    // Otros métodos si los necesitas
}

