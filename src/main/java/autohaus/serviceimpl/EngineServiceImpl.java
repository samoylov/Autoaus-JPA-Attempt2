package autohaus.serviceimpl;

import autohaus.dao.EngineDao;
import autohaus.entity.Engine;
import autohaus.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineServiceImpl implements EngineService {
    @Autowired
    private EngineDao dao;

    public void save(Engine object) {
        dao.save(object);
    }

    public List<Engine> findAll() {
        return dao.findAll();
    }

    public Engine findOne(int id) {
        return dao.findOne(id);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
