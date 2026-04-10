package hello.core.service;


import hello.core.discount.DiscountPolicy;
import hello.core.domain.Member;
import hello.core.domain.Orders;
import hello.core.domain.Product;
import hello.core.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final DiscountPolicy discountPolicy;
    private final OrderRepository orderrepository;

    public OrderService(DiscountPolicy discountPolicy, OrderRepository orderrepository) {
        this.discountPolicy = discountPolicy;
        this.orderrepository = orderrepository;
    }

    public Orders createOrders(Member member, Product product) {
        Orders orders = new Orders(member.getId(), product.getProductId(), product.getItemPrice());
        double price = discountPolicy.discount(member, product.getItemPrice());
        orders.setDiscountPrice(price);
        orderrepository.save(orders);
        return orders;
    }

}
