package utrng.control.visitas.model.entity.sqlserver;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "turnos")
public class Turno {
    @EmbeddedId
    private TurnoId id;

    @Size(max = 30)
    @Column(name = "descripcion", length = 30)
    private String descripcion;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "Duracion")
    private Integer duracion;

    public TurnoId getId() {
        return id;
    }

    public void setId(TurnoId id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", activo=" + activo +
                ", duracion=" + duracion +
                '}';
    }
}