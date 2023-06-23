package utrng.control.visitas.model.entity.sqlserver;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TurnoId implements Serializable {
    private static final long serialVersionUID = 9095921236124843387L;
    @NotNull
    @Column(name = "cve_turno", nullable = false)
    private Integer cveTurno;

    @NotNull
    @Column(name = "cve_universidad", nullable = false)
    private Integer cveUniversidad;

    public Integer getCveTurno() {
        return cveTurno;
    }

    public void setCveTurno(Integer cveTurno) {
        this.cveTurno = cveTurno;
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
        TurnoId entity = (TurnoId) o;
        return Objects.equals(this.cveUniversidad, entity.cveUniversidad) &&
                Objects.equals(this.cveTurno, entity.cveTurno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cveUniversidad, cveTurno);
    }

}