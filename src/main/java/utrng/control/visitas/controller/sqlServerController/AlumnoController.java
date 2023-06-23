package utrng.control.visitas.controller.sqlServerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utrng.control.visitas.model.entity.mysql.Alumnovisita;
import utrng.control.visitas.model.entity.sqlserver.Alumno;
import utrng.control.visitas.model.repository.mysqlRepository.AlumnoVisitaRepository;
import utrng.control.visitas.service.sqlService.AlumnoService;

import java.util.Date;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private AlumnoVisitaRepository alumnoVisitaRepository;

    @PostMapping("FindByAlumno/{matriculaAlumno}")
    public ResponseEntity<?> buscarMatricula(@PathVariable("matriculaAlumno") String matriculaAlumno,
                                             @RequestParam("opcion") String opcion,
                                             @RequestParam("motivo") String motivo) {
        Alumno response = alumnoService.findByAlumno(matriculaAlumno);
        if (response != null) {
            Alumnovisita alumnovisita = new Alumnovisita();
            Date fecha = new Date();
            alumnovisita.setId(response.getId().getCveAlumno());
            alumnovisita.setCveUniversidad(response.getId().getCveUniversidad());
            alumnovisita.setMatricula(response.getMatricula());
            alumnovisita.setGradoActual(response.getGradoActual());
            alumnovisita.setIdCarrera(response.getCarrerasCgut().getId());
            alumnovisita.setNombreCarrera(response.getCarrerasCgut().getNombre());
            alumnovisita.setAbreviatura(response.getCarrerasCgut().getAbreviatura());
            alumnovisita.setFecha(fecha);
            alumnovisita.setOpcion(opcion);
            alumnovisita.setMotivo(motivo);

            alumnoVisitaRepository.save(alumnovisita);

            return new ResponseEntity<>(alumnovisita, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
