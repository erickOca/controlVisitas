package utrng.control.visitas.controller.mySqlController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utrng.control.visitas.service.mySqlService.IngresosEmpleadoService;
import utrng.control.visitas.util.EntradaRequest;

import java.sql.Timestamp;

@RestController
@RequestMapping("/Registro")
@CrossOrigin(origins = "*")
public class RegistroController {

    @Autowired
    IngresosEmpleadoService ingresosEmpleadoService;

    @PostMapping("registrarEntrada")
    public ResponseEntity<?> registrarEntrada(@RequestBody EntradaRequest request){
        ingresosEmpleadoService.registroEntraEmpleado(request);

        return new ResponseEntity<>( HttpStatus.OK);

    }

}
