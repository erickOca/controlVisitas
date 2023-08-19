package utrng.control.visitas.controller.mySqlController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utrng.control.visitas.model.entity.mysql.EmpleadoVisita;
import utrng.control.visitas.model.repository.sqlRepository.PersonaRepository;
import utrng.control.visitas.service.mySqlService.EmpleadoVisitaService;
import utrng.control.visitas.util.EmpleadoRequest;

import java.util.List;

@RestController
@RequestMapping("/Empleado")
@CrossOrigin(origins = "*")
public class EmpleadosController {

    @Autowired
    EmpleadoVisitaService ingresosEmpleadoService;

    @Autowired
    PersonaRepository personaRepository;


    @PostMapping("registrarEntrada")
    public ResponseEntity<EmpleadoVisita> registrarEntrada(@RequestBody EmpleadoRequest request){
       EmpleadoVisita empleadoVisita = ingresosEmpleadoService.registroEntraEmpleado(request);

        return new ResponseEntity<>(empleadoVisita, HttpStatus.OK);
    }


}
