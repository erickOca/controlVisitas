package utrng.control.visitas.controller.mySqlController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utrng.control.visitas.model.entity.mysql.Alumnovisita;
import utrng.control.visitas.model.entity.sqlserver.CarrerasCgut;
import utrng.control.visitas.model.repository.mysqlRepository.AlumnoVisitaRepository;
import utrng.control.visitas.model.repository.mysqlRepository.ExternoRepository;
import utrng.control.visitas.model.repository.sqlRepository.AlumnoRepository;
import utrng.control.visitas.model.repository.sqlRepository.CarrerasCgutRepository;
import utrng.control.visitas.model.repository.sqlRepository.PersonaRepository;
import utrng.control.visitas.service.mySqlService.EmpleadoVisitaServiceImpl;
import utrng.control.visitas.service.sqlService.AlumnoServiceImpl;
import utrng.control.visitas.service.sqlService.VisitasPorCarreraService;
import utrng.control.visitas.util.FechaRequest;
import utrng.control.visitas.util.response.*;

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
    private EmpleadoVisitaServiceImpl ingresosEmpleadoService;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private PersonaRepository personaRepository;


    @GetMapping("ContarVisitasPorArea")
    public ResponseEntity<?> contarVisitasPorArea() {
        // Alumnos
        Long visitasComputo = repository.countByOpcion("Area de Computo");
        Long visitasLibros = repository.countByOpcion("Area de Biblioteca");
        // Externo
        Long visitasComputoExternos = externoRepository.countByOpcion("Area de Computo");
        Long visitasLibrosExternos = externoRepository.countByOpcion("Area de Biblioteca");


        Long totalComputo = visitasComputo + visitasComputoExternos;
        Long totalLibros = visitasLibros + visitasLibrosExternos;

        Long totalFinal = totalComputo + totalLibros;

        Map<String, Long> visitasPorArea = new HashMap<>();
        visitasPorArea.put("Computo", totalComputo);
        visitasPorArea.put("Libros", totalLibros);
        visitasPorArea.put("Total", totalFinal);


        return new ResponseEntity<>(visitasPorArea, HttpStatus.OK);
    }

    @PostMapping("ContarVisitasPorCarrera")
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

    @PostMapping("ContarVisitasGlobal")
    public ResponseEntity<?> contarVisitasGlobal(@RequestBody FechaRequest request) {

        Long alumnos = alumnoService.visitasAlumno(request.getFechaInicio(), request.getFechaFinal());
        Long personal = ingresosEmpleadoService.visitasEmpleado(request.getFechaInicio(), request.getFechaFinal());
        Long externos = Long.valueOf(externoRepository.countByOpcionWhereFecha(request.getFechaInicio(), request.getFechaFinal()));
        Long total_visitas = alumnos + externos + personal;

        GlobalResponse visitasPorPersonas = new GlobalResponse(alumnos, personal, externos, total_visitas);

        return new ResponseEntity<>(visitasPorPersonas ,HttpStatus.OK);
    }

    @PostMapping("/AlumnosPorTurno")
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


    @PostMapping("/AlumnosNivel")
    public ResponseEntity<List<NivelResponse>> contarVisitasPorAlumnosNivelX(@RequestBody FechaRequest request){
        List<NivelResponse> carreraResponses = new ArrayList<>();
        Long a = repository.countByTurnoWhereTsuAndFechaBetween(request.getFechaInicio(), request.getFechaFinal());
        Long b = repository.countByTurnoWhereIng();

        NivelResponse responseTsu = new NivelResponse("Tecnico Superior Universitatio", a);
        NivelResponse responseLic = new NivelResponse("Ingenieria y Licenciatura", b);
        NivelResponse responseTotal = new NivelResponse("Total de Visitas Por Niveles", a + b);

        carreraResponses.add(responseTsu);
        carreraResponses.add(responseLic);
        carreraResponses.add(responseTotal);

        return ResponseEntity.ok(carreraResponses);
    }

    @PostMapping("/FiltroDeAlumnos")
    public ResponseEntity<List<Alumnovisita>> FiltroDeAlumnos(String turno, String carrera){
        List<Alumnovisita> alumnovisitas = new ArrayList<>();
        alumnovisitas = repository.findByGradoTurnoCarrera(turno, carrera);

        return new ResponseEntity<>(alumnovisitas ,HttpStatus.OK);
    }
// Reporte de Externo
    @PostMapping("/ContarVisExArea")
    public ResponseEntity<List<ExternoRespose>> ContarVisExArea(@RequestBody FechaRequest request){
        List<Object[]> resultList = externoRepository.countByOpcion(request.getFechaInicio(), request.getFechaFinal());
        List<ExternoRespose> list = new ArrayList<>();
        long total = 0L;

        for (Object[] result : resultList) {
            String nombre = (String) result[0]; // Supongamos que el nombre está en la posición 0 del arreglo
            Long visitas = (Long) result[1]; // Supongamos que las visitas están en la posición 1 del arreglo

            ExternoRespose externoRespose = new ExternoRespose();
            externoRespose.setNombre(nombre);
            externoRespose.setVisitas(visitas);

            list.add(externoRespose);

            total += visitas;
        }

        ExternoRespose externoResposeTotales = new ExternoRespose();
        externoResposeTotales.setVisitas(total);
        externoResposeTotales.setNombre("Visitas Totales");

        list.add(externoResposeTotales);

        System.out.println("Total de visitas: " + externoResposeTotales);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/ContarVisExInstitucion")
    public ResponseEntity<List<ExternoRespose>> ContarVisitasPorExternoInstitucion(@RequestBody FechaRequest request) {
        List<Object[]> resultList = externoRepository.countByNombreInstitucion(request.getFechaInicio(), request.getFechaFinal());
        List<ExternoRespose> list = new ArrayList<>();
        long total = 0L;

        for (Object[] result : resultList) {
            String nombre = (String) result[0]; // Supongamos que el nombre está en la posición 0 del arreglo
            Long visitas = (Long) result[1]; // Supongamos que las visitas están en la posición 1 del arreglo

            ExternoRespose externoRespose = new ExternoRespose();
            externoRespose.setNombre(nombre);
            externoRespose.setVisitas(visitas);

            list.add(externoRespose);

            total += visitas;
        }

        // Agregar objeto ExternoRespose adicional para representar el total de visitas
        ExternoRespose externoResposeTotales = new ExternoRespose();
        externoResposeTotales.setVisitas(total);
        externoResposeTotales.setNombre("Visitas Totales");

        list.add(externoResposeTotales);

        System.out.println("Total de visitas: " + total);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
// Reportes de divicion
@GetMapping("/MostrarCarreras")
public ResponseEntity<List<CarrerasCgut>> ContarVisitasPorDivisiones() {
    List<CarrerasCgut> list = carrerasCgutRepository.findAll();

    return new ResponseEntity<>(list, HttpStatus.OK);
}
    @PostMapping("/ContarPersonalArea")
    public ResponseEntity<List<AreaPersonalResponse>> contarPersonalArea(@RequestBody FechaRequest request) {
        List<AreaPersonalResponse> areaPerdonalResponses =ingresosEmpleadoService.contarPersonalArea(request.getFechaInicio(), request.getFechaFinal());

        return new ResponseEntity<>(areaPerdonalResponses, HttpStatus.OK);
    }



}
