package utrng.control.visitas.controller.mySqlController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utrng.control.visitas.model.entity.mysql.Alumnovisita;
import utrng.control.visitas.model.repository.mysqlRepository.AlumnoVisitaRepository;
import utrng.control.visitas.model.repository.mysqlRepository.ExternoRepository;
import utrng.control.visitas.model.repository.sqlRepository.CarrerasCgutRepository;
import utrng.control.visitas.service.mySqlService.IngresosEmpleadoServiceImpl;
import utrng.control.visitas.service.sqlService.AlumnoServiceImpl;
import utrng.control.visitas.service.sqlService.VisitasPorCarreraService;
import utrng.control.visitas.util.FechaRequest;
import utrng.control.visitas.util.response.CarreraResponse;
import utrng.control.visitas.util.response.GlobalResponse;
import utrng.control.visitas.util.response.TurnosResponse;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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

    @Autowired
    private AlumnoServiceImpl alumnoService;

    @Autowired
    private IngresosEmpleadoServiceImpl ingresosEmpleadoService;

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

    @PostMapping("ContarVisitasPorCarreraPorFecha")
    public ResponseEntity<?> contarVisitasPorCarreraPorFecha(@RequestBody FechaRequest request) {

        List<Object[]> resultados = repository.countByNombreCarreraAndFechaBetween(request.getFechaInicio(), request.getFechaFinal());

        List<CarreraResponse> carrerasResponse = new ArrayList<>();
        Long visitasTotales = 0L;

        for (Object[] resultado : resultados) {
            String nombreCarrera = (String) resultado[0];
            Long cantidad = (Long) resultado[1];

            CarreraResponse carreraResponse = new CarreraResponse(nombreCarrera, cantidad);
            carrerasResponse.add(carreraResponse);

            visitasTotales += cantidad;
        }

        CarreraResponse totalResponse = new CarreraResponse("Visitas Total", visitasTotales);
        carrerasResponse.add(totalResponse);
        return new ResponseEntity<>(carrerasResponse ,HttpStatus.OK);
    }

    @PostMapping("ContarVisitasPorGlobal")
    public ResponseEntity<?> contarVisitasGlobal(@RequestBody FechaRequest request) {

        Long alumnos = alumnoService.visitasAlumno(request.getFechaInicio(), request.getFechaFinal());
        Long personal = ingresosEmpleadoService.visitasEmpleado(request.getFechaInicio(), request.getFechaFinal());
        Long externos = Long.valueOf(externoRepository.countByOpcionWhereFecha(request.getFechaInicio(), request.getFechaFinal()));
        Long total_visitas = alumnos + externos + personal;

        GlobalResponse visitasPorPersonas = new GlobalResponse(alumnos, personal, externos, total_visitas);

        return new ResponseEntity<>(visitasPorPersonas ,HttpStatus.OK);
    }

    @PostMapping("/ContarVisitasPorAlumnosPorTurno")
    public ResponseEntity<List<TurnosResponse>> contarVisitasPorAlumnosPorTurno(@RequestBody FechaRequest request) {
        List<TurnosResponse> turnosResponse = new ArrayList<>();

        TurnosResponse matutino = new TurnosResponse("Matutino", repository.countVisitasByWeekdays());
        TurnosResponse despresurisado = new TurnosResponse("Despresurisado", repository.findVisitasByDayOfWeek());
        TurnosResponse totales = new TurnosResponse("Totales Visitas", matutino.getVistas() + despresurisado.getVistas());

        turnosResponse.add(matutino);
        turnosResponse.add(despresurisado);
        turnosResponse.add(totales);

        return ResponseEntity.ok(turnosResponse);
    }






}
