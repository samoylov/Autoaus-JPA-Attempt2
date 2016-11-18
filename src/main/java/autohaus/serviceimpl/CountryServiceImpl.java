package autohaus.serviceimpl;

import autohaus.dao.CountryDao;
import autohaus.entity.Country;
import autohaus.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao dao;

    public void save(Country object) {
        dao.save(object);
    }

    public List<Country> findAll() {
        return dao.findAll();
    }

    public Country findOne(int id) {
        return dao.findOne(id);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
