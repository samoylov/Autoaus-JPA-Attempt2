package autohaus.dao;

import autohaus.entity.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineDao extends JpaRepository<Engine, Integer> {
}
