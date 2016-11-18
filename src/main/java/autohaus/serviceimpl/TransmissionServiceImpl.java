package autohaus.serviceimpl;

import autohaus.dao.TransmissionDao;
import autohaus.entity.Transmission;
import autohaus.service.TransmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransmissionServiceImpl implements TransmissionService {
    @Autowired
    private TransmissionDao dao;

    public void save(Transmission object) {
        dao.save(object);
    }

    public List<Transmission> findAll() {
        return dao.findAll();
    }

    public Transmission findOne(int id) {
        return dao.findOne(id);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
