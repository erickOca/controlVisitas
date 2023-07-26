package utrng.control.visitas.model.entity.sqlserver;

import javax.persistence.*;

@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @Column(name = "cve_persona")
    private Integer cvePersona;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido_pat")
    private String apellidoPaterno;

    @Column(name = "apellido_mat")
    private String apellidoMaterno;

    @ManyToOne
    @JoinColumn(name = "cve_tipo_persona")
    private TipoPersona tipoPersona;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "es_madre")
    private Boolean esMadre;

    @Column(name = "es_sindicalizado")
    private Boolean esSindicalizado;


    // Constructor, getters, and setters


    public Persona() {
    }

    public Persona(Integer cvePersona, String nombre, String apellidoPaterno, String apellidoMaterno, TipoPersona tipoPersona, String sexo, Boolean esMadre, Boolean esSindicalizado) {
        this.cvePersona = cvePersona;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoPersona = tipoPersona;
        this.sexo = sexo;
        this.esMadre = esMadre;
        this.esSindicalizado = esSindicalizado;
    }

    public Integer getCvePersona() {
        return cvePersona;
    }

    public void setCvePersona(Integer cvePersona) {
        this.cvePersona = cvePersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Boolean getEsMadre() {
        return esMadre;
    }

    public void setEsMadre(Boolean esMadre) {
        this.esMadre = esMadre;
    }

    public Boolean getEsSindicalizado() {
        return esSindicalizado;
    }

    public void setEsSindicalizado(Boolean esSindicalizado) {
        this.esSindicalizado = esSindicalizado;
    }
}

