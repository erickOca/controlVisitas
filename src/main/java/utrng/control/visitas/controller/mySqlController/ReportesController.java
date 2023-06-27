package utrng.control.visitas.controller.mySqlController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utrng.control.visitas.model.repository.mysqlRepository.AlumnoVisitaRepository;
import utrng.control.visitas.model.repository.mysqlRepository.ExternoRepository;
import utrng.control.visitas.model.repository.sqlRepository.CarrerasCgutRepository;
import utrng.control.visitas.service.sqlService.VisitasPorCarreraService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reportes")
@CrossOrigin(origins = "*")
public class ReportesController {

    @Autowired
    private AlumnoVisitaRepository repository;

    @Autowired
    private ExternoRepository externoRepository;

    @Autowired
    private CarrerasCgutRepository carrerasCgutRepository;

    @Autowired
    private VisitasPorCarreraService porCarreraService;

    @GetMapping("ContarVisitasPorArea")
    public ResponseEntity<?> contarVisitasPorArea() {
        Long visitasComputo = repository.countByOpcion("Area de computo");
        Long visitasLibros = repository.countByOpcion("Area de libros");
        Long visitasComputoExternos = externoRepository.countByOpcion("Area de computo");
        Long visitasLibrosExternos = externoRepository.countByOpcion("Area de libros");

        Long totalComputo = visitasComputo + visitasComputoExternos;
        Long totalLibros = visitasLibros + visitasLibrosExternos;

        Long totalFinal = totalComputo + totalLibros;

        Map<String, Long> visitasPorArea = new HashMap<>();
        visitasPorArea.put("Computo", totalComputo);
        visitasPorArea.put("Libros", totalLibros);
        visitasPorArea.put("Total", totalFinal);


        return new ResponseEntity<>(visitasPorArea, HttpStatus.OK);
    }
/*    @GetMapping("ContarVisitasPorCarrera")
    public ResponseEntity<?> contarVisitasPorCarrera() {

        List<CarrerasCgut> carreraServiceAll = porCarreraService.findAll();
        ResponseEntity<?>  total = contarVisitasPorArea();
        List<VisitasPorCarreraResponse> VisitasPorCarrera ;




        return new ResponseEntity<>(VisitasPorCarrera , HttpStatus.OK);
    }

 */
    // pendiente de desarrollo
    @GetMapping("ContarVisitasPorPersonas")
    public ResponseEntity<?> contarVisitasPorPersonas() {

        Long alumnos;
        Long personal;
        Long externos;
        Long total_visitas;

        Map<String, Long> visitasPorPersonas = new HashMap<>();

        return new ResponseEntity<>(visitasPorPersonas ,HttpStatus.OK);
    }
}
