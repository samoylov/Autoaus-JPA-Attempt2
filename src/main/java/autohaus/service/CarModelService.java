package autohaus.service;

import autohaus.entity.CarModel;

import java.util.List;

public interface CarModelService {

    void save(CarModel object);

    List<CarModel> findAll();

    CarModel findOne(int id);

    void delete(int id);

}
