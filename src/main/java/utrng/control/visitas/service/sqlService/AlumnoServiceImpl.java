package utrng.control.visitas.service.sqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utrng.control.visitas.model.entity.sqlserver.Alumno;
import utrng.control.visitas.model.repository.mysqlRepository.AlumnoVisitaRepository;
import utrng.control.visitas.model.repository.sqlRepository.AlumnoRepository;

import java.util.Date;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    AlumnoVisitaRepository alumnoVisitaRepository;

    @Override
    public Alumno findByAlumno(String matriculaAlumno) {
        Alumno alumno = alumnoRepository.findAlumnoByMatricula(matriculaAlumno);
        return alumno;
    }

    @Override
    public long visitasAlumno(Date fechaInicio, Date fechaFin) {
        long a = alumnoVisitaRepository.countByOpcionWhereFecha(fechaInicio, fechaFin);
        System.out.println("Las visitas son: " + a);

        return a;
    }
}
