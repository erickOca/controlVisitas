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

 /*   @ManyToOne
    @JoinColumn(name = "cve_tipo_persona")
    private TipoPersona tipoPersona;
  */

    @Column(name = "rfc")
    private String rfc;


    @Column(name = "curp")
    private String curp;

    @Column(name = "sexo")
    private String sexo;


    @Column(name = "fam_diabetico")
    private Boolean familiarDiabetico;

    @Column(name = "fam_hipertenso")
    private Boolean familiarHipertenso;

    @Column(name = "fam_cardiaco")
    private Boolean familiarCardiaco;

    @Column(name = "es_madre")
    private Boolean esMadre;

    @Column(name = "es_sindicalizado")
    private Boolean esSindicalizado;

    @Column(name = "discapacidad")
    private Boolean discapacidad;


    // Constructor, getters, and setters
}

