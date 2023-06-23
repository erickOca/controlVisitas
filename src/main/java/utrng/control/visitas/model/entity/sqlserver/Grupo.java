package utrng.control.visitas.model.entity.sqlserver;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "grupos")
public class Grupo {
    @EmbeddedId
    private GrupoId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "cve_turno", referencedColumnName = "cve_turno", nullable = false),
            @JoinColumn(name = "cve_universidad", referencedColumnName = "cve_universidad", nullable = false)
    })
    private Turno turnos;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "cve_plan", referencedColumnName = "cve_plan", nullable = false),
            @JoinColumn(name = "cve_carrera", referencedColumnName = "cve_carrera", nullable = false),
            @JoinColumn(name = "cve_division", referencedColumnName = "cve_division", nullable = false),
            @JoinColumn(name = "cve_unidad_academica", referencedColumnName = "cve_unidad_academica", nullable = false),
            @JoinColumn(name = "cve_universidad", referencedColumnName = "cve_universidad", nullable = false)
    })



    public GrupoId getId() {
        return id;
    }

    public void setId(GrupoId id) {
        this.id = id;
    }

    public Turno getTurnos() {
        return turnos;
    }

    public void setTurnos(Turno turnos) {
        this.turnos = turnos;
    }


}