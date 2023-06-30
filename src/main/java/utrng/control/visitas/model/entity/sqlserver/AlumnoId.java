package utrng.control.visitas.model.entity.sqlserver;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AlumnoId implements Serializable {
    private static final long serialVersionUID = 307223730383854471L;
    @NotNull
    @Column(name = "cve_alumno", nullable = false)
    private Integer cveAlumno;

    @NotNull
    @Column(name = "cve_universidad", nullable = false)
    private Integer cveUniversidad;


    public Integer getCveAlumno() {
        return cveAlumno;
    }

    public void setCveAlumno(Integer cveAlumno) {
        this.cveAlumno = cveAlumno;
    }

    public Integer getCveUniversidad() {
        return cveUniversidad;
    }

    public void setCveUniversidad(Integer cveUniversidad) {
        this.cveUniversidad = cveUniversidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AlumnoId entity = (AlumnoId) o;
        return Objects.equals(this.cveUniversidad, entity.cveUniversidad) &&
                Objects.equals(this.cveAlumno, entity.cveAlumno) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cveUniversidad, cveAlumno);
    }

}