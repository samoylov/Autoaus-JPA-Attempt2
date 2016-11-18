package autohaus.service;

import autohaus.entity.Make;

import java.util.List;

public interface MakeService {

    void save(Make object);

    List<Make> findAll();

    Make findOne(int id);

    void delete(int id);

}
