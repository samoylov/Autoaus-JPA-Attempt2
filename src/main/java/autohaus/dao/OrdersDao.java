package autohaus.dao;

import autohaus.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersDao extends JpaRepository<Orders, Integer> {
}
