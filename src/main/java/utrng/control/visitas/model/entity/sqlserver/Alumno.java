package utrng.control.visitas.model.entity.sqlserver;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumnos")
public class Alumno {
    @EmbeddedId
    private AlumnoId id;

    @Size(max = 15)
    @NotNull
    @Column(name = "matricula", nullable = false, length = 15)
    private String matricula;

    @Column(name = "grado_actual", columnDefinition = "tinyint")
    private Short gradoActual;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cve_carrera")
    private  CarrerasCgut carrerasCgut;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cve_turno", referencedColumnName = "cve_turno", insertable = false, updatable = false)
    @JoinColumn(name = "cve_universidad", referencedColumnName = "cve_universidad", insertable = false, updatable = false)
    private Turno turno;


    public AlumnoId getId() {
        return id;
    }

    public void setId(AlumnoId id) {
        this.id = id;
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

    public CarrerasCgut getCarrerasCgut() {
        return carrerasCgut;
    }

    public void setCarrerasCgut(CarrerasCgut carrerasCgut) {
        this.carrerasCgut = carrerasCgut;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}