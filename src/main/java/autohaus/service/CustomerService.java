package autohaus.service;

import autohaus.entity.Customer;

import java.util.List;

public interface CustomerService {

    void save(Customer object);
    List<Customer> findAll();
    Customer findOne(int id);
    void delete(int id);

}
