package hello.core.repository;

import hello.core.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<Orders, Long>, OrderRepository {


}
