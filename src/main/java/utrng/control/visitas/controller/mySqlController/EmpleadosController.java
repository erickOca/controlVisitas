package utrng.control.visitas.controller.mySqlController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utrng.control.visitas.model.entity.mysql.Empleado;
import utrng.control.visitas.model.repository.mysqlRepository.EmpleadoRepository;
import utrng.control.visitas.model.repository.sqlRepository.PersonaRepository;
import utrng.control.visitas.service.mySqlService.EmpleadoVisitaService;
import utrng.control.visitas.util.EmpleadoRequest;
import utrng.control.visitas.util.EntradaRequest;

import java.util.List;

@RestController
@RequestMapping("/Empleado")
@CrossOrigin(origins = "*")
public class EmpleadosController {

    @Autowired
    EmpleadoVisitaService ingresosEmpleadoService;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @PostMapping("registrarEntrada")
    public ResponseEntity<?> registrarEntrada(@RequestBody EntradaRequest request){
        ingresosEmpleadoService.registroEntraEmpleado(request);

        return new ResponseEntity<>( HttpStatus.OK);
    }
    @PostMapping("registrarEmpleado")
    public ResponseEntity<?> registrarEmpleado(@RequestBody EmpleadoRequest request){
        Empleado empleado = new Empleado(request.getNumEmpleado(), request.getNombre(), request.getPuesto(), request.getArea());

        empleadoRepository.save(empleado);

        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @PutMapping("actualizarEmpleado/{numEmpleado}")
    public ResponseEntity<?> actualizarEmpleado( @RequestBody EmpleadoRequest request) {
        Empleado empleadoExistente = empleadoRepository.findByNumEmpleado(request.getNumEmpleado());

        if ( empleadoExistente == null) {
            return new ResponseEntity<>("Empleado no encontrado", HttpStatus.NOT_FOUND);
        }

        empleadoExistente.setNumEmpleado(request.getNumEmpleado());
        empleadoExistente.setNombre(request.getNombre());
        empleadoExistente.setPuesto(request.getPuesto());
        empleadoExistente.setArea(request.getArea());

        empleadoRepository.save(empleadoExistente);

        return new ResponseEntity<>(empleadoExistente, HttpStatus.OK);
    }

    @DeleteMapping("borrarEmpleado/{numEmpleado}")
    public ResponseEntity<?> borrarEmpleado(@PathVariable String numEmpleado) {
        Empleado empleadoExistente = empleadoRepository.findByNumEmpleado(numEmpleado);

        if (empleadoExistente == null) {
            return new ResponseEntity<>("Empleado no encontrado", HttpStatus.NOT_FOUND);
        }
        empleadoRepository.delete(empleadoExistente);

        return new ResponseEntity<>(empleadoExistente, HttpStatus.OK);
    }

    @GetMapping("GetEmpleado")
    public ResponseEntity<?> borrarEmpleado() {
      List<Empleado> empleadoList = empleadoRepository.findAll();

        return new ResponseEntity<>(empleadoList, HttpStatus.OK);
    }


}
