package utrng.control.visitas.controller.mySqlController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utrng.control.visitas.model.entity.mysql.Prestamo;
import utrng.control.visitas.service.mySqlService.PrestamoService;
import utrng.control.visitas.util.PrestamoRequest;

import java.util.List;

@RestController
@RequestMapping("/Prestamo")
@CrossOrigin(origins = "*")
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;

    @GetMapping("/todoslosprestamos")
    public ResponseEntity<List<Prestamo>> todosLosPrestamos(){
        List<Prestamo> prestamoList = prestamoService.todosLosPrestamos();

        return new ResponseEntity<>(prestamoList, HttpStatus.OK);
    }

    @PostMapping("/nuevoprestamo")
    public ResponseEntity<?> nuevoPrestamo(@RequestBody PrestamoRequest prestamoRequest) {
        try {
            Prestamo prestamo = prestamoService.nuevoPrestamo(prestamoRequest);
            return new ResponseEntity<>(prestamo, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book is not available for loan");
        }
    }
    @GetMapping("/buscarpormatricula")
    public ResponseEntity<List<Prestamo>> buscarPorMatricula(String matricula){
        List<Prestamo> prestamos = prestamoService.buscarPorMatricula(matricula);

        return new ResponseEntity<>(prestamos, HttpStatus.OK);
    }

    @PutMapping("/devoluciondeprestamo")
    public  ResponseEntity<Prestamo> devolucionDePrestamo(int idPrestamo){
        Prestamo prestamo = prestamoService.devolucionDePrestamo(idPrestamo);

        return new ResponseEntity<>(prestamo, HttpStatus.OK);
    }

    @GetMapping("/todosLosprestamospordevolver")
    public ResponseEntity<List<Prestamo>> todosLosPrestamosPorDevolver(){
        List<Prestamo> prestamoList = prestamoService.todosLosPrestamosPorDevolver();

        return new ResponseEntity<>(prestamoList, HttpStatus.OK);
    }

    @GetMapping("/buscarpornumempleado")
    public ResponseEntity<List<Prestamo>> buscarPorNumEmpleado(String numEmpleado){
        List<Prestamo> prestamoList =prestamoService.buscarPorNumEmpleado(numEmpleado);

        return new ResponseEntity<>(prestamoList, HttpStatus.OK);
    }

}
