package utrng.control.visitas.controller.sqlServerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utrng.control.visitas.model.entity.sqlserver.Persona;
import utrng.control.visitas.model.repository.sqlRepository.PersonaRepository;

@RestController
@RequestMapping("/emple")


@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    PersonaRepository personaRepository;

    @PostMapping("/ContarVisitasPersonas")
    public ResponseEntity<Persona> ContarVisitasPersonas(int id){
        Persona personas = personaRepository.findByCvePersona(id);

        return new ResponseEntity<>(personas , HttpStatus.OK);
    }


}
