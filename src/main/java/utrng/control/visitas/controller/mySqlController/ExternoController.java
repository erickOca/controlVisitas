package utrng.control.visitas.controller.mySqlController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utrng.control.visitas.model.entity.mysql.Externovisita;
import utrng.control.visitas.model.entity.sqlserver.Alumno;
import utrng.control.visitas.service.mySqlService.ExternoService;
import utrng.control.visitas.util.ExternoRequest;

@RestController
@RequestMapping("/externo")
@CrossOrigin(origins = "*")
public class ExternoController {

    @Autowired
    private ExternoService service;

    @PostMapping("saveExterno")
    public ResponseEntity<?> saveExterno(@RequestBody ExternoRequest request) {

        Externovisita response = service.saveExterno(request);
        return ResponseEntity.ok(response);
    }
}
