package hello.core.repository;

import hello.core.domain.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    void save(Orders orders);
    Optional<Orders> findOrderId (Orders orders);
    List<Orders> findAll();

}
