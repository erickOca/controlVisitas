package utrng.control.visitas.model.entity.sqlserver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "carreras_cgut")
public class CarrerasCgut {
    @Id
    @Column(name = "cve_carrera", nullable = false)
    private Integer id;

    @Size(max = 200)
    @Column(name = "nombre", length = 200)
    private String nombre;


    @Size(max = 20)
    @Column(name = "abreviatura", length = 20)
    private String abreviatura;

    @Column(name = "activo")
    private byte activo ;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public byte getActivo() {
        return activo;
    }

    public void setActivo(byte activo) {
        this.activo = activo;
    }
}