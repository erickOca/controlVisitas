package utrng.control.visitas.model.entity.sqlserver;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GrupoId implements Serializable {
    private static final long serialVersionUID = -2926648503920057626L;
    @NotNull
    @Column(name = "cve_grupo", nullable = false)
    private Integer cveGrupo;

    @NotNull
    @Column(name = "cve_turno", nullable = false)
    private Integer cveTurno;

    @NotNull
    @Column(name = "cve_plan", nullable = false)
    private Integer cvePlan;

    @NotNull
    @Column(name = "cve_carrera", nullable = false)
    private Integer cveCarrera;

    @NotNull
    @Column(name = "cve_division", nullable = false)
    private Integer cveDivision;
    @NotNull
    @Column(name = "cve_unidad_academica", nullable = false)
    private Integer cveUnidadAcademica;

    @NotNull
    @Column(name = "cve_universidad", nullable = false)
    private Integer cveUniversidad;

    @NotNull
    @Column(name = "cve_periodo", nullable = false)
    private Integer cvePeriodo;

    public Integer getCveGrupo() {
        return cveGrupo;
    }

    public void setCveGrupo(Integer cveGrupo) {
        this.cveGrupo = cveGrupo;
    }

    public Integer getCveTurno() {
        return cveTurno;
    }

    public void setCveTurno(Integer cveTurno) {
        this.cveTurno = cveTurno;
    }

    public Integer getCvePlan() {
        return cvePlan;
    }

    public void setCvePlan(Integer cvePlan) {
        this.cvePlan = cvePlan;
    }

    public Integer getCveCarrera() {
        return cveCarrera;
    }

    public void setCveCarrera(Integer cveCarrera) {
        this.cveCarrera = cveCarrera;
    }

    public Integer getCveDivision() {
        return cveDivision;
    }

    public void setCveDivision(Integer cveDivision) {
        this.cveDivision = cveDivision;
    }

    public Integer getCveUnidadAcademica() {
        return cveUnidadAcademica;
    }

    public void setCveUnidadAcademica(Integer cveUnidadAcademica) {
        this.cveUnidadAcademica = cveUnidadAcademica;
    }

    public Integer getCveUniversidad() {
        return cveUniversidad;
    }

    public void setCveUniversidad(Integer cveUniversidad) {
        this.cveUniversidad = cveUniversidad;
    }

    public Integer getCvePeriodo() {
        return cvePeriodo;
    }

    public void setCvePeriodo(Integer cvePeriodo) {
        this.cvePeriodo = cvePeriodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GrupoId entity = (GrupoId) o;
        return Objects.equals(this.cvePeriodo, entity.cvePeriodo) &&
                Objects.equals(this.cvePlan, entity.cvePlan) &&
                Objects.equals(this.cveUniversidad, entity.cveUniversidad) &&
                Objects.equals(this.cveTurno, entity.cveTurno) &&
                Objects.equals(this.cveCarrera, entity.cveCarrera) &&
                Objects.equals(this.cveGrupo, entity.cveGrupo) &&
                Objects.equals(this.cveDivision, entity.cveDivision) &&
                Objects.equals(this.cveUnidadAcademica, entity.cveUnidadAcademica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cvePeriodo, cvePlan, cveUniversidad, cveTurno, cveCarrera, cveGrupo, cveDivision, cveUnidadAcademica);
    }

}