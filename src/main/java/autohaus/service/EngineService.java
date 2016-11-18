package autohaus.service;

import autohaus.entity.Engine;

import java.util.List;

public interface EngineService {

    void save(Engine object);

    List<Engine> findAll();

    Engine findOne(int id);

    void delete(int id);

}
