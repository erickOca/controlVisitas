package utrng.control.visitas.model.entity.sqlserver;

import javax.persistence.*;

@Entity
@Table(name = "tipo_persona")
public class TipoPersona {

    @Id
    @Column(name = "cve_tipo_persona")
    private int cveTipoPersona;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "abreviatura")
    private String abreviatura;

    @Column(name = "activo")
    private Boolean activo;

    // Constructors, getters, and setters


    public TipoPersona() {
    }

    public TipoPersona(int cveTipoPersona, String descripcion, String abreviatura, Boolean activo) {
        this.cveTipoPersona = cveTipoPersona;
        this.descripcion = descripcion;
        this.abreviatura = abreviatura;
        this.activo = activo;
    }


    public int getCveTipoPersona() {
        return cveTipoPersona;
    }

    public void setCveTipoPersona(int cveTipoPersona) {
        this.cveTipoPersona = cveTipoPersona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}

