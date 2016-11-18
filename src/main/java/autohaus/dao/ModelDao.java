package autohaus.dao;

import autohaus.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelDao extends JpaRepository<CarModel, Integer> {
}
