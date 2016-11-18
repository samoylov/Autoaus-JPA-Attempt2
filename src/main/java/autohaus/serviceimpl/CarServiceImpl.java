package autohaus.serviceimpl;

import autohaus.dao.CarDao;
import autohaus.entity.Car;
import autohaus.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao dao;

    public void save(Car object) {
        dao.save(object);
    }

    public List<Car> findAll() {
        return dao.findAll();
    }

    public Car findOne(int id) {
        return dao.findOne(id);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
