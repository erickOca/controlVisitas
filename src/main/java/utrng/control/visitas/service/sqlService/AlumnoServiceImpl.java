package utrng.control.visitas.service.sqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utrng.control.visitas.model.entity.sqlserver.Alumno;
import utrng.control.visitas.model.repository.sqlRepository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;


    @Override
    public Alumno findByAlumno(String matriculaAlumno) {
        Alumno alumno = alumnoRepository.findAlumnoByMatricula(matriculaAlumno);
        return alumno;
    }
}
