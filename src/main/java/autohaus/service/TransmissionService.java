package autohaus.service;

import autohaus.entity.Transmission;

import java.util.List;

public interface TransmissionService {

    void save(Transmission object);

    List<Transmission> findAll();

    Transmission findOne(int id);

    void delete(int id);

}
