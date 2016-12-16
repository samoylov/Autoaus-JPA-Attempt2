package autohaus.serviceimpl;

import autohaus.dao.ColorDao;
import autohaus.entity.Color;
import autohaus.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorDao dao;

    public void save(Color object) {
        dao.save(object);
    }

    public List<Color> findAll() {
        return dao.findAll();
    }

    public Color findOne(int id) {
        return dao.findOne(id);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
