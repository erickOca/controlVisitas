package utrng.control.visitas.service.sqlService;

import org.springframework.beans.factory.annotation.Autowired;
import utrng.control.visitas.model.entity.sqlserver.CarrerasCgut;
import utrng.control.visitas.model.repository.sqlRepository.CarrerasCgutRepository;

import java.util.List;


public class CarrerasSeriviceImpl implements CarrerasSerivice {

    @Autowired
    CarrerasCgutRepository carrerasCgutRepository;

    @Override
    public List<CarrerasCgut> todasLasCarreras() {

        List<CarrerasCgut> list = carrerasCgutRepository.findAll();
        return list;
    }

    @Override
    public CarrerasCgut buscaPorCarrera(String nombre) {
        CarrerasCgut list = carrerasCgutRepository.findByNombre(nombre);
        return list;
    }
}
