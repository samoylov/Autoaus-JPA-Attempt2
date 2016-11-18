package autohaus.serviceimpl;

import autohaus.dao.MakeDao;
import autohaus.entity.Make;
import autohaus.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeServiceImpl implements MakeService {
    @Autowired
    private MakeDao dao;

    public void save(Make object) {
        dao.save(object);
    }

    public List<Make> findAll() {
        return dao.findAll();
    }

    public Make findOne(int id) {
        return dao.findOne(id);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
