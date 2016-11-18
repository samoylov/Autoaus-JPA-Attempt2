package autohaus.dao;

import autohaus.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorDao extends JpaRepository<Color, Integer> {
}
