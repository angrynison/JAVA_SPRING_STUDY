package hello.core.service;


import hello.core.discount.DiscountPolicy;
import hello.core.domain.Member;
import hello.core.domain.Orders;
import hello.core.domain.Product;
import hello.core.repository.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final DiscountPolicy discountPolicy;
    private final OrderRepository orderrepository;

    public OrderService(DiscountPolicy discountPolicy, OrderRepository orderrepository) {
        this.discountPolicy = discountPolicy;
        this.orderrepository = orderrepository;
    }


    //Jpa 로 어떻게 바뀔지 한번 보자
    @Transactional
    public Orders createOrders(Member member, Product product, int orderCount) {
        product.removeStocks(orderCount);
        Orders orders = new Orders(member.getId(), product.getProductId(), orderCount);
        double original_price = orderCount*product.getItemPrice();
        double discount_price = discountPolicy.discount(member, original_price);
        orders.setProductPrice(original_price);
        orders.setDiscountPrice(discount_price);
        orderrepository.save(orders);
        return orders;
    }

}
