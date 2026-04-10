package hello.core.repository;

import hello.core.domain.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryOrderRepository implements OrderRepository {

    ConcurrentHashMap<Long, Orders> order_store = new ConcurrentHashMap<Long, Orders>();


    @Override
    public void save(Orders order) {
        order_store.put(order.getOrderId(), order);
    }

    @Override
    public Optional<Orders> findOrderId(Orders orders) {
        return Optional.ofNullable(order_store.get(orders.getOrderId()));
    }

    @Override
    public List<Orders> findAll() {
        List<Orders> ordersList = new ArrayList<>(order_store.values());
        return ordersList;
    }

}

