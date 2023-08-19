package utrng.control.visitas.model.entity.mysql;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empleadovisita")
public class EmpleadoVisita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIngreso")
    private int idIngreso;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "hora_entrada", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date horaEntrada;

    @Column(name = "opcion")
    private String areaVisitada;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "area")
    private String area;

    // Constructor, getters, setters, y otros métodos


    public EmpleadoVisita() {
    }

    public EmpleadoVisita(String nombres, String apellidos, Date horaEntrada, String areaVisitada, String motivo, String area) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horaEntrada = horaEntrada;
        this.areaVisitada = areaVisitada;
        this.motivo = motivo;
        this.area = area;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getAreaVisitada() {
        return areaVisitada;
    }

    public void setAreaVisitada(String areaVisitada) {
        this.areaVisitada = areaVisitada;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
