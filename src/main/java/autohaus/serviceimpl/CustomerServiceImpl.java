package autohaus.serviceimpl;

import autohaus.dao.CustomerDao;
import autohaus.entity.Customer;
import autohaus.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao dao;

    public void save(Customer object) {
        dao.save(object);
    }

    public List<Customer> findAll() {
        return dao.findAll();
    }

    public Customer findOne(int id) {
        return dao.findOne(id);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
