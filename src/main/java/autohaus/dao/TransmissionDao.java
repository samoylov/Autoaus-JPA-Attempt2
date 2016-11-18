package autohaus.dao;

import autohaus.entity.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionDao extends JpaRepository<Transmission, Integer> {
}
