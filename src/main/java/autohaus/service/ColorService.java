package autohaus.service;

import autohaus.entity.Color;

import java.util.List;

public interface ColorService {

    void save(Color object);

    List<Color> findAll();

    Color findOne(int id);

    void delete(int id);

}
