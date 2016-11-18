package autohaus.service;

import autohaus.entity.Country;

import java.util.List;

public interface CountryService {

    void save(Country object);

    List<Country> findAll();

    Country findOne(int id);

    void delete(int id);

}
