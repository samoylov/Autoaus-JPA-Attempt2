package autohaus.serviceimpl;

import autohaus.dao.OrdersDao;
import autohaus.entity.Orders;
import autohaus.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao dao;

    public void save(Orders object) {
        dao.save(object);
    }

    public List<Orders> findAll() {
        return dao.findAll();
    }

    public Orders findOne(int id) {
        return dao.findOne(id);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
