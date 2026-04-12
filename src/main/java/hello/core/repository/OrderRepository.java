package hello.core.repository;

import hello.core.domain.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Orders save(Orders orders);
    Optional<Orders> findById (Orders orders);
    List<Orders> findAll();

}
