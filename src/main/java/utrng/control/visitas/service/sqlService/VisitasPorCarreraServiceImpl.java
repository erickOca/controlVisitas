package utrng.control.visitas.service.sqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utrng.control.visitas.model.entity.sqlserver.Alumno;
import utrng.control.visitas.model.entity.sqlserver.CarrerasCgut;
import utrng.control.visitas.model.repository.sqlRepository.CarrerasCgutRepository;

import java.util.List;

@Service
public class VisitasPorCarreraServiceImpl implements VisitasPorCarreraService{

    @Autowired
    private CarrerasCgutRepository carrerasCgutRepository;
    @Override
    public List<CarrerasCgut> findAll() {

        List<CarrerasCgut> carreras = carrerasCgutRepository.findAll();
        return carreras;
    }
}
