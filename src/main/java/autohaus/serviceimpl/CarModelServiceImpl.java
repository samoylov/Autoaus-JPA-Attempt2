package autohaus.serviceimpl;

import autohaus.dao.ModelDao;
import autohaus.entity.CarModel;
import autohaus.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarModelServiceImpl implements CarModelService {
    @Autowired
    private ModelDao dao;

    public void save(CarModel object) {
        dao.save(object);
    }

    public List<CarModel> findAll() {
        return dao.findAll();
    }

    public CarModel findOne(int id) {
        return dao.findOne(id);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
