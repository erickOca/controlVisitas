package utrng.control.visitas.model.entity.mysql;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "externovisita")
public class ExternoVisita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExternoVisita", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "nombreInstitucion", length = 45)
    private String nombreInstitucion;

    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 100)
    @Column(name = "opcion", length = 100)
    private String opcion;

    @Size(max = 345)
    @Column(name = "motivo", length = 345)
    private String motivo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}