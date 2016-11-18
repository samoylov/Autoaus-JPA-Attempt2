package autohaus.service;

import autohaus.entity.Orders;

import java.util.List;

public interface OrdersService {

    void save(Orders object);

    List<Orders> findAll();

    Orders findOne(int id);

    void delete(int id);

}
