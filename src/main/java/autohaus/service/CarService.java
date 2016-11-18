package autohaus.service;

import autohaus.entity.Car;

import java.util.List;

public interface CarService {

    void save(Car object);

    List<Car> findAll();

    Car findOne(int id);

    void delete(int id);

}
