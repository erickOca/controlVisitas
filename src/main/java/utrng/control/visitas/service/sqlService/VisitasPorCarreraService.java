package utrng.control.visitas.service.sqlService;

import utrng.control.visitas.model.entity.sqlserver.CarrerasCgut;

import java.util.List;

public interface VisitasPorCarreraService {
    List<CarrerasCgut> findAll();
}
