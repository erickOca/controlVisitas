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
}
