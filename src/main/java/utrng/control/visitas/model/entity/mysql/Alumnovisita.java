package utrng.control.visitas.model.entity.mysql;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "alumnovisita")
public class Alumnovisita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVisita",nullable = false)
    private Integer idVisita;
    @Column(name = "cveAlumno", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "cveUniversidad", length = 45)
    private Integer cveUniversidad;

    @Size(max = 45)
    @Column(name = "matricula", length = 45)
    private String matricula;

    @Column(name = "gradoActual")
    private Short gradoActual;

    @Column(name = "idCarrera")
    private Integer idCarrera;

    @Size(max = 45)
    @Column(name = "nombreCarrera", length = 45)
    private String nombreCarrera;

    @Size(max = 45)
    @Column(name = "Abreviatura", length = 45)
    private String abreviatura;

    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "opcion", length = 45)
    private String opcion;

    @Size(max = 100)
    @Column(name = "motivo", length = 100)
    private String motivo;

    @Size(max = 100)
    @Column(name = "turno", length = 100)
    private String turno ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCveUniversidad() {
        return cveUniversidad;
    }

    public void setCveUniversidad(Integer cveUniversidad) {
        this.cveUniversidad = cveUniversidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Short getGradoActual() {
        return gradoActual;
    }

    public void setGradoActual(Short gradoActual) {
        this.gradoActual = gradoActual;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Integer getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Integer idVisita) {
        this.idVisita = idVisita;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}