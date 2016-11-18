package autohaus.dao;

import autohaus.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakeDao extends JpaRepository<Make, Integer> {
}
